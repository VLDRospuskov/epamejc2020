package test.homeworks.homework3.charArraygenerationmainStrategiesAB;

import main.homeworks.homework3.charArraygenerationmainStrategiesAB.RandomCharGenerationStrategiesAB;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomCharGenerationStrategiesABTest {

    private RandomCharGenerationStrategiesAB randomCharGenerationStrategiesAB;

    @Before
    public void setup() {
        randomCharGenerationStrategiesAB = new RandomCharGenerationStrategiesAB();
    }

    @Test
    public void testFillArrayCreate() {
        int expectedColumn = 9;
        int expectedRow = 20;
        randomCharGenerationStrategiesAB.setN(expectedColumn);
        randomCharGenerationStrategiesAB.setM(expectedRow);
        randomCharGenerationStrategiesAB.fillArray();
        int actualColumn = randomCharGenerationStrategiesAB.getArray().length;
        assertEquals(expectedColumn, actualColumn);
        for (int i = 0; i < actualColumn; i++) {
            int actualRow = randomCharGenerationStrategiesAB.getArray()[i].length;
            assertEquals(expectedRow, actualRow);
        }
    }

    @Test
    public void testWhichStrategyA() {
        char[][] array = {
                {'a','b','c'},
                {'e','f','g'},
                {'h','i','g'}
        };
        int n = 3;
        randomCharGenerationStrategiesAB.setArray(array);
        randomCharGenerationStrategiesAB.setM(n);
        randomCharGenerationStrategiesAB.setN(n);
        randomCharGenerationStrategiesAB.whichStrategy("A");
        String expected = "achg";
        String actual = randomCharGenerationStrategiesAB.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhichStrategyB() {
        char[][] array = {
                {'a','b','c'},
                {'e','f','g'},
                {'h','i','g'}
        };
        int n = 3;
        randomCharGenerationStrategiesAB.setArray(array);
        randomCharGenerationStrategiesAB.setM(n);
        randomCharGenerationStrategiesAB.setN(n);
        randomCharGenerationStrategiesAB.whichStrategy("B");
        String expected = "f";
        String actual = randomCharGenerationStrategiesAB.getOutput();
        assertEquals(expected, actual);
    }

}

