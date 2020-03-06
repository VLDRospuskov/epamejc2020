package homework2.ArrayRandomCharRactangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class randomCharRectangleLogicTest {

    @Test
    public void buildRectangle() {
        randomCharRectangleLogic randomCharRectangleLogic = new randomCharRectangleLogic();
        int expected = randomCharRectangleLogic.buildRectangle(4, 5).length();
        int actual = 48;
        assertEquals(expected, actual);
    }
}