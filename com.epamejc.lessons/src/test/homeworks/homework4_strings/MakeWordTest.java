package homeworks.homework4_strings;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeWordTest {
    MakeWord makeWord;

    @Before
    public void setUp() {
        makeWord = new MakeWord();
    }

    @Test
    public void testCheckInt() {
        String request1 = "12";
        String request2 = "1";
        String request3 = "123";

        Integer expected1 = 12;
        Integer expected2 = 1;
        Integer expected3 = 123;

        assertEquals(expected1, makeWord.chekInt(request1));
        assertEquals(expected2, makeWord.chekInt(request2));
        assertEquals(expected3, makeWord.chekInt(request3));
    }

    @Test(expected = IllegalDataException.class)
    public void testIllegalStringCheckInt() {
        makeWord.chekInt("One");
    }

    @Test(expected = IllegalDataException.class)
    public void testIllegalDoubleCheckInt() {
        makeWord.chekInt("12.2");
    }

    @Test(expected = IllegalDataException.class)
    public void testIllegalTwoIntCheckInt() {
        makeWord.chekInt("12 2");
    }

    @Test
    public void testGetResult() {
        String request = "Make Word 1 2 3 2";
        String expected = "akek";

        String request2 = "MakeWord 4 5 7";
        String expected2 = "Wod";

        String request3 = "MakeWord 1";
        String expected3 = "a";

        assertEquals(expected, makeWord.getResult(request));
        assertEquals(expected2, makeWord.getResult(request2));
        assertEquals(expected3, makeWord.getResult(request3));
    }
}