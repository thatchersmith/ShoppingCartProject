/**
 * 
 */
package models;

/**
 * @author Conner McKeeth
 *
 */
public class Product {
	private String sku;
	private String type;
	private String flavor;
	private double cost;
	private double price;
	private int quantity;
	
	public Product() {
		this.sku = "1";
		this.type = "No Product Type";
		this.flavor = "No Flavor";
		this.cost = 0.00;
		this.price = 0.00;
		this.quantity = 0;
	}

	public Product(String sku, String productType, String flavor, double cost,
			double price, int quantity) {
		super();
		this.sku = sku;
		this.type = productType;
		this.flavor = flavor;
		this.cost = cost;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getType() {
		return type;
	}

	public void setType(String productType) {
		this.type = productType;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", type=" + type
				+ ", flavor=" + flavor + ", cost=" + cost + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
}
