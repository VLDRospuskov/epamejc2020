package homeworks.HW4_strings.stringReverse;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversedStringTest {

    public static homeworks.HW4_strings.stringReverse.ReversedString reversedString;

    @BeforeClass
    public static void initClass() {
        reversedString = new homeworks.HW4_strings.stringReverse.ReversedString();
    }

    /**
     * Testing words reverse inside original string
     */
    @Test
    public void testReverseStrings() {
        String inputString = "Hello World";
        String expectedString = "olleH dlroW";
        String actualString = reversedString.reverseStrings(inputString);
        Assert.assertEquals(expectedString, actualString);
    }
}