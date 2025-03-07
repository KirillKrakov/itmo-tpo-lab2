package software_testing.logarithms;

public class Logarithm {
    public static double log(double base, double x, double epsilon) {
        if (base <= 0 || base == 1) throw new IllegalArgumentException("Основание логарифма должно быть больше 0 и не равно 1");
        return NaturalLogarithm.ln(x, epsilon) / NaturalLogarithm.ln(base,epsilon);
    }

    public static double log(double base, double x) {
        return log(base,x,0.00001);
    }
}
