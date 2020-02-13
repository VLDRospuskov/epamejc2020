package homeworks.java.hw3.utils;

import homeworks.java.hw3.arrays_1.ArrayOfArraysGenerator;
import org.junit.*;
import static homeworks.java.hw3.utils.Utilities.*;
import static org.junit.Assert.*;

public class UtilitiesTest {

    private static ArrayOfArraysGenerator generator;

    @Test
    public void buildArrayTest() {
        int expectedLinesCount = 3;
        int expectedCharsCount = 5;
        int[] numbers = {3, 5};
        char[][] arr = buildArray(numbers);
        int actualLinesCount = arr.length;
        int actualCharsCount = arr[0].length;
        assertEquals(expectedLinesCount, actualLinesCount);
        assertEquals(expectedCharsCount, actualCharsCount);
    }

}
