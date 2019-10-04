package assignments4;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Distribution value = new Distribution(0, 5);
        Scanner sc = new Scanner(System.in);
        String readValue;
        for (;;) {
            System.out.println("Enter a grade: ");
            readValue = sc.nextLine();
            if (readValue.equals("")) break;
            else value.insertValue(Integer.parseInt(readValue));
        }
        sc.close();
        DistributionPrinter dp = new DistributionPrinter();
        dp.printDistribution(value);
    }
}