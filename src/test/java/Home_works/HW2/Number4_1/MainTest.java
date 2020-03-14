package Home_works.HW2.Number4_1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void fibonacci() {
        int inputNumber = 10;
        int[] expectedResultArray = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actualResultArray = new int[inputNumber];
        for (int i = 0; i < actualResultArray.length; i++) {
            actualResultArray[i] = Main.fibonacci(i);
        }

        Assert.assertArrayEquals(expectedResultArray, actualResultArray);
    }
}