package assignments5;

import java.util.Scanner;

public class ClassRoom extends Room {
    private int seats, computers;
    private String dataProjector;

    public void askData() {
        super.askData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of seats: ");
        this.seats = sc.nextInt();
        System.out.println("Enter number of computers: ");
        this.computers = sc.nextInt();
        System.out.println("Does this room have data projector?");
        sc.nextLine();
        if (sc.nextLine().equals("no")) dataProjector = "no data projector";
        else dataProjector = "data projector";
    }

    public String toString() {
        return super.toString() + ", seats: " + seats + ", computers: " + computers + ", " + dataProjector;
    }
}