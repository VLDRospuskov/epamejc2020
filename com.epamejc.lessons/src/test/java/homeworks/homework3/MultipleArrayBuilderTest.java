package homeworks.homework3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultipleArrayBuilderTest {

    private static MultipleArrayBuilder builder;

    @BeforeClass
    public static void setup() {
        builder = new MultipleArrayBuilder();
    }

    @Test
    public void testCreateArray() {
        char[][] array = builder.createArray(5, 5);
        int actualLength = array.length;
        int expectedLength = 5;
        int actualInnerLength = array[0].length;
        int expectedInnerLength = 5;
        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertEquals(expectedInnerLength, actualInnerLength);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean actual = Character.isLetter(array[i][j]);

                Assert.assertTrue(actual);
            }
        }

    }
}