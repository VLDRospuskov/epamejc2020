package homework1Test;

import homeworks.homework1.ColorPrinter;
import homeworks.homework1.TrafficColors;
import homeworks.homework3.allInOne.Colors;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ColorPrinterTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    ColorPrinter printer;

    @Before
    public void setupOutput() {
        printer = new ColorPrinter();
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
    public void printColorTestGreen1 () {

        double input = 0.0;
        printer.printColor(input);
        String actual = getOutput();
        String output = Colors.colors[3] + TrafficColors.GREEN + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestGreen2 () {

        double input = 3.999999999;
        printer.printColor(input);
        String actual = getOutput();
        String output = Colors.colors[3] + TrafficColors.GREEN + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestYellow1 () {

        double input = 4.0;
        printer.printColor(input);
        String actual = getOutput();
        String output = Colors.colors[4] + TrafficColors.YELLOW + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestYellow2 () {

        double input = 5.999999999;
        printer.printColor(input);
        String actual = getOutput();
        String output = Colors.colors[4] + TrafficColors.YELLOW + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestRed1 () {

        double input = 9.99999999;
        printer.printColor(input);
        String actual = getOutput();
        String output = Colors.colors[2] + TrafficColors.RED + Colors.colors[0];
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestOutOfRangeInput1 () {

        double input = 10.0000001;
        printer.printColor(input);
        String actual = getOutput();
        String output = "Out of range('0-4', '4-6', '6-10')";
        String expected = output.trim();

        assertEquals(expected, actual);
    }

    @Test
    public void printColorTestOutOfRangeInput2 () {

        double input = -0.99999999;
        printer.printColor(input);
        String actual = getOutput();
        String output = "Out of range('0-4', '4-6', '6-10')";
        String expected = output.trim();

        assertEquals(expected, actual);
    }
}
