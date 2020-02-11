package homeworks.java.trafficLights;

import org.junit.Assert;
import org.junit.Test;

public class LightsLogicTest {

    private String[] input;
    private Lights[] expected;
    private LightsLogic lightsLogic = new LightsLogic();

    @Test
    public void inputCheckTestGreen() {
        input = new String[]{"0", "2", "2.59"};

        expected = new Lights[]{Lights.GREEN, Lights.GREEN, Lights.GREEN};
        Lights[] actual = new Lights[expected.length];

        for (int i = 0; i < input.length; i++) {
            actual[i] = lightsLogic.parseInputString(input[i]);
        }

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void inputCheckTestYellow() {
        input = new String[]{"3", "3.55", "4.59"};

        expected = new Lights[]{Lights.YELLOW, Lights.YELLOW, Lights.YELLOW};
        Lights[] actual = new Lights[expected.length];

        for (int i = 0; i < input.length; i++) {
            actual[i] = lightsLogic.parseInputString(input[i]);
        }

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void inputCheckTestRed() {
        input = new String[]{"5", "6.25", "9.59"};

        expected = new Lights[]{Lights.RED, Lights.RED, Lights.RED};
        Lights[] actual = new Lights[expected.length];

        for (int i = 0; i < input.length; i++) {
            actual[i] = lightsLogic.parseInputString(input[i]);
        }

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void inputCheckTestLongDecimalPart() {
        String input = "1.454";

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = lightsLogic.parseInputString(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputCheckTestWithChars() {
        String input = "sdf1.44";

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = lightsLogic.parseInputString(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputCheckTestEmptyString() {
        String input = "";

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = lightsLogic.parseInputString(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputCheckTestNegativeNumber() {
        String input = "-1.44";

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = lightsLogic.parseInputString(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputCheckTestWrongDecimalPart() {
        String input = "1.61";

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = lightsLogic.parseInputString(input);

        Assert.assertEquals(expected, actual);
    }
}
