package homeworks.homework2.strings.task3_1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OddEvenSubstringTest {

    private static OddEvenSubstring oddEvenSubstring;
    private static String input = "qwertyu asdfgh zxc12";

    @BeforeClass
    public static void beforeClass() {
        oddEvenSubstring = new OddEvenSubstring();

    }

    @Test
    public void useEvenStrategy() {
        String expected = "wry sfhzc2";
        String actual = oddEvenSubstring.useStrategy(input, "even");
        assertEquals(expected, actual);
    }

    @Test
    public void useOddStrategy() {
        String expected = "qetuadg x1";
        String actual = oddEvenSubstring.useStrategy(input, "odd");
        assertEquals(expected, actual);
    }

    @Test
    public void useUnexpectedStrategy() {
        String expected = "";
        String actual = oddEvenSubstring.useStrategy(input, "another_one");
        assertEquals(expected, actual);
    }

    @Test
    public void useOddStrategyEmptyString() {
        String expected = "";
        String actual = oddEvenSubstring.useStrategy("", "odd");
        assertEquals(expected, actual);
    }

    @Test
    public void useEvenStrategyEmptyString() {
        String expected = "";
        String actual = oddEvenSubstring.useStrategy("", "even");
        assertEquals(expected, actual);
    }

}