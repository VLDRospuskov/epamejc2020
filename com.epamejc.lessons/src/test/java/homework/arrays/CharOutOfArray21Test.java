package homework.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharOutOfArray21Test {

    @Test(expected = Exception.class)
    public void charOutOfArrayCoreNegativeRows() {
        CharOutOfArray21.charOutOfArrayCore(-3, 7);
    }

    @Test(expected = Exception.class)
    public void charOutOfArrayCoreNegativeColumns() {
        CharOutOfArray21.charOutOfArrayCore(3, -7);
    }

    @Test
    public void charOutOfArrayCoreZeroRows() {
        assertArrayEquals(new char[0][5], CharOutOfArray21.charOutOfArrayCore(0, 5));
    }

    @Test
    public void charOutOfArrayCoreNormal() {
        int nRowsTest[] = new int[]{4, 5, 10};
        int nColumnsTest[] = new int[]{7, 1, 5, 0};

        int nRowsExpected[] = new int[]{4, 5, 10};
        int nColumnsExpected[] = new int[]{7, 1, 5, 0};

        for (int i = 0; i < nRowsTest.length; i++) {
            for (int j = 0; j < nColumnsTest.length; j++) {
                char[][] output = CharOutOfArray21.charOutOfArrayCore(nRowsTest[i], nColumnsTest[j]);
                assertEquals(nRowsExpected[i], output.length);
                assertEquals(nColumnsExpected[j], output[0].length);
            }
        }
    }
}