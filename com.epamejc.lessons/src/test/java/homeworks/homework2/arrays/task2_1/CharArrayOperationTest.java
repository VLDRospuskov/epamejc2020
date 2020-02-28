package homeworks.homework2.arrays.task2_1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharArrayOperationTest {

    private static CharArrayOperation charArrayOperation;
    private String[] values;
    private char[][] chars;
    private int rows;
    private int columns;

    @BeforeClass
    public static void setUp() {
        charArrayOperation = new CharArrayOperation();
    }


    @Test
    public void getRows() {
        values = new String[] {"2", "2"};
        int actual1 = charArrayOperation.getRows(values);
        int expected1 = 2;
        assertEquals(expected1, actual1);

        values = new String[] {"3", ""};
        int actual2 = charArrayOperation.getRows(values);
        int expected2 = 3;
        assertEquals(expected2, actual2);

        values = new String[] {"", "1"};
        int actual3 = charArrayOperation.getRows(values);
        int expected3 = 0;
        assertEquals(expected3, actual3);

        values = new String[] {"", ""};
        int actual4 = charArrayOperation.getRows(values);
        int expected4 = 0;
        assertEquals(expected4, actual4);

        values = new String[] {""};
        int actual5 = charArrayOperation.getRows(values);
        int expected5 = 0;
        assertEquals(expected5, actual5);

        values = new String[] {"-1", "3"};
        int actual6 = charArrayOperation.getRows(values);
        int expected6 = -1;
        assertEquals(expected6, actual6);

        values = new String[] {"1", "-3"};
        int actual7 = charArrayOperation.getRows(values);
        int expected7 = 1;
        assertEquals(expected7, actual7);

    }

    @Test
    public void getColumns() {
        values = new String[] {"2", "2"};
        int actual1 = charArrayOperation.getColumns(values);
        int expected1 = 2;
        assertEquals(expected1, actual1);

        values = new String[] {"3", ""};
        int actual2 = charArrayOperation.getColumns(values);
        int expected2 = 0;
        assertEquals(expected2, actual2);

        values = new String[] {"", "1"};
        int actual3 = charArrayOperation.getColumns(values);
        int expected3 = 1;
        assertEquals(expected3, actual3);

        values = new String[] {"", ""};
        int actual4 = charArrayOperation.getColumns(values);
        int expected4 = 0;
        assertEquals(expected4, actual4);

        values = new String[] {""};
        int actual5 = charArrayOperation.getColumns(values);
        int expected5 = 0;
        assertEquals(expected5, actual5);

        values = new String[] {"-1", "3"};
        int actual6 = charArrayOperation.getColumns(values);
        int expected6 = 3;
        assertEquals(expected6, actual6);

        values = new String[] {"1", "-3"};
        int actual7 = charArrayOperation.getColumns(values);
        int expected7 = -3;
        assertEquals(expected7, actual7);
    }

    @Test
    public void getDeclaredArrayOfArrays() {
        rows = 5;
        columns = 3;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(rows, chars.length);
        for (int i = 0; i < columns; i++) {
            assertEquals(columns, chars[i].length);
        }

        rows = 5;
        columns = 0;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(0, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }

        rows = 0;
        columns = 3;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(0, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }


        rows = -1;
        columns = 3;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(0, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }

        rows = 3;
        columns = -1;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(0, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }

        rows = -2;
        columns = -1;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(0, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }

        rows = 0;
        columns = 0;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        assertEquals(rows, chars.length);
        if (rows > 0 && columns > 0) {
            for (int i = 0; i < columns; i++) {
                assertEquals(0, chars[i].length);
            }
        }

    }

    @Test
    public void fillCharsArray() {
        rows = 5;
        columns = 3;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = 4;
        columns = 0;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = 0;
        columns = 6;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = 3;
        columns = -4;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = -3;
        columns = 4;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = -3;
        columns = -4;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

        rows = 0;
        columns = 0;
        chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        chars = charArrayOperation.fillCharsArray(chars);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertTrue(Character.isLetter(chars[i][j]));
            }
        }

    }

}