package software_testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import software_testing.logarithms.Logarithm;
import software_testing.logarithms.NaturalLogarithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class LogarithmTest {

    @ParameterizedTest
    @CsvSource({
            "0.1, -2.30258509299",
            "0.5, -0.69314718056",
            "1.0, 0.0000",
            "2.0, 0.69314718056",
            "2.7183, 1.00000668491",
            "10.0, 2.30258509299",
            "50.0, 3.91202300543",
            "100.0, 4.60517018599",
            "1000.0, 6.90775527898",
            "1000000.0, 13.815510558"
    })
    void testNaturalLogarithm(double x, double expected) {
        double result = new NaturalLogarithm().ln(x);
        assertEquals(expected,result,0.00001);
    }

    @ParameterizedTest
    @CsvSource({
            "0.1, -2.30258509299",
            "0.5, -0.69314718056",
            "1.0, 0.0000",
            "2.0, 0.69314718056",
            "2.7183, 1.00000668491",
            "10.0, 2.30258509299",
            "50.0, 3.91202300543",
            "100.0, 4.60517018599",
            "1000.0, 6.90775527898",
            "1000000.0, 13.815510558"
    })
    void testNaturalLogarithmWithOwnEpsilon(double x, double expected) {
        double result = new NaturalLogarithm().ln(x,0.000000001);
        assertEquals(expected,result,0.000000001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -5, -0.5})
    void testNaturalLogarithmWithIllegalArgument(double x) {
        assertThrows(IllegalArgumentException.class, () -> new NaturalLogarithm().ln(x));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 1, 1.60943791243, 1.60943791243",
            "2, 256, 8, 0.69314718056, 5.54517744448",
            "0.5, 2, -1, -0.69314718056, 0.69314718056",
            "1.53, 3, 2.58334267382, 0.425267735404, 1.09861228867",
            "0.64, 108, -10.4912985375, -0.446287102628, 4.68213122712"
    })
    void testOtherLogarithms(double base, double x, double expected, double baseLnRes, double xLnRes) {
        double epsilon = 0.00001;
        try(MockedConstruction<NaturalLogarithm> mockedLn = Mockito.mockConstruction(NaturalLogarithm.class,
                (mock, context) -> {
                    when(mock.ln(base, epsilon)).thenReturn(baseLnRes);
                    when(mock.ln(x, epsilon)).thenReturn(xLnRes);
                })) {

            double result = new Logarithm().log(x, base);
            assertEquals(expected, result, epsilon);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 0",
            "2, 0, 0.693, 0",
            "-1, 2, 0, 0.693",
            "1, 2.718, 0, 1"
    })
    void testOtherLogarithmsWithIllegalArgument(double base, double x, double baseLnRes, double xLnRes) {
        double epsilon = 0.00001;
        try(MockedConstruction<NaturalLogarithm> mockedLn = Mockito.mockConstruction(NaturalLogarithm.class,
                (mock, context) -> {
                    if (x <= 0)
                        when(mock.ln(x, epsilon)).thenThrow(new IllegalArgumentException());
                    else
                        when(mock.ln(x, epsilon)).thenReturn(xLnRes);

                    if (base <= 0)
                        when(mock.ln(base, epsilon)).thenThrow(new IllegalArgumentException());
                    else
                        when(mock.ln(base, epsilon)).thenReturn(baseLnRes);
                })) {

            assertThrows(IllegalArgumentException.class, () -> new Logarithm().log(x, base));
        }
    }
}
