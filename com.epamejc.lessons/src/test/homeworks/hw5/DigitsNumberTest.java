package homeworks.hw5;

import main.homeworks.hw5.DigitsNumber;
import org.junit.*;

import static org.junit.Assert.*;

public class DigitsNumberTest {

    private static DigitsNumber digitsNumber;

    @Before
    public void setup() {
        digitsNumber = new DigitsNumber();
    }

    @Test
    public void testDigitsNumber() {
        int expected1 = 5;
        int actual1 = digitsNumber.numDig(12345);
        assertEquals(expected1, actual1);
    }
}
