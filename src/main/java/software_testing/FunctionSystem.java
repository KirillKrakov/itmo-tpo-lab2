package software_testing;

import software_testing.csv.CSVWriter;
import software_testing.logarithms.Logarithm;
import software_testing.trigonometrics.Cosecant;
import software_testing.trigonometrics.Cosinus;
import software_testing.trigonometrics.Sinus;

import static java.lang.Math.pow;

public class FunctionSystem {
    public double myFunction(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isNaN(epsilon)) throw new IllegalArgumentException("x и epsilon не могут быть NaN");
        if (Double.isInfinite(x) || Double.isInfinite(epsilon)) throw new IllegalArgumentException("x и epsilon не могут быть бесконечными");
        if (x <= 0) {
            Sinus sin = new Sinus();
            Cosinus cos = new Cosinus();
            Cosecant csc = new Cosecant();
            return (cos.cos(x,epsilon) + sin.sin(x,epsilon)) - csc.csc(x,epsilon);
        } else {
            if (x == 1) throw new IllegalArgumentException("Деление на ноль - знаменатель дроби log10(1) = 0");
            Logarithm log = new Logarithm();
            double numerator = (log.log(x,2,epsilon) + log.log(x,2,epsilon)) * pow(log.log(x,10,epsilon),2);
            return (numerator / log.log(x,10,epsilon)) / log.log(x,10,epsilon);
        }
    }

    public double myFunction(double x) {
        return myFunction(x, 0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,begin,step,count,this::myFunction, "Epsilon,X,myFunc(X)");
    }

    public void writeToCSV(String filename, double begin, double step, int count) {
        CSVWriter.write(filename,begin,step,count,this::myFunction, "X,myFunc(X)");
    }
}
