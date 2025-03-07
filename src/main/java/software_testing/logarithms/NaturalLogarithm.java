package software_testing.logarithms;

import software_testing.csv.CSVWriter;

public class NaturalLogarithm {
    public double ln(double x, double epsilon) {
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

    public double ln(double x) {
        return ln(x, 0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,begin,step,count,this::ln, "Epsilon,X,ln(X)");
    }

    public void writeToCSV(String filename, double begin, double step, int count) {
        CSVWriter.write(filename,begin,step,count,this::ln, "X,ln(X)");
    }
}
