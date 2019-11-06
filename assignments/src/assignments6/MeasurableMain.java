package assignments6;

import java.util.ArrayList;

public class MeasurableMain {
    public static void main(String[] args) {
        ArrayList<Measurable> shapes = new ArrayList<>();
        shapes.add(new Rectangle());
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Rectangle(2, 5, 4, 8));
        shapes.add(new Circle());
        shapes.add(new Circle(5));
        shapes.add(new Circle(3, 8, 4));

        for (int i = 0; i < shapes.size(); i++){
            System.out.println("Shape " + (i + 1));
            System.out.println("Area: " + shapes.get(i).area() + ", Perimeter: " + shapes.get(i).perimeter());
        }
        System.out.println();

        for (int i = 0; i < shapes.size(); i++){
            System.out.println("Shape " + (i + 1));
            int rand = (int)(Math.random()*5 + 1);
            shapes.get(i).scale(rand);
            System.out.println("Scale factor: " + rand);
            System.out.println("Area: " + shapes.get(i).area() + ", Perimeter: " + shapes.get(i).perimeter());
        }
    }
}