package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilities.PasswordService;
import model.Customer;
import dbHelpers.CustomerLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private static int loginAttempts;
	private String url;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get current session
		session = request.getSession();
		loginAttempts++;
		
		// handle exceeded login attempts
		if(loginAttempts > 2){
			String errorMessage = "Number of login attempts has been exceded.";
			request.setAttribute("errorMessage", errorMessage);
		} else {
			// proceed by pulling fields from the login form
			String uName = request.getParameter("uName");
			String password = request.getParameter("password");
			
			// encrypt the password
			PasswordService ps = new PasswordService();
			String encryptedPW = ps.encrypt(password);
			
			// create a CustomerLogin object and authenticate login
			CustomerLogin cl = new CustomerLogin();
			Customer customer = cl.authenticateCustomer(uName, encryptedPW);
			
			// is there a customer that matches the credentials?
			if(customer != null){
				// invalidate current session, and get new session for customer 
				// to combat session hijacking
				session.invalidate();
				session = request.getSession(true);
				session.setAttribute("customer", customer);
				url = "userAccount.jsp";
			} else {
				// customer doesn't exist
				String errorMessage = "Error: Unrecognized username and/or password<br>"
						+ "Login attempts remaining: " + (3-(loginAttempts));
				request.setAttribute("errorMessage", errorMessage);
				
				// track number of login attempts
				session.setAttribute("loginAttempts", loginAttempts);
				url = "index.jsp";
			}
		}
		
		//forward the request
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	/**
	 * Logs the customer out of the account
	 */
	public void logout(){
		session.invalidate();
	}
}
