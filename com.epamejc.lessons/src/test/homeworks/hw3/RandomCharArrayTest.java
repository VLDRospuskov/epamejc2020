package homeworks.hw3;

import main.homeworks.hw3.RandomCharArray;
import org.junit.*;

import static org.junit.Assert.*;

public class RandomCharArrayTest {

    private static RandomCharArray randomCharArray;

    @Before
    public void setup() {
        randomCharArray = new RandomCharArray();
    }

    @Test
    public void testRandomCharArrayIsNotEmpty() {
        char charArray[][] = randomCharArray.randomizeCharArray(3, 5);
        for (char[] innerArray : charArray) {
            assertFalse(innerArray.length == 0);
        }
    }

    @Test
    public void testExpectedRandomCharArrayLength() {
        char charArray[][] = randomCharArray.randomizeCharArray(3, 5);
        int actualWidth = charArray.length;
        int actualHeight = charArray[0].length;
        assertEquals(3, actualWidth);
        assertEquals(5, actualHeight);
    }
}
