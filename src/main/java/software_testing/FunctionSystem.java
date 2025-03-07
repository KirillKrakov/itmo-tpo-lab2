package software_testing;

import software_testing.logarithms.Logarithm;
import software_testing.trigonometrics.Cosecant;
import software_testing.trigonometrics.Cosinus;
import software_testing.trigonometrics.Sinus;

import static java.lang.Math.pow;

public class FunctionSystem {
    public static double myFunction(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isNaN(epsilon)) throw new IllegalArgumentException("x и epsilon не могут быть NaN");
        if (Double.isInfinite(x) || Double.isInfinite(epsilon)) throw new IllegalArgumentException("x и epsilon не могут быть бесконечными");
        if (x <= 0) {
            return (Cosinus.cos(x,epsilon) + Sinus.sin(x,epsilon)) - Cosecant.csc(x,epsilon);
        } else {
            if (x == 1) throw new IllegalArgumentException("Деление на ноль - знаменатель дроби log10(1) = 0");
            double numerator = (Logarithm.log(2,x,epsilon) + Logarithm.log(2,x,epsilon)) * pow(Logarithm.log(10,x,epsilon),2);
            return (numerator / Logarithm.log(10,x,epsilon)) / Logarithm.log(10,x,epsilon);
        }
    }

    public static double myFunction(double x) {
        return myFunction(x, 0.00001);
    }
}
