package assignments5;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomServices {
    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();

        for (;;) {
            System.out.println("Choose a service");
            System.out.println("1. Insert an office");
            System.out.println("2. Insert a classroom");
            System.out.println("3. Insert another room (not office, not classroom)");
            System.out.println("4. Print out all rooms");
            System.out.println("5. Print out offices");
            System.out.println("6. Print out classrooms");
            System.out.println("7. Print out other rooms (not office, not classroom)");
            System.out.println("8. Search a room");
            System.out.println("9. Search a staff member");
            System.out.println("0: Exit");

            Scanner sc = new Scanner(System.in);

            int service = sc.nextInt();
            if (service == 1) {
                Office o = new Office();
                o.askData();
                rooms.add(o);
            }
            if (service == 2) {
                ClassRoom c = new ClassRoom();
                c.askData();
                rooms.add(c);
            }

            if (service == 3) {
                Room r = new Room();
                r.askData();
                rooms.add(r);
            }

            if (service == 4) {
                for (int i = 0; i < rooms.size(); i++)
                    System.out.println(rooms.get(i).toString());
            }
            if (service == 5) {
                for (int i = 0; i < rooms.size(); i++)
                    if (rooms.get(i) instanceof Office)
                        System.out.println((rooms.get(i)).toString());
            }
            if (service == 6) {
                for (int i = 0; i < rooms.size(); i++)
                    if (rooms.get(i) instanceof ClassRoom)
                        System.out.println((rooms.get(i)).toString());
            }
            if (service == 7) {
                for (int i = 0; i < rooms.size(); i++)
                    if (!(rooms.get(i) instanceof Office) && !(rooms.get(i) instanceof ClassRoom))
                        System.out.println((rooms.get(i)).toString());
            }
            if (service == 8) {
                sc.nextLine();
                System.out.println("Enter room number to search: ");
                String roomNumber = sc.nextLine();
                int i;
                for (i = 0; i < rooms.size(); i++)
                    if (roomNumber.equals(rooms.get(i).getRoomNumber())) {
                        System.out.println(rooms.get(i).toString());
                        break;
                    }
                if (i == rooms.size()) System.out.println("No room found!");
                
            }
            if (service == 9) {
                sc.nextLine();
                System.out.println("Enter staff name to search: ");
                String staffName = sc.nextLine();
                int i;
                for (i = 0; i < rooms.size(); i++)
                    if (rooms.get(i) instanceof Office && ((Office)rooms.get(i)).worksHere(staffName)) {
                        System.out.println("YES");
                        System.out.println(rooms.get(i).toString());
                        break;
                    }
                if (i == rooms.size()) System.out.println("NO");
            }

            if (service == 0) break;
        }
        //for (int i = 0; i < rooms.size(); i++)
        //    System.out.println(rooms.get(i));
    }
}