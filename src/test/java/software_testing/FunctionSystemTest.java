package software_testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import software_testing.trigonometrics.Cosecant;
import software_testing.trigonometrics.Sinus;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionSystemTest {
    @ParameterizedTest
    @ValueSource(doubles = {0, -0.1, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void testEpsilonWithIllegalArgument(double epsilon) {
        assertThrows(IllegalArgumentException.class, () -> new Sinus().sin(PI,epsilon));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, -PI, -PI * 4,Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void testFunctionSystemWithIllegalArgument(double x) {
        assertThrows(IllegalArgumentException.class, () -> new FunctionSystem().myFunction(x));
    }

    @ParameterizedTest
    @CsvSource({
            "-1000, 0.944865532838",
            "-8.6394, 0.0000285719850437",
            "-8.7, 0.0967497537118",
            "-0.001, 1000.99916617"
    })
    void testMyFunctionLessThanZero(double x, double expected) {
        FunctionSystem functionSystem = new FunctionSystem();
        double result = functionSystem.myFunction(x);
        assertEquals(expected, result, 0.00001);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 19.9315685693",
            "0.99, -0.0289991393902",
            "1.01, 0.0287105859541",
            "8.7, 6.24203080192",
            "0.001, -19.9315685693"
    })
    void testMyFunctionMoreThanZero(double x, double expected) {
        FunctionSystem functionSystem = new FunctionSystem();
        double result = functionSystem.myFunction(x);
        assertEquals(expected, result, 0.001);
    }
}
