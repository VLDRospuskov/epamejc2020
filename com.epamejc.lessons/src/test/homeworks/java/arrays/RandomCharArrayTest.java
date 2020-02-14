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

    @Test
    public void testGenerateArrMakeStringWithStrategyA() {

        char[][] array
                = {{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'}};
        randomCharArray = new RandomCharArray(array);
        String expected = "acgi";

        String actual = randomCharArray.makeStringWithStrategy(Strategy.A);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGenerateArrMakeStringWithStrategyB() {

        char[][] array
                = {{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'}};
        randomCharArray = new RandomCharArray(array);
        String expected = "ek";

        String actual = randomCharArray.makeStringWithStrategy(Strategy.B);

        Assert.assertEquals(expected, actual);

    }

}
