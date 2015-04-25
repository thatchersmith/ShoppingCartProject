package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		Cart cart = (Cart)session.getAttribute("cart");
		ArrayList<Product> inventory = (ArrayList<Product>)session.getAttribute("inventory");
		int id = Integer.parseInt(request.getAttribute("id"));
		int qty = Integer.parseInt(request.getAttribute("quantity"));
		
		
		//finds matching product in inventory the list and adds it to the cart
		int i;
		for(i = 0; i <= inventory.size() - 1; i++)
		{
			if(inventory.get(i).getId() == id)
			{
				cart.add(inventory.get(i));
				
			}
		}
		
		//updates product quantity
		inventory.get(i).setQuantity(inventory.get(i).getQuantity() - qty);
		
		// create an UpadteQuantityQuery object and use it to update product qty in databse
		UpdateQuantityQuery uq = new UpdateQuantityQuery("customer", "root", "password");
		uq.doUpdate(inventory.get(i));
				
		// pass control to the customerAccount
		String url = "product.jsp";
						
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
