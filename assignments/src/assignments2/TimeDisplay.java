package assignments2;

import java.util.Scanner;

public class TimeDisplay {
    public static void main(String[] args) {

        Time t = new Time();
        System.out.println("Current date: " + t.getTime() + "\n");
        t = new Time(20, 10, 2018);
        System.out.println(t.getTime() + "\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a day: ");
        t.setDay(sc.nextInt());
        System.out.println("Enter a month (number): ");
        t.setMonth(sc.nextInt());
        System.out.println("Enter a year: ");
        t.setYear(sc.nextInt());
        System.out.println("The date entered: " + t.getTime() + "\n");

        sc.nextLine();
        System.out.println("Enter a date (dd.mm.yyyy): ");
        t = new Time(sc.nextLine());
        System.out.println(t.getLongTime());

        Time t1 = new Time();
        if (t.equals(t1)) {
            System.out.println("The entered date is the same as current date");
        } else {
            System.out.println("The entered date is not the same as current date");
        }
        
        System.out.println("Enter a month name: ");
        System.out.println(Time.getMonthNumber(sc.nextLine()));
    }
}