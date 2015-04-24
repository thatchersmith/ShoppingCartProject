/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Product;

/**
 * @author Conner McKeeth
 *
 */
public class ReadRecord {
	private Connection connection;
	private ResultSet results;
	
	private Product product = new Product();
	private String sku;
	
	public ReadRecord(String dbName, String uname, String pwd, String sku)
	{
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.sku = sku;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void doRead()
	{
		String query = "select * from products where sku = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, this.sku);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			product.setSku(this.results.getString(1));
			product.setType(this.results.getString("type"));
			product.setFlavor(this.results.getString("flavor"));
			product.setCost(this.results.getDouble("cost"));
			product.setPrice(this.results.getDouble("price"));
			product.setQuantity(this.results.getInt("quantity"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Product getProduct()
	{
		return this.product;
	}
}
