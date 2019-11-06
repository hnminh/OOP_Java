package assignments6;

public class Rectangle implements Measurable {
    private double xLowerLeft, yLowerLeft, xUpperRight, yUpperRight;

    public Rectangle() {
        this.xLowerLeft = 0;
        this.yLowerLeft = 0;
        this.xUpperRight = 1;
        this.yUpperRight = 1;
    }

    public Rectangle(double x1, double y1) {
        this.xLowerLeft = 0;
        this.yLowerLeft = 0;
        this.xUpperRight = x1;
        this.yUpperRight = y1;
    }

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.xLowerLeft = x1;
        this.yLowerLeft = y1;
        this.xUpperRight = x2;
        this.yUpperRight = y2;
    }

    public double rectangleWidth(){
        return Math.abs(xUpperRight - xLowerLeft);
    }

    public double rectangleHeight(){
        return Math.abs(yUpperRight - yLowerLeft);
    }

    public void scale(double scaleValue){
        xUpperRight = xLowerLeft + rectangleWidth()*scaleValue;
        yUpperRight = yLowerLeft + rectangleHeight()*scaleValue;
    }

    public double area(){
        return rectangleWidth()*rectangleHeight();
    }

    public double perimeter(){
        return 2*(rectangleWidth() + rectangleHeight());
    }
}