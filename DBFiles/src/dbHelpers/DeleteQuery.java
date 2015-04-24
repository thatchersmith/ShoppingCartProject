package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 
 * @author Conner McKeeth
 *
 */
public class DeleteQuery {
	private Connection connection;
	
	public DeleteQuery(String dbName, String uname, String pwd)
	{
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doDelete(String sku)
	{
		// Set up a String to hold our query
		String query = "delete from products where sku = ?";
		
		// Create a prepared statement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, sku);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
