package assignments4;

import java.util.ArrayList;

public class OrderInformation {
	
	private int orderID;
	private String customerName;
	private Date orderDate;
	private String[] productNames = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
	private double[] productPrices = {2.99, 1.99, 2.39, 4.99, 1.09};
	private ArrayList<OrderLine> receipt = new ArrayList<>();
	
	public OrderInformation(int orderID, String customerName, int day, int month, int year) {
		this.orderID = orderID;
		this.customerName = customerName;
		this.orderDate = new Date(day, month, year);
	}
	
	public void addOrderDetails() {
		int number = (int)(Math.random()*5) + 1;	
		for (int i = 0; i < number; i++) {
			receipt.add(new OrderLine(productNames[i], productPrices[i], (int)(Math.random()*10) + 1));
		}
	}
	
	/*	FOR LATER USE
	 
		public void addOrderDetails(String name, double price, int quantity) {
			receipt.add(new OrderLine(name, price, quantity);
		}

	*/
	

	// FOR DEBUGGING
	/*
		public void showOrderDetails() {
			for (int i = 0; i < receipt.size(); i++) {
				System.out.println(receipt.get(i).getProductSum());
			}
		}
	*/

	public double receiptTotalPrice() {
		double sum = 0;
		for (int i = 0; i < receipt.size(); i++) sum += receipt.get(i).getProductSum();
		//System.out.println(sum);	// FOR DEBUGGING
		return sum;
	}

	public String printReceipt() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order ID: "); sb.append(orderID); sb.append("\n");
		sb.append("Customer: "); sb.append(customerName); sb.append("\n");
		sb.append("Order date: "); sb.append(orderDate.getDate()); sb.append("\n");

		StringBuilder s = new StringBuilder();
		s.append("Product");
		for (int i = s.length(); i <= 20; i++) s.append(" ");
		s.append("Price");
		for (int i = s.length(); i <= 30; i++) s.append(" ");
		s.append("Quantity");
		for (int i = s.length(); i <= 45; i++) s.append(" ");
		s.append("Sum");
		s.append("\n");
		sb.append(s.toString());		

		for (int i = 0; i < receipt.size(); i++) {
			s = new StringBuilder();
			s.append(receipt.get(i).getProductName());
			for (int j = s.length(); j <= 20; j++) s.append(" ");
			s.append(receipt.get(i).getProductPrice());
			for (int j = s.length(); j <= 30; j++) s.append(" ");
			s.append(receipt.get(i).getProductQuantity());
			for (int j = s.length(); j <= 45; j++) s.append(" ");
			s.append(receipt.get(i).getProductSum());
			s.append("\n");
			sb.append(s.toString());
		}

		sb.append("Total price: " + receiptTotalPrice());
		
		String result = sb.toString();

		return result;
	}
	
}
