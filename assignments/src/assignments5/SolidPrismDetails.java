package assignments5;

public class SolidPrismDetails {
    public static void main(String[] args) {
        PrismExtend p = new PrismExtend();
        p.depth = 12;
        p.height = 3;
        p.width = 4.5;
        p.density = 7.1;
        System.out.println("The mass of the prism is " + p.calculateMass());
    }
}