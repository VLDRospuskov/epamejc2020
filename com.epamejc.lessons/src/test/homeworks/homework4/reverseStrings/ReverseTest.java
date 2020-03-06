package test.homeworks.homework4.reverseStrings;

import main.homeworks.homework4.reverseStrings.Reverse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseTest {

    private Reverse reverse;

    @Before
    public void setup() {
        reverse = new Reverse();
    }

    @Test
    public void testReverseWorld() {
        String expected = "anirA";
        String actual = reverse.reverseWorld("Arina");
        assertEquals(expected, actual);
    }

    @Test
    public void testReverseString() {
        String expected = "yM eman si anirA";
        reverse.setInput("My name is Arina");
        String actual = reverse.reverseString();
        assertEquals(expected, actual);
    }

}
