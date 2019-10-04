package homework2;

public class Fraction {
    private int numerator, denorminator;

    public Fraction() {
        numerator = 0;
        denorminator = 1;
    }

    public Fraction(int a, int b) {
        numerator = a;
        if (b == 0) denorminator = 1;
        else denorminator = b;
    }

    public String toString() {
        return numerator + "/" + denorminator;
    }

    public double toDouble() {
        return (double)numerator/denorminator;
    }

    public Fraction multiply(Fraction multiplier) {
        numerator = numerator*multiplier.numerator;
        denorminator = denorminator*multiplier.denorminator;
        return new Fraction(numerator, denorminator);
    }
}