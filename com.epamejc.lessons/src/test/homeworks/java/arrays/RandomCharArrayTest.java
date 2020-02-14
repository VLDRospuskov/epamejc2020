package homeworks.java.arrays;

import org.junit.Assert;
import org.junit.Test;

public class RandomCharArrayTest {

    private String input;
    private RandomCharArray randomCharArray = new RandomCharArray();

    @Test
    public void testGenerateArrWrongInput() {

        input = "asdf";
        boolean expected = false;

        boolean actual = randomCharArray.generateArr(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGenerateArrCorrectInput() {

        input = "14 15";
        boolean expected = true;

        boolean actual = randomCharArray.generateArr(input);

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = AssertionError.class)
    public void testGenerateArrRandomness() {

        input = "5 5";

        randomCharArray.generateArr(input);
        char[][] arrFirst = randomCharArray.getArr();
        randomCharArray.generateArr(input);

        Assert.assertArrayEquals(arrFirst, randomCharArray.getArr());

    }

}
