package main.homeworks.java.homework3.arrays.task2;

import org.junit.BeforeClass;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class StringMakerTest {

    private static StringMaker stringMaker;

    @BeforeClass
    public static void init() {
        char[][] array = { { 'a', 'b', 'c' },
                           { 'd', 'e', 'f' },
                           { 'g', 'h', 'i' },
                           { 'j', 'k', 'l' }
                         };
        stringMaker = new StringMaker(array);
    }

    @Test
    public void TestMakeStringA() {
        String strategy = "A";
        String expected = "acgi";
        String actual = stringMaker.makeString(strategy);

        assertEquals(expected, actual);
    }

    @Test
    public void TestMakeStringB() {
        String strategy = "B";
        String expected = "ek";
        String actual = stringMaker.makeString(strategy);

        assertEquals(expected, actual);
    }

    @Test
    public void TestMakeStringUnknown() {
        String strategy = "randomString";
        String expected = "Unknown strategy";
        String actual = stringMaker.makeString(strategy);

        assertEquals(expected, actual);
    }
}