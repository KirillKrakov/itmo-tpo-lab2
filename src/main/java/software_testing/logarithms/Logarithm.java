package software_testing.logarithms;

import software_testing.csv.CSVWriter;

public class Logarithm {
    public double log(double x , double base, double epsilon) {
        if (base <= 0 || base == 1) throw new IllegalArgumentException("Основание логарифма должно быть больше 0 и не равно 1");
        NaturalLogarithm ln = new NaturalLogarithm();
        return ln.ln(x, epsilon) / ln.ln(base,epsilon);
    }

    public double log(double x, double base) {
        return log(base,x,0.00001);
    }

    public void writeToCSV(String filename, double epsilon, double base, double begin, double step, int count) {
        CSVWriter.write(filename,epsilon,base,begin,step,count,this::log, "Epsilon,N,X,logN(X)");
    }

    public void writeToCSV(String filename, double base, double begin, double step, int count) {
        CSVWriter.write(filename,base,begin,step,count,this::log, "N,X,logN(X)");
    }
}
