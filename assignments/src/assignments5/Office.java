package assignments5;

import java.util.Scanner;

public class Office extends Room {
    private String staffMembers;

    public void askData() {
        super.askData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter staff member name: ");
        this.staffMembers = sc.nextLine();
    }

    public String toString() {
        return super.toString() + ", staff members: " + staffMembers;
    }

    public boolean worksHere(String name) {
        if (staffMembers.contains(name)) return true;
        else return false;
    }
}