package assignments5;

public class PreferredCustomer extends Customer {
    private double purchases;

    public PreferredCustomer(int customerNumber, String name, String address, double purchases) {
        super(customerNumber, name, address);
        this.purchases = purchases;
    }

    public double calculateBonus() {
        if (purchases < 500) return 0;
        else if (purchases >= 500 && purchases <= 1000) return purchases*0.02;
        else return purchases*0.05;
    }

    public String customerData() {
        return super.customerData() + "\nPurchases: " + purchases + "     Bonus: " + calculateBonus();
    }
}