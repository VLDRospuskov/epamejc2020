package homeworks.HW4_strings.evenOrOddString;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvenOrOddStringTest {

    public static homeworks.HW4_strings.evenOrOddString.EvenOrOddString evenOrNotString;

    @BeforeClass
    public static void initClass() {
        evenOrNotString = new homeworks.HW4_strings.evenOrOddString.EvenOrOddString();
    }

    /**
     * Checking the size of the created string with ODD filter
     */
    @Test
    public void testTransformStringOdd() {
        String filterType = FilterTypes.ODD.getValue();
        String inputString1 = "10101";
        int expectedStringLength1 = 2;
        String inputString2 = "101010";
        int expectedStringLength2 = 3;
        int actualStringSize1 = evenOrNotString.processString(inputString1, filterType).length();
        int actualStringSize2 = evenOrNotString.processString(inputString2, filterType).length();
        Assert.assertEquals(expectedStringLength1, actualStringSize1);
        Assert.assertEquals(expectedStringLength2, actualStringSize2);
    }

    /**
     * Checking the size of the created string with EVEN filter
     */
    @Test
    public void testTransformStringEven() {
        String filterType = FilterTypes.EVEN.getValue();
        String inputString1 = "10101";
        int expectedStringLength1 = 3;
        String inputString2 = "101010";
        int expectedStringLength2 = 3;
        int actualStringSize1 = evenOrNotString.processString(inputString1, filterType).length();
        int actualStringSize2 = evenOrNotString.processString(inputString2, filterType).length();
        Assert.assertEquals(expectedStringLength1, actualStringSize1);
        Assert.assertEquals(expectedStringLength2, actualStringSize2);
    }
}