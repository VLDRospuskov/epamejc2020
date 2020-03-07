package homeworks.homework2_arrays.strategy;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MakeStringTest {
    MakeString makeString;
    @Before
    public void setUp() throws Exception {
        makeString = new MakeString();
    }

    @Test
    public void testGetResult() {
        String request1 = "1 2 even";
        String request2 = "3 4 odd";
        String request3 = "21 12 even";

        int expected1 = 1;
        int expected2 = 6;
        int expected3 = 126;

        assertEquals(expected1, makeString.getResult(request1).length());
        assertEquals(expected2, makeString.getResult(request2).length());
        assertEquals(expected3, makeString.getResult(request3).length());
    }
    @Test(expected = IllegalDataException.class)
    public void testExGetResult() {
        String request = "2 1";
        makeString.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testEx2GetResult() {
        String request = "2 1 fgfg";
        makeString.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testEx3GetResult() {
        String request = "";
        makeString.getResult(request);
    }
    @Test(expected = IllegalDataException.class)
    public void testEx4GetResult() {
        String request = "2 odd";
        makeString.getResult(request);
    }
}