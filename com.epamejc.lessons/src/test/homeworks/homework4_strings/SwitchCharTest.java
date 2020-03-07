package homeworks.homework4_strings;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwitchCharTest {
    SwitchChar switchChar;
    @Before
    public void setUp() throws Exception {
        switchChar = new SwitchChar();

    }

    @Test(expected = IllegalDataException.class)
    public void testFailBodyRandomChar() {
        switchChar.getResult("onlyBody");
    }
    @Test(expected = IllegalDataException.class)
    public void testFailIndexRandomChar() {
        switchChar.getResult("1 2");
    }
    @Test(expected = IllegalDataException.class)
    public void testFailEmptyRandomChar() {
        switchChar.getResult("");
    }
    @Test(expected = IllegalDataException.class)
    public void testFailLargeIndexRandomChar() {
        switchChar.getResult("World of Warcraft 10 20");
    }

    @Test
    public void testGetResult() {
        String request = "World of Warcraft 1 4";
        assertEquals("Wdrlo of Warcraft ",switchChar.getResult(request));
    }
}