package software_testing.trigonometrics;

import static java.lang.Math.pow;

public class Sinus {
    public static long factorial(int x) {
        if (x <= 1) return 1;
        long result = x;
        for (int i = x - 1; i > 1; i--)
            result *= i;

        return result;
    }

    public static double sin(double x, double epsilon) {
        x %= 2 * Math.PI;
        double result = 0;
        int i = 0;
        double term;
        do {
            term = pow(-1, i) * pow(x, 2 * i + 1) / factorial(2 * i + 1);
            result += term;
            i++;
        } while (Math.abs(term) > epsilon);

        return result;
    }

    public static double sin(double x) {
        return sin(x,0.00001);
    }
}
