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
public class ReadQuery {
	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String dbName, String uname, String pwd)
	{
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void doRead()
	{
		String query = "select * from products";
		
		try
		{
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable()
	{
		String table = "";
		table+= "<table class=\"table\">";
		try
		{
			while(this.results.next())
			{
				Product product = new Product();
				product.setSku(this.results.getString("sku"));
				product.setType(this.results.getString("type"));
				product.setFlavor(this.results.getString("flavor"));
				product.setCost(this.results.getDouble("cost"));
				product.setPrice(this.results.getDouble("price"));
				product.setQuantity(this.results.getInt("quantity"));
				
				table += "<tr>";
				table += "<td>";
				table += product.getSku();
				table += "</td>";
				table += "<td>";
				table += product.getType();
				table += "</td>";
				table += "<td>";
				table += product.getFlavor();
				table += "</td>";
				table += "<td>";
				table += product.getCost();
				table += "</td>";
				table += "<td>";
				table += product.getPrice();
				table += "</td>";
				table += "<td>";
				table += product.getQuantity();
				table += "</td>";
				table += "<td>";
					table += "<a href=update?sku=" + product.getSku() + ">update</a></td> "
							+ "<td><a href=delete?sku=" + product.getSku() + ">delete</a></td>";
				table += "</td>";
				table += "</tr>";
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return table;
	}
}
