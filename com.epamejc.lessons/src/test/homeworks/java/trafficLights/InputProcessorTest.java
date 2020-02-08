package homeworks.java.trafficLights;


import lombok.SneakyThrows;
import org.junit.*;

import java.io.*;

public class InputProcessorTest {

    private static BufferedReader reader;
    private static final InputStream in = System.in;

    private static ByteArrayInputStream testIn;
    private static InputProcessor inputProcessor;

    @BeforeClass
    public static void setup() {
        inputProcessor = new InputProcessor();
    }


    @Test
    public void testReadInputGreen() {
        String input = "1.15";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        Lights expected = Lights.GREEN;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadInputYellow() {
        String input = "3.5";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        Lights expected = Lights.YELLOW;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadInputRed() {
        String input = "6";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        Lights expected = Lights.RED;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadInputWrongInputString() {
        String input = "asdfe df";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadInputWrongInputLength() {
        String input = "1.611";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        Lights expected = Lights.WRONG_INPUT;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadInputReaderException() {

        String input = "1.14";
        setInputStream(input);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lights expected = Lights.EXCEPTION;
        Lights actual = inputProcessor.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    private void setInputStream(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterClass
    public static void after() {
        System.setIn(in);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
