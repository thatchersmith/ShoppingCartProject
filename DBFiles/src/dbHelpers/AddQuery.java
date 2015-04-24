/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Product;

/**
 * @author Conner McKeeth
 *
 */
public class AddQuery {
	
	public Connection connection;
	
	public AddQuery(String dbName, String uname, String pwd)
	{
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(Product product)
	{
		String query = "insert into products (sku, type, flavor, cost, price, quantity) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, product.getSku());
			ps.setString(2, product.getType());
			ps.setString(3, product.getFlavor());
			ps.setDouble(4, product.getCost());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getQuantity());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
