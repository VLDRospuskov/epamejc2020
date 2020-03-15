package homeworks.homework03;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class StringMethodsTest {

    StringMethods stringMethods = new StringMethods();
    private final String value = "Hello, world!";

    @Test
    public void testPrintOddEvenLetters() {
        String expected = "el,wrd";
        String actual = stringMethods.getStringOfOddOrEvenLetters(value, PrintMode.EVEN);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStringFromIndexes() {
        int[] indexes = {2,4,5,7};
        String expected = "lo,w";

        String actual = "";

        for (int i : indexes) {
            actual += stringMethods.getCharFromStringAtIndex(value, i);
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSwapLetters() {
        String expected = "Hewlo, lorld!";

        String actual = stringMethods.swapLetters(value, 2, 7);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseWords() {
        String expected = "olleH, dlrow!";
        String actual = stringMethods.reverseWords(value);

        Assert.assertEquals(expected, actual);
    }

}
