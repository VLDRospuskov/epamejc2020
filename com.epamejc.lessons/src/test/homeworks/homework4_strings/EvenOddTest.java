package homeworks.homework4_strings;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvenOddTest {
    private String EVEN = "even";
    private String ODD = "odd";
    private EvenOdd evenOdd;

    @Before
    public void setUp(){
        evenOdd = new EvenOdd();
    }

    @Test
    public void testIsEvenOdd() {
        assertTrue(evenOdd.isEvenOdd(EVEN));
        assertTrue(evenOdd.isEvenOdd(ODD));
        assertFalse(evenOdd.isEvenOdd("Another"));
    }

    @Test
    public void testGetResult() {
        String request1 = "World of Warcraft even";
        String request2 = "World of Warcraft odd";
        String expectedEven = "Wrdo acat";
        String expectedOdd = "ol fWrrf";
        assertEquals(expectedEven,evenOdd.getResult(request1));
        assertEquals(expectedOdd,evenOdd.getResult(request2));
    }
    @Test(expected = IllegalDataException.class)
    public void getResult() {
        String request1 = "World of Warcraft 12";
        evenOdd.getResult(request1);
    }
}