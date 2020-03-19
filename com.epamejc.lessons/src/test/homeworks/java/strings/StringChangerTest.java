package homeworks.java.strings;

import homeworks.java.arrays.RandomCharArray;
import homeworks.java.arrays.Strategy;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringChangerTest {

    private static StringChanger stringChanger;

    @BeforeClass
    public static void setup() {
        stringChanger = new StringChanger();
        stringChanger.setStoredString("Holy cow!");
    }

    @Test
    public void testByIndexTrue() {

       boolean expected = true;

        for (int i = 0; i < stringChanger.getStoredString().length(); i++) {
            boolean actual = stringChanger.byIndex(i);
            Assert.assertEquals(expected, actual);
        }

    }

    @Test
    public void testByIndexFalse() {

        boolean actual = stringChanger.byIndex(50);

        Assert.assertFalse(actual);

    }

    @Test
    public void testByIndexChars() {

        stringChanger.setStringCache("");
        String expected = "Ho";

        stringChanger.byIndex(0);
        stringChanger.byIndex(1);

        Assert.assertEquals(expected, stringChanger.getStringCache());

    }

    @Test
    public void testOdd() {

        String expected = "Hl o!";

        String actual = stringChanger.evenOdd(Parity.ODD);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testEven() {

        String expected = "oycw";

        String actual = stringChanger.evenOdd(Parity.EVEN);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSwapChars() {

        String expected = "!oly cowH";

        String actual = stringChanger.swapChars(0, 8);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSwapCharsWrongInput() {

        String expected = "Wrong input. Try again!";

        String actual = stringChanger.swapChars(0, 10);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFlipWords() {

        String expected = "yloH !woc";

        String actual = stringChanger.flipWords();

        Assert.assertEquals(expected, actual);

    }

}
