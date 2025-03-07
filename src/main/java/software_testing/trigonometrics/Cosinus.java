package software_testing.trigonometrics;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Cosinus {
    public static double cos(double x, double epsilon) {
        return sqrt(1 - pow(Sinus.sin(x, epsilon),2));
    }

    public static double cos(double x) {
        return cos(x, 0.00001);
    }
}
