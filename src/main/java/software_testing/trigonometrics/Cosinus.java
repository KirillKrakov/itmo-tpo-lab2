package software_testing.trigonometrics;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class Cosinus {
    public static double cos(double x, double epsilon) {
        double result = sqrt(1 - pow(Sinus.sin(x, epsilon),2));
        double remain = x % (2 * PI);
        if (remain < 0) {
            if (remain > -3*PI/2 && remain < - PI/2) result *= -1;
        } else {
            if (remain > PI/2 && remain < 3*PI/2) result *= -1;
        }
        return result;
    }

    public static double cos(double x) {
        return cos(x, 0.00001);
    }
}
