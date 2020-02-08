package homeworks.HW4_strings.replaceCharsByIndices;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReplaceCharsByIndicesTest {

    public static homeworks.HW4_strings.replaceCharsByIndices.ReplaceCharsByIndices indexExchange;

    @BeforeClass
    public static void initClass() {
        indexExchange = new homeworks.HW4_strings.replaceCharsByIndices.ReplaceCharsByIndices();
    }

    /**
     * Testing parse string with indices (correct params)
     */
    @Test
    public void testParseIndexes() {
        String indicesString = "2s 5";
        String inputString = "Hello World";
        boolean expectedResult = true;
        boolean actualResult = indexExchange.parseIndexes(indicesString, inputString);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseIndexesIncorrect() {
        String indicesString = "5";
        String inputString = "Hello World";
        boolean expectedResult = true;
        boolean actualResult = indexExchange.parseIndexes(indicesString, inputString);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testExchangeStringChars() {
        String inputString = "Exchange";
        String expectedString = "exchangE";
        String actualString = indexExchange.exchangeStringChars(inputString, 0, 7);
        Assert.assertEquals(expectedString, actualString);
    }
}