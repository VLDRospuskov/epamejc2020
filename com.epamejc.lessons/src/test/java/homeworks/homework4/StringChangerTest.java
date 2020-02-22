package homeworks.homework4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringChangerTest {

    private static StringChanger changer;
    private String testString = "Hello World";

    @BeforeClass
    public static void setup() {
        changer = new StringChanger();
    }

    @Test
    public void testEvenOrOddChars() {
        String actualEven = changer.evenOrOddChars(testString, 1);
        String expectedEven = "el ol";
        String actualOdd = changer.evenOrOddChars(testString, 0);
        String expectedOdd = "HloWrd";
        Assert.assertEquals(expectedEven, actualEven);
        Assert.assertEquals(expectedOdd, actualOdd);
    }

    @Test
    public void testGenerateString() {
        String actual1 = changer.generateString(testString, 0);
        String expected1 = "H";
        String actual2 = changer.generateString(testString, 4);
        String expected2 = "Ho";
        String actual3 = changer.generateString(testString, 6);
        String expected3 = "HoW";

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);

        changer.clearTemp();
    }

    @Test
    public void testSwapChars() {
        String actual = changer.swapChars(testString, 0, 6);
        String expected = "Wello Horld";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse() {
        String actual = changer.reverse(testString);
        String expected = "olleH dlroW ";
        Assert.assertEquals(expected, actual);
    }
}