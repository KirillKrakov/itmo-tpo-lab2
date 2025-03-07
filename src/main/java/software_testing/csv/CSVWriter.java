package software_testing.csv;

import io.vavr.Function3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CSVWriter {

    public static void write(String filename, double begin, double step, int count, Function<Double, Double> f,
                             String headers) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            double cur = begin;
            writer.println(headers);
            for (int i = 0; i < count; i++) {
                writer.println(String.format(Locale.ENGLISH, ".+,.+", cur, f.apply(cur)));
                cur += step;
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static void write(String filename, double fixed, double begin,
                             double step, int count, BiFunction<Double, Double, Double> f, String headers) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            double cur = begin;
            writer.println(headers);
            for (int i = 0; i < count; i++) {
                writer.println(String.format(Locale.ENGLISH, ".+,.+,.+", fixed, cur, f.apply(cur, fixed)));
                cur += step;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static void write(String filename, double fixed, double fixed2, double begin,
                             double step, int count, Function3<Double, Double, Double, Double> f, String headers) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            double cur = begin;
            writer.println(headers);
            for (int i = 0; i < count; i++) {
                writer.println(String.format(Locale.ENGLISH, ".+,.+,.+", fixed, fixed2, cur, f.apply(cur, fixed2, fixed)));
                cur += step;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
