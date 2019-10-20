package homework3;

public class OwnMaterials extends Materials {
    private double rawMaterialUnitPrice;
    private int rawMaterialAmount;

    public OwnMaterials(String name, int numberInStock, double rawMaterialUnitPrice, int rawMaterialAmount) {
        super(name, numberInStock);
        this.rawMaterialUnitPrice = rawMaterialUnitPrice;
        this.rawMaterialAmount = rawMaterialAmount;
    }

    public String toString() {
        return super.toString() + ", material unit price: " + rawMaterialUnitPrice + ", raw material amount: " + rawMaterialAmount;
    }

    public double calculateInventoryValue() {
        return rawMaterialUnitPrice*rawMaterialAmount*super.getNumberInStock();
    }
}