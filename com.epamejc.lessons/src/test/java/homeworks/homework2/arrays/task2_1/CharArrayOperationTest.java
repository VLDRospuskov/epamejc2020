package homeworks.homework2.arrays.task2_1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CharArrayOperationTest {
    private static CharArrayOperation charArrayOperation;

    @BeforeClass
    public static void BeforeClass() {
        charArrayOperation = new CharArrayOperation();
    }

    @Test
    public void getRandomFilledArrayOfArrays() {
        char[][] expected1 = charArrayOperation.getRandomFilledArrayOfArrays(5, 3);
        for (char[] chars : expected1) {
            for (char aChar : chars) {
                assertTrue(Character.isLetter(aChar));
            }

        }
    }

    @Test
    public void getRandomFilledArrayOfArraysWithZeroRows() {
        char[][] expected1 = charArrayOperation.getRandomFilledArrayOfArrays(0, 3);
        for (char[] chars : expected1) {
            for (char aChar : chars) {
                assertTrue(Character.isLetter(aChar));
            }

        }
    }

    @Test
    public void getRandomFilledArrayOfArraysWithZeroColumns() {
        char[][] expected1 = charArrayOperation.getRandomFilledArrayOfArrays(2, 0);
        for (char[] chars : expected1) {
            for (char aChar : chars) {
                assertTrue(Character.isLetter(aChar));
            }

        }
    }
}