package assignments1;

public class OrderLine {
	private String name;
	private double price;
	private int quantity;
	
	public double productTotalPrice() {
		return (price*quantity);
	}
	
	public void setProductName(String a) {
		name = a;
	}

	public void setProductPrice(double x) {
		price = x;
	}

	public void setProductQuantity(int n) {
		quantity = n;
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
