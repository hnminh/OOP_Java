package exam;

import java.util.Scanner;

public class CarMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car car1 = new Car();
		
		try {
			System.out.println("Enter the brand name: ");
			car1.setBrand(sc.nextLine());
			System.out.println("Enter the model year:");
			car1.setModelYear(sc.nextInt());
			sc.nextLine();	// must use after the nextInt() to enter a new string
			System.out.println("Enter the registration number:");
			car1.setRegistrationNumber(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Brand: " + car1.getBrand());
		System.out.println("Model: " + car1.getModelYear());
		System.out.println("Registration number: " + car1.getRegistrationNumber());
		
		if (car1.getBrand().equals("Mercedes")) {
			System.out.println("Praise");
		} else {
			System.out.println("Pan");
		}
		
		sc.close();
	}

}
