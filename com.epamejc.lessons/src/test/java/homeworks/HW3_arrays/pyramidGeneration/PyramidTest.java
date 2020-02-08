package homeworks.HW3_arrays.pyramidGeneration;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PyramidTest {

    public static homeworks.HW3_arrays.pyramidGeneration.Pyramid pyramid;

    @BeforeClass
    public static void initClass() {
        pyramid = new homeworks.HW3_arrays.pyramidGeneration.Pyramid();
    }


    /**
     * Testing the size of the created array
     */
    @Test
    public void testCreatePyramid() {
        int expectedSize = 5;
        int pyramidHeight = 5;
        int actualSize = (pyramid.createPyramid(pyramidHeight)).length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    /**
     * Testing the size of the created array
     */
    @Test
    public void testCreatePyramidWidth() {
        int pyramidHeight = 10;
        int expectedSize = pyramidHeight * 2 - 1;
        int actualSize = (pyramid.createPyramid(pyramidHeight))[0].length;
        Assert.assertEquals(expectedSize, actualSize);
    }
}