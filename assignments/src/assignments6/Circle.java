package assignments6;

/*
 * A circle in a coordinate system
 */
public class Circle implements Measurable {

    private double cx; // centre x
    private double cy; // centre y
    private double r; // radius

    //----------------------------------------------------
    //Constructors
    public Circle() {
        this.cx = 0;
        this.cy = 0;
        this.r = 1;
    }

    public Circle(double r){
        this.cx = 0;
        this.cy = 0;
        this.r = Math.abs(r);
    }

    public Circle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = Math.abs(r);
    }

    //------------------------------------------------
    // Setters and getters
    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getR() {
        return r;
    }

    //-------------------------------------------
    //Other methods

    // Area of circle
    public double area() {
        return Math.PI * r * r;
    }

    public double perimeter(){
        return Math.PI*2*r;
    }

    public void scale(double scaleValue){
        r = r*scaleValue;
    }

} //End of Circle class