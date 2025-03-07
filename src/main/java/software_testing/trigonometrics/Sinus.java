package software_testing.trigonometrics;

import software_testing.csv.CSVWriter;

import static java.lang.Math.pow;

public class Sinus {
    public long factorial(int x) {
        if (x <= 1) return 1;
        long result = x;
        for (int i = x - 1; i > 1; i--)
            result *= i;

        return result;
    }

    public double sin(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isNaN(epsilon)) throw new IllegalArgumentException("x и epsilon не должны быть NaN");
        if (Double.isInfinite(x) || Double.isInfinite(epsilon)) throw new IllegalArgumentException("x и epsilon не могут быть бесконечными");
        if (epsilon <= 0) throw new IllegalArgumentException("Значение epsilon должно быть больше нуля");
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

    public double sin(double x) {
        return sin(x,0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,begin,step,count,this::sin, "Epsilon,X,sin(X)");
    }

    public void writeToCSV(String filename, double begin, double step, int count) {
        CSVWriter.write(filename,begin,step,count,this::sin, "X,sin(X)");
    }
}
