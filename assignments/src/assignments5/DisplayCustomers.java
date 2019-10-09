package assignments5;

import java.util.ArrayList;

public class DisplayCustomers {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(495, "Jill", "Wolffintie"));
        customers.add(new Customer(374, "Dave", "Wolffintie"));
        customers.add(new PreferredCustomer(123, "Anna", "Wolffintie", 405.2));
        customers.add(new PreferredCustomer(234, "Bill", "Ahventie", 600));
        customers.add(new PreferredCustomer(3234, "Jack", "Olympiakatu", 1234.5));
        
        String st;

        for (int i = 0; i < customers.size(); i++) {
            st = customers.get(i).customerData();
            if (!st.contains("Bonus"))
               System.out.println(customers.get(i).customerData() + "\n");
        }
        System.out.println();

        for (int i = 0; i < customers.size(); i++) {
            st = customers.get(i).customerData();
            if (customers.get(i) instanceof PreferredCustomer)
               System.out.println(customers.get(i).customerData() + "\n");
        }
    }
}