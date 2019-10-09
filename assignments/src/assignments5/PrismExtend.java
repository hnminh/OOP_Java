package assignments5;

public class PrismExtend extends Prism {
    public double density;

    public double calculateMass() {
        return super.volume()*density;
    }
}