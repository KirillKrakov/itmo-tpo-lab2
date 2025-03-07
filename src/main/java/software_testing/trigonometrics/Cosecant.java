package software_testing.trigonometrics;

import software_testing.csv.CSVWriter;

import static java.lang.Math.PI;

public class Cosecant {
    public double csc(double x, double epsilon) {
        //if (x % PI == 0) throw new IllegalArgumentException("Деление на ноль при попытке найти косеканс угла, кратного ПИ");
        Sinus sin = new Sinus();
        return 1 / sin.sin(x, epsilon);
    }

    public double csc(double x) {
        return csc(x, 0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,begin,step,count,this::csc, "Epsilon,X,csc(X)");
    }

    public void writeToCSV(String filename, double begin, double step, int count) {
        CSVWriter.write(filename,begin,step,count,this::csc, "X,csc(X)");
    }
}
