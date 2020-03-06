package homework2.ArrayRandomCharOutput;

import org.junit.Test;

import static org.junit.Assert.*;

public class randomCharOutputLogicTest {

    @Test
    public void enterRandArr() {
        randomCharOutputLogic randomCharOutputLogic = new randomCharOutputLogic();
        String arr[][] = randomCharOutputLogic.enterRandArr(4, 5);
        int expectedWidth = arr.length;
        int expectedHeight = arr[0].length;
        assertEquals(expectedWidth, 4);
        assertEquals(expectedHeight, 5);

    }

    @Test
    public void applyStrategy() {
        randomCharOutputLogic randomCharOutputLogic = new randomCharOutputLogic();
        String[][] arr = {{"1","2","3"}, {"4","5","6"}, {"8","9","0"}};
        String expected =  randomCharOutputLogic.applyStrategy(arr,"a");
        String actual = "1380";
        assertEquals(expected,actual);
    }
}