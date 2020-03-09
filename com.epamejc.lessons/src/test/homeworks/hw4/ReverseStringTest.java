package homeworks.hw4;

import org.junit.*;

import static org.junit.Assert.*;

public class ReverseStringTest {

    private static ReverseString reverseString;

    @Before
    public void setup() {
        reverseString = new ReverseString();
    }

    @Test
    public void testLengthsAreEqual() {
        String input = "testing length equality";
        String revString = reverseString.stringRevert(input);
        assertEquals(input.length(), revString.length());
    }

    @Test
    public void testStringReverse() {
        assertEquals("nrael", reverseString.stringRevert("learn"));
    }
}
