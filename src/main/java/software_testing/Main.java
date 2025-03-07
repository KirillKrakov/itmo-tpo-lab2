package software_testing;

import software_testing.logarithms.Logarithm;
import software_testing.logarithms.NaturalLogarithm;
import software_testing.trigonometrics.Cosecant;
import software_testing.trigonometrics.Cosinus;
import software_testing.trigonometrics.Sinus;

public class Main {
    public static void main(String[] args) {
        NaturalLogarithm ln = new NaturalLogarithm();
//        System.out.println(ln.ln(0.1));
//        System.out.println(ln.ln(10));
//        System.out.println(ln.ln(0.1, 0.01));
        Logarithm log = new Logarithm();
//        System.out.println(log.log(4,2));

        Sinus sin = new Sinus();
        Cosinus cos = new Cosinus();
        Cosecant csc = new Cosecant();
//        System.out.println(sin.sin(Math.PI/6));
//        System.out.println(sin.sin(Math.PI/2));
//        System.out.println(sin.sin(Math.PI/6,0.1));
        System.out.println(csc.csc(Math.PI-0.00000000000001));
        System.out.println(csc.csc(Math.PI+0.00000000000001));

//        System.out.println(sin.sin(-2.4));
//        System.out.println(cos.cos(-2.4));
//        System.out.println(csc.csc(-2.4));

        FunctionSystem fs = new FunctionSystem();
//        System.out.println(fs.myFunction(-2.4));
        System.out.println(fs.myFunction(1));
        fs.writeToCSV("fs1.csv",-2.4,1,5);
        fs.writeToCSV("fs2.csv",0.01,-2.4,1,5);
        log.writeToCSV("log1.csv",2,3,1,5);
        log.writeToCSV("log2.csv",0.01,2,3,1,5);
    }
}