package test.homeworks.homework3.charArraygenerationmain;

import main.homeworks.homework3.charArraygenerationmain.RandomLetterGeneration;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomLetterGenerationTest {

    private RandomLetterGeneration randomLetterGeneration;

    @Before
    public void setup() {
        randomLetterGeneration = new RandomLetterGeneration();
    }

    @Test
    public void testFillArrayCreate() {
        int expectedColumn = 9;
        int expectedRow = 20;
        randomLetterGeneration.setN(expectedColumn);
        randomLetterGeneration.setM(expectedRow);
        randomLetterGeneration.fillArray();
        int actualColumn = randomLetterGeneration.getArray().length;
        assertEquals(expectedColumn, actualColumn);
        for (int i = 0; i < actualColumn; i++) {
            int actualRow = randomLetterGeneration.getArray()[i].length;
            assertEquals(expectedRow, actualRow);
        }
    }


}
