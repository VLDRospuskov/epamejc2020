package main.homeworks.java.homework3.arrays.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayMakerTest {

    private ArrayMaker arrayMaker = new ArrayMaker();

    @Test
    public void TestMakeArray() {
        int expectedDimension1 = 5;
        int expectedDimension2 = 3;
        char[][] randomCharArray1 = arrayMaker.makeArray(expectedDimension1, expectedDimension2);
        char[][] randomCharArray2 = arrayMaker.makeArray(expectedDimension1, expectedDimension2);

        assertEquals(expectedDimension1, randomCharArray1.length);
        assertEquals(expectedDimension2, randomCharArray2[0].length);
        assertNotEquals(randomCharArray1, randomCharArray2);
    }
}