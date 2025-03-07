package software_testing.trigonometrics;

import software_testing.csv.CSVWriter;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class Cosinus {
    public double cos(double x, double epsilon) {
        Sinus sin = new Sinus();
        double result = sqrt(1 - pow(sin.sin(x, epsilon),2));
        double remain = x % (2 * PI);
        if (remain < 0) {
            if (remain > -3*PI/2 && remain < - PI/2) result *= -1;
        } else {
            if (remain > PI/2 && remain < 3*PI/2) result *= -1;
        }
        return result;
    }

    public double cos(double x) {
        return cos(x, 0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,begin,step,count,this::cos, "Epsilon,X,cos(X)");
    }

    public void writeToCSV(String filename, double begin, double step, int count) {
        CSVWriter.write(filename,begin,step,count,this::cos, "X,cos(X)");
    }
}
