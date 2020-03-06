package homework2.ArrayPyramid;

import org.junit.Test;

import static org.junit.Assert.*;

public class buildPyramidLogicTest {

    @Test
    public void buildPyramid() {
        buildPyramidLogic buildPyramidLogic = new buildPyramidLogic();
        String  expected = buildPyramidLogic.buildPyramid(3);
        String actual = "\n\rXX\n\rX\n\r";
        assertEquals(expected,actual);
    }
}
