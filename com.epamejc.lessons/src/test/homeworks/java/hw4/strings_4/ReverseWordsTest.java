package homeworks.java.hw4.strings_4;

import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ReverseWordsTest {

    private ReverseWords reverser;

    @Before
    public void setup() {
        reverser = new ReverseWords();
    }

    @Test
    public void reverseWordsInStringTest() {
        String input = "Hello world";
        String expected = "[olleH, dlrow]";
        String actual = Arrays.toString(reverser.reverseWordsInString(input));
        assertEquals(expected, actual);
    }
}
