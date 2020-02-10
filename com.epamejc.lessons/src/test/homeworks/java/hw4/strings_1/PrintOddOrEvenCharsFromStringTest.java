package homeworks.java.hw4.strings_1;

import org.junit.*;
import static org.junit.Assert.*;

public class PrintOddOrEvenCharsFromStringTest {

    private static PrintOddOrEvenCharsFromString printer;

    @Before
    public void setup() {
        printer = new PrintOddOrEvenCharsFromString();
    }

    @Test
    public void buildStringTest() {
        String[] inputEven = {"Hello", "even"};
        String expectedEven = "el";
        String actualEven = printer.buildString(inputEven);
        assertEquals(expectedEven, actualEven);

        String[] inputOdd = {"Hello", "odd"};
        String expectedOdd = "Hlo";
        String actualOdd = printer.buildString(inputOdd);
        assertEquals(expectedOdd, actualOdd);
    }
}
