package homeworks.homework4.task3_2;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringGeneratorTest {

    private static StringGenerator stringGenerator;
    private static String inputString = "qwerty asdf 12";

    @BeforeClass
    public static void beforeClass() {
        stringGenerator = new StringGenerator();
    }

    @Test
    public void collectViaPositiveIndex() {
        StringBuilder stringBuilder = new StringBuilder();
        String expected = "q2";
        String actual;
        stringGenerator.generateString(inputString, stringBuilder, 0);
        actual = stringGenerator.generateString(inputString, stringBuilder, inputString.length() - 1);
        assertEquals(expected, actual);
    }

    @Test
    public void collectViaOversizeIndex() {
        StringBuilder stringBuilder = new StringBuilder();
        String expected = "";
        String actual = stringGenerator.generateString(inputString, stringBuilder, 200);
        assertEquals(expected, actual);
    }

    @Test
    public void collectViaNegativeIndex() {
        StringBuilder stringBuilder = new StringBuilder();
        String expected = "";
        String actual = stringGenerator.generateString(inputString, stringBuilder, -2);
        assertEquals(expected, actual);
    }

}