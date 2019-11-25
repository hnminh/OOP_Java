package assignments8;

public class Customer {
    private int customerNumber;
    private String name, address;

    public Customer(int customerNumber, String name, String address) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.address = address;
    }

    public String customerData() {
        return "Customer number: " + customerNumber + "\nName: " + name + "\nAddress: " + address;
    }
}