package software_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import software_testing.trigonometrics.Cosecant;
import software_testing.trigonometrics.Cosinus;
import software_testing.trigonometrics.Sinus;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static java.lang.Math.PI;
import static org.mockito.Mockito.when;

public class TrigonometryTest {

    @ParameterizedTest
    @CsvSource({
            "-1, 1",
            "0, 1",
            "3, 6",
            "5, 120",
            "7, 5040"
    })
    void testFactorial(int x, long expected) {
        long result = new Sinus().factorial(x);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.785, 0.706825181105",
            "-0.785, -0.706825181105",
            "1.571, 0.999999979259",
            "-1.571, -0.999999979259",
            "10000, -0.305614388888",
            "-10000, 0.305614388888"
    })
    void testSinus(double x, double expected) {
        double result = new Sinus().sin(x);
        assertEquals(expected, result, 0.00001);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.785, 0.706825181105",
            "-0.785, -0.706825181105",
            "1.571, 0.999999979259",
            "-1.571, -0.999999979259",
            "10000, -0.305614388888",
            "-10000, 0.305614388888"
    })
    void testSinusWithOwnEpsilon(double x, double expected) {
        double result = new Sinus().sin(x,0.0000001);
        assertEquals(expected, result, 0.0000001);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 0",
            "0.785, 0.707388269167, 0.706825181105",
            "-0.785, 0.707388269167, -0.706825181105",
            "1.571, -0.000203673203695, 0.999999979259",
            "-1.571, -0.000203673203695, -0.999999979259",
            "10000, -0.952155368259, -0.305614388888",
            "-10000, -0.952155368259, 0.305614388888"
    })
    void testCosinus(double x, double expected, double sin) {
        double epsilon = 0.00001;
        try(MockedConstruction<Sinus> mockedSine = Mockito.mockConstruction(Sinus.class,
                (mock, context) -> when(mock.sin(x, epsilon)).thenReturn(sin))) {

            double result = new Cosinus().cos(x);
            assertEquals(expected, result, epsilon);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0.785, 1.41477698692, 0.706825181105",
            "-0.785, -1.41477698692, -0.706825181105",
            "1.571, 1.00000002074, 0.999999979259",
            "-1.571, -1.00000002074, -0.999999979259",
            "10000, -3.27209724528, -0.305614388888",
            "-10000, 3.27209724528, 0.305614388888"
    })
    void testCosecant(double x, double expected, double sin) {
        double epsilon = 0.00001;
        try(MockedConstruction<Sinus> mockedSine = Mockito.mockConstruction(Sinus.class,
                (mock, context) -> when(mock.sin(x, epsilon)).thenReturn(sin))) {

            double result = new Cosecant().csc(x);
            assertEquals(expected, result, epsilon);
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, PI, -PI, PI * 4, -PI * 4})
    void testCosecantWithIllegalArgument(double x) {
        assertThrows(IllegalArgumentException.class, () -> new Cosecant().csc(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void testSinusCosinusWithIllegalArgument(double x) {
        assertThrows(IllegalArgumentException.class, () -> new Sinus().sin(x));
        assertThrows(IllegalArgumentException.class, () -> new Cosinus().cos(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -0.1,Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void testEpsilonWithIllegalArgument(double epsilon) {
        assertThrows(IllegalArgumentException.class, () -> new Sinus().sin(PI,epsilon));
    }
}
