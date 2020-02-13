package homeworks.java.hw3.arrays_3;

import org.junit.*;
import static org.junit.Assert.*;

public class PyramidBuilderTest {

    private PyramidBuilder builder;

    @Before
    public void setup() {
        builder = new PyramidBuilder();
    }

    @Test
    public void printPyramidTest() {
        int number = 3;
        char[][] arr = builder.buildPyramid(number);
        String expected0 = "XXX";
        String expected1 = "XX" + '\u0000';
        String expected2 = "X" + '\u0000' + '\u0000';

        String actual0 = "";
        for (char a : arr[0]) {
            actual0 += a;
        }
        String actual1 = "";
        for (char a : arr[1]) {
            actual1 += a;
        }
        String actual2 = "";
        for (char a : arr[2]) {
            actual2 += a;
        }
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

}
