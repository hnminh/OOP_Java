package assignments3;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapShow {
    public static void main(String[] args) {

        HashMap<Integer, Double> product = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Integer number;
        Double price;
        String st;

        System.out.println("Enter products details");
        for (;;) {
            System.out.println("Enter product number: ");
            st = sc.nextLine();
            if (st.equals("")) break;
            else number = Integer.parseInt(st);

            System.out.println("Enter price: ");
            st = sc.nextLine();
            if (st.equals("")) break;
            else price = Double.parseDouble(st);

            product.put(number, price);
        }

        System.out.println("Find product price");
        for (;;) {
            System.out.println("Enter product number: ");
            st = sc.nextLine();
            if (st.equals("")) break;
            else number = Integer.parseInt(st);

            if (product.containsKey(number)) System.out.println("Price: " + product.get(number));
            else System.out.println("Product not found");
        }
    }
}