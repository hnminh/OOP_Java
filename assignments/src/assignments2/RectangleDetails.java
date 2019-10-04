package assignments2;

public class RectangleDetails {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle();
        System.out.println("Rectangle 1");
        System.out.println("Width: " + rec1.rectangleWidth());
        System.out.println("Height: " + rec1.rectangleHeight());
        System.out.println("Area: " + rec1.rectangleArea());

        Rectangle rec2 = new Rectangle(4.5, 2.6);
        System.out.println("\nRectangle 2");
        System.out.println("Width: " + rec2.rectangleWidth());
        System.out.println("Height: " + rec2.rectangleHeight());
        System.out.println("Area: " + rec2.rectangleArea());

        Rectangle rec3 = new Rectangle(3.2, 4.7, 7.4, 9.1);
        System.out.println("\nRectangle 3");
        System.out.println("Width: " + rec3.rectangleWidth());
        System.out.println("Height: " + rec3.rectangleHeight());
        System.out.println("Area: " + rec3.rectangleArea());
    }
}