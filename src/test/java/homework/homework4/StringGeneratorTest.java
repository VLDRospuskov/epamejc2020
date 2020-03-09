package homework.homework4;

import homework.homework4.StringGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringGeneratorTest {

    @Test
    public void createOfEveryOtherChars() {
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "z";
        String str4 = "";

        assertEquals("wryip", StringGenerator.createOfEveryOtherChars(str1, true));
        assertEquals("qetuo", StringGenerator.createOfEveryOtherChars(str1, false));
        assertEquals("sfhk", StringGenerator.createOfEveryOtherChars(str2, true));
        assertEquals("adgjl", StringGenerator.createOfEveryOtherChars(str2, false));
        assertEquals("", StringGenerator.createOfEveryOtherChars(str3, true));
        assertEquals("z", StringGenerator.createOfEveryOtherChars(str3, false));
        assertEquals("", StringGenerator.createOfEveryOtherChars(str4, true));
        assertEquals("", StringGenerator.createOfEveryOtherChars(str4, false));

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void createOfIndexes() {
        String str = "qwertyuiop";
        assertEquals("eyup", StringGenerator.createOfIndexes(str, 2, 5, 6, 9));
        assertEquals("", StringGenerator.createOfIndexes(str, 5, -1, 7));
        assertEquals("", StringGenerator.createOfIndexes(str, 1, 3, 10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void swapSymbols() {
        String str = "qwerty";
        assertEquals("qterwy", StringGenerator.swapSymbols(str, 4, 1));
        assertEquals("", StringGenerator.swapSymbols(str, -1, 1));
        assertEquals("", StringGenerator.swapSymbols(str, 7, 1));
    }

    @Test
    public void reverseWords() {
        String str = "Hello world My name is Yana";
        assertEquals("olleH dlrow yM eman si anaY", StringGenerator.reverseWords(str));
    }
}