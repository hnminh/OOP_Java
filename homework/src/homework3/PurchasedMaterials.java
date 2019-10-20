package homework3;

public class PurchasedMaterials extends Materials {
    private double price;
    private String supplier;

    public PurchasedMaterials(String name, int numberInStock, double price, String supplier) {
        super(name, numberInStock);
        this.price = price;
        this.supplier = supplier;
    }

    public String toString() {
        return super.toString() + ", price: " + price + ", supplier: " + supplier;
    }

    public double calculateInventoryValue() {
        return price*super.getNumberInStock();
    }
}