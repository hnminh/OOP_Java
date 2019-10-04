package assignments4;

public class DistributionPrinter {

    //private int min, max;

    public void printDistribution(Distribution value) {
        for (int i = value.getMin(); i <= value.getMax(); i++) {
            System.out.println("Value: " + i + "     Frequency: " + value.frequency(i));
        }
        System.out.println("Average: " + value.average());
    }
}