package test.homeworks.homework4.evenOddString;

import main.homeworks.homework4.evenOddString.EvenOddString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenOddStringTest {

    private EvenOddString evenOddString;

    @Before
    public void setup() {
        evenOddString = new EvenOddString();
    }

    @Test
    public void testOddOrEvenTrue() {
        boolean expected = true;
        evenOddString.setInput("");
        evenOddString.setParity("Even");
        boolean actual1 = evenOddString.oddOrEven();
        evenOddString.setParity("even");
        boolean actual2 = evenOddString.oddOrEven();
        evenOddString.setParity("Odd");
        boolean actual3 = evenOddString.oddOrEven();
        evenOddString.setParity("Odd");
        boolean actual4 = evenOddString.oddOrEven();
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
        assertEquals(expected, actual4);
    }

    @Test
    public void testOddOrEvenFalse() {
        boolean expected = false;
        evenOddString.setParity("dfbbfgn");
        boolean actual = evenOddString.oddOrEven();
        assertEquals(expected,actual);
    }

    @Test
    public void testOddChars() {
        evenOddString.setInput("Arina Slizh");
        String expected = "AiaSih";
        String actual = evenOddString.oddChars();
        assertEquals(expected,actual);
    }

    @Test
    public void testEvenChars() {
        evenOddString.setInput("Arina Slizh");
        String expected = "rn lz";
        String actual = evenOddString.evenChars();
        assertEquals(expected,actual);
    }



}
