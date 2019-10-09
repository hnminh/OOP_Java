package assignments5;

import java.util.Scanner;

public class Room {
    private String roomNumber, description;

    public void askData() {
        Scanner sc = new Scanner(System.in);
        //String a = sc.nextLine();
        System.out.println("Enter room number: ");
        this.roomNumber = sc.nextLine();
        System.out.println("Enter description: ");
        this.description = sc.nextLine();
    }

    public String toString(){
        return "Room: " + roomNumber + ", " + description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}