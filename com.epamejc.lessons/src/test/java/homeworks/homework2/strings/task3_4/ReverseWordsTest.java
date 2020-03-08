package homeworks.homework2.strings.task3_4;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    private static ReverseWords reverseWords;

    @BeforeClass
    public static void beforeClass() {
        reverseWords = new ReverseWords();
    }

    @Test
    public void getReversedEmptyString() {
        String expected = "";
        String actual = reverseWords.getReversedString(expected);
        actual = reverseWords.getReversedString(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void getReversedOneWordString() {
        String expected = "qwerty";
        String actual = reverseWords.getReversedString(expected);
        actual = reverseWords.getReversedString(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void getReversedWordsString() {
        String expected = "qwerty uiop[";
        String actual = reverseWords.getReversedString(expected);
        actual = reverseWords.getReversedString(actual);
        assertEquals(expected, actual);
    }

}