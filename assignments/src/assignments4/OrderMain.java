package assignments4;

public class OrderMain {
    public static void main(String[] args) {
        OrderInformation id = new OrderInformation(1056, "Charlie Brown", 18, 11, 2018);
        id.addOrderDetails();
        //id.showOrderDetails();
        id.receiptTotalPrice();
        System.out.println(id.printReceipt());
    }
}