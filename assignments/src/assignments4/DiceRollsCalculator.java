package assignments4;

import java.util.Scanner;

public class DiceRollsCalculator {
    public static void main(String[] args) {
        Distribution value = new Distribution(1, 6);
        Scanner sc = new Scanner(System.in);
        String readValue;
        for (;;) {
            System.out.println("Do you want to roll the dice? (y/n): ");
            readValue = sc.nextLine();
            if (readValue.equals("n") || readValue.equals("N")) break;
            else if (readValue.equals("y") || readValue.equals("Y")) {
                DiceRoller dr = new DiceRoller();
                int score = dr.rollTheDice();
                value.insertValue(score);
                System.out.println("Score: " + score);
            }
        }
        sc.close();
        DistributionPrinter dp = new DistributionPrinter();
        dp.printDistribution(value);
    }
}