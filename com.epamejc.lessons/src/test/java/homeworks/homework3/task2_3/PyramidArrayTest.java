package homeworks.homework3.task2_3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PyramidArrayTest {

    private static PyramidArray pyramidArray;


    @BeforeClass
    public static void beforeClass() {
        pyramidArray = new PyramidArray();
    }

    @Test
    public void initializePyramidArrayWithPositive() {
        int rows = 5;
        char[][] expected = pyramidArray.initializePyramidArray(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i; j++) {
                assertEquals(expected[i][j], '*');
            }

        }
    }

    @Test
    public void initializePyramidArrayWithZero() {
        int rows = 0;
        char[][] expected = pyramidArray.initializePyramidArray(rows);
        assertEquals(0, expected.length);
    }

    @Test
    public void initializePyramidArrayWithNegative() {
        int rows = -3;
        char[][] expected = pyramidArray.initializePyramidArray(rows);
        assertEquals(0, expected.length);
    }

}