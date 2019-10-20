package homework3;

public abstract class Materials {
    private String name;
    private int numberInStock;

    public Materials(String name, int numberInStock) {
        this.name = name;
        this.numberInStock = numberInStock;
    }

    public String getName() {
        return name;
    }

    public int getNumberInStock() {
        return numberInStock;
    }
    
    public String toString() {
        return name + ", number in stock: " + numberInStock;
    }

    public abstract double calculateInventoryValue();
}