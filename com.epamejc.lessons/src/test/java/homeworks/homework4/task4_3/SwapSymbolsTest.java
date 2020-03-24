package homeworks.homework4.task4_3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SwapSymbolsTest {

    private static SwapSymbols swapSymbols;

    @BeforeClass
    public static void beforeClass() {
        swapSymbols = new SwapSymbols();
    }

    @Test
    public void getSwapNumsFromNormalInput() {
        int[] expected = {2, 5};
        int[] actual = swapSymbols.getSwapNumsFromInput("2, 5");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSwapNumsFromFirstInput() {
        int[] expected = {25, 0};
        int[] actual = swapSymbols.getSwapNumsFromInput("25");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSwapNumsFromSecondInput() {
        int[] expected = {0, 12};
        int[] actual = swapSymbols.getSwapNumsFromInput(", 12");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSwapNumsFromEmptyInput() {
        int[] expected = {0, 0};
        int[] actual = swapSymbols.getSwapNumsFromInput("");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSwapNumsFromLettersInput() {
        int[] expected = {0, 0};
        int[] actual = swapSymbols.getSwapNumsFromInput("ac, f");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSwapNumsFromNullInput() {
        int[] expected = {0, 0};
        int[] actual = swapSymbols.getSwapNumsFromInput(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void swapNormalCharsInString() {
        String expected1 = "Holle";
        String expected2 = "Hello";
        int[] swapNums = {1, 4};
        String actual = swapSymbols.swapCharsInString(swapNums, expected2);
        assertEquals(expected1, actual);
        actual = swapSymbols.swapCharsInString(swapNums, actual);
        assertEquals(expected2, actual);
    }

    @Test
    public void swapOversizeCharsInString() {
        String expected = "";
        String input = "Hello";
        int[] swapNums = {1, 20};
        String actual = swapSymbols.swapCharsInString(swapNums, input);
        assertEquals(expected, actual);
    }

    @Test
    public void swapNegativeCharsInString() {
        String expected = "";
        String input = "Hello";

        int[] swapNums = {-1, 2};
        String actual = swapSymbols.swapCharsInString(swapNums, input);
        assertEquals(expected, actual);
    }

}