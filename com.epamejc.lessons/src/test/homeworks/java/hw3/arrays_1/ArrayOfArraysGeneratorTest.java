package homeworks.java.hw3.arrays_1;

import org.junit.*;
import static org.junit.Assert.*;


public class ArrayOfArraysGeneratorTest {

    private static ArrayOfArraysGenerator generator;

    @Before
    public void setup() {
        generator = new ArrayOfArraysGenerator();
    }

    @Test
    public void buildArrayTest() {
        int expectedLinesCount = 3;
        int expectedCharsCount = 5;
        char[][] arr = generator.buildArray(3, 5);
        int actualLinesCount = arr.length;
        int actualCharsCount = arr[0].length;
        assertEquals(expectedLinesCount, actualLinesCount);
        assertEquals(expectedCharsCount, actualCharsCount);

    }
}
