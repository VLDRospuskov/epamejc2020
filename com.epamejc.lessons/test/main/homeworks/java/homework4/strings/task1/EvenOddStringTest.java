package main.homeworks.java.homework4.strings.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvenOddStringTest {

    private String input = "London is the capital of Great Britain!";
    private EvenOddString evenOddString = new EvenOddString(input);

    @Test
    public void TestMakeStringEven() {
        String method = "even";
        String expected = "odni h aia fGetBian";
        String actual = evenOddString.makeString(method);

        assertEquals(expected, actual);
    }

    @Test
    public void TestMakeStringOdd() {
        String method = "odd";
        String expected = "Lno stecptlo ra rti!";
        String actual = evenOddString.makeString(method);

        assertEquals(expected, actual);
    }

    @Test
    public void TestMakeStringUnknown() {
        String method = "do nothing";
        String expected = "Unknown method!";
        String actual = evenOddString.makeString(method);

        assertEquals(expected, actual);
    }
}