package assignments1;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		System.out.println("What is your age?");
		int age = input.nextInt();
		System.out.println("Information\nName: " + name + "\nAge: " + age);
		//input.close();
	}

}
