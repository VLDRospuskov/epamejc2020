package homeworks.HW4_strings.indexStringGeneration;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IndexStringGenerationTest {

    public static homeworks.HW4_strings.indexStringGeneration.IndexStringGeneration indexedStringGeneration;

    @BeforeClass
    public static void initClass() {
        indexedStringGeneration = new homeworks.HW4_strings.indexStringGeneration.IndexStringGeneration();
    }

    /**
     * Testing returned substring by char index
     */
    @Test
    public void testGenerateSubstring() {
        String enteredString = "Hello";
        String expectedSubstring1 = "e";
        String expectedSubstring2 = "o";
        String actualSubstring1 = indexedStringGeneration.generateSubstring(enteredString, 1);
        String actualSubstring2 = indexedStringGeneration.generateSubstring(enteredString, 4);
        Assert.assertEquals(expectedSubstring1, actualSubstring1);
        Assert.assertEquals(expectedSubstring2, actualSubstring2);
    }
}