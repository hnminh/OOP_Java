package assignments2;

public class Rectangle {
    private double xL, yL, xR, yR;

    public Rectangle() {
        this.xL = 0;
        this.yL = 0;
        this.xR = 1;
        this.yR = 1;
    }

    public Rectangle(double x1, double y1) {
        this.xL = 0;
        this.yL = 0;
        this.xR = x1;
        this.yR = y1;
    }

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.xL = x1;
        this.yL = y1;
        this.xR = x2;
        this.yR = y2;
    }

    public double rectangleWidth(){
        return Math.abs(xR - xL);
    }

    public double rectangleHeight(){
        return Math.abs(yR - yL);
    }

    public double rectangleArea(){
        return rectangleWidth()*rectangleHeight();
    }
}