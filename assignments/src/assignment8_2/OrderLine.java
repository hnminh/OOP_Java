package assignment8_2;

public class OrderLine {
	private String name;
	private double price;
	private int quantity;
	
	public OrderLine(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getProductSum() {
		return (price*quantity);
	}
	
	public String getProductName() {
		return name;
	}
	
	public double getProductPrice() {
		return price;
	}
	
	public int getProductQuantity() {
		return quantity;
	}
}
