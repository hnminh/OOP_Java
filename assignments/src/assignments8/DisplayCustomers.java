package assignments8;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DisplayCustomers {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String path = "customersInformation.txt";

        try {
            BufferedReader input = new BufferedReader(new FileReader(path));
            String line;
            try {
                while ((line = input.readLine()) != null){
                    if (line.equals("customer")){
                        int customerNumber = Integer.parseInt(input.readLine());
                        String name = input.readLine();
                        String address = input.readLine();
                        customers.add(new Customer(customerNumber, name, address));
                    } else if (line.equals("preferred customer")){
                        int customerNumber = Integer.parseInt(input.readLine());
                        String name = input.readLine();
                        String address = input.readLine();
                        double purchases = Double.parseDouble(input.readLine());
                        customers.add(new PreferredCustomer(customerNumber, name, address, purchases));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

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