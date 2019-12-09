package exam;

public class Product extends Item{
	
	private double price;
	
	public Product(String name, double price) {
		super(name);
		this.price = price;
	}
	
	public double finalPrice() {
		return price*1.24;	// 0.24 is the tax rate
	}
	
	public String toString() {
		return "name: " + super.getName() + ", price: " + price;
	}
}
