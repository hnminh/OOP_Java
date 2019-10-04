package assignments3;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListShow {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayListCollection> date = new ArrayList<>();
        String readDate;
        int readYear;
        
        for (;;) {
            System.out.println("Enter a date to save (dd.mm.yyyy): ");
            readDate = sc.nextLine();
            if (readDate.equals("")) break;
            date.add(new ArrayListCollection(readDate));
        }

        System.out.println("Dates entered:");
        for (int i = 0; i < date.size(); i++) {
            System.out.println(date.get(i).getDate());
        }

        ArrayListCollection d;
        for (;;) {
            int i;
            System.out.println("Enter a date to search (dd.mm.yyyy): ");
            readDate = sc.nextLine();
            if (readDate.equals("")) break;
            d = new ArrayListCollection(readDate);
            for (i = 0; i < date.size(); i++) {
                if (date.get(i).equals(d)) { 
                    System.out.println("Index: " + (i + 1));
                    break;
                }
            }
            if (i == date.size()) System.out.println("The date is not found");
        }

        System.out.println("Enter a year: ");
        readYear = sc.nextInt();
        System.out.println("Dates have the given year: ");
        for (int i = 0; i < date.size(); i++) {
            if (readYear == date.get(i).getYear()) System.out.println(date.get(i).getDate());
        }
    }
}