package software_testing.logarithms;

public class NaturalLogarithm {
    public static double ln(double x, double epsilon) {
        if (x <= 0) throw new IllegalArgumentException("Значение X должно быть больше нуля");
        if (x == 1) return 0;

        int sign = 1;
        if (x < 1) {
            sign = -1;
            x = 1 / x;
        }

        double y, result = 0, term;
        int i = 1;
        y = (x - 1) / x;
        term = y;

        while (Math.abs(term / (i * (1 - y))) >= epsilon) {
            result += term / i;
            term *= y;
            i++;
        }

        return sign * result;
    }

    public static double ln(double x) {
        return ln(x, 0.00001);
    }
}
