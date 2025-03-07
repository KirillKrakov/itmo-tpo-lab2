package software_testing.math_functions;

public class Logarithm {
    public static double log(double base, double x) {
        if (base == 0 || base == 1) throw new IllegalArgumentException();
        return NaturalLogarithm.ln(x) / NaturalLogarithm.ln(base);
    }
}
