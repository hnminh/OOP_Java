package assignments1;

import java.util.Scanner;

public class OrderLineDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many lines the order has?");
		int number = sc.nextInt();

		OrderLine[] prod = new OrderLine[number];

		for (int i = 0; i < number; i++) {
			sc.nextLine();
			prod[i] = new OrderLine();
			System.out.print("Name of the product: ");
			prod[i].setProductName(sc.nextLine());
			System.out.print("Price of the product: ");
			prod[i].setProductPrice(sc.nextDouble());
			System.out.print("Quantity: ");
			prod[i].setProductQuantity(sc.nextInt());
		}

		double orderTotalPrice = 0;
		for (int i = 0; i < number; i++) {
			orderTotalPrice += prod[i].productTotalPrice();
		}

		System.out.println("Order total price: " + orderTotalPrice);
		
		
		/* 
		OrderLine prod1 = new OrderLine();
		prod1.setProduct("Orange", 3.14, 40);
		System.out.println("Name: " + prod1.getProductName());
		System.out.println("Price: " + prod1.getProductPrice());
		System.out.println("Quantity: " + prod1.getProductQuantity());
		System.out.println("Total price: " + prod1.productTotalPrice());
		*/
	}

}
