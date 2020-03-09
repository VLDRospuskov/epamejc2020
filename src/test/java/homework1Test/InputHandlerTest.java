package homework1Test;

import homeworks.homework1.InputHandler;
import homeworks.homework1.TrafficColors;
import homeworks.homework3.allInOne.Colors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class InputHandlerTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    InputHandler handler;

    @Before
    public void setupOutput() {
        handler = new InputHandler();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }


    private String getOutput() {
        return testOut.toString().trim();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void handleUserInputTestEmptyString () {

        String input = "";
        handler.handleUserInput(input);

        String actual = getOutput();
        String output = "Time should be a digit";
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void handleUserInputTestNullString () {

        handler.handleUserInput(null);

        String actual = getOutput();
        String output = "Time should be a digit";
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void handleUserInputTestNotNumericString () {

        String input = "tom";
        handler.handleUserInput(input);

        String actual = getOutput();
        String output = "Time should be a digit";
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void handleUserInputTestGoodInputGreen () {

        String input = "3.99999999";
        handler.handleUserInput(input);

        String actual = getOutput();
        String output = Colors.colors[3] + TrafficColors.GREEN + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }
}
