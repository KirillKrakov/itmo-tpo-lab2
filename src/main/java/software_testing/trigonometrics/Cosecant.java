package software_testing.trigonometrics;

import static java.lang.Math.PI;

public class Cosecant {
    public static double csc(double x, double epsilon) {
        if (x % PI == 0) throw new IllegalArgumentException("Деление на ноль при попытке найти косеканс угла, кратного ПИ");
        return 1 / Sinus.sin(x, epsilon);
    }

    public static double csc(double x) {
        return csc(x, 0.00001);
    }
}
