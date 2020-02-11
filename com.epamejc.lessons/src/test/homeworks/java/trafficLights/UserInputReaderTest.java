package homeworks.java.trafficLights;

import lombok.SneakyThrows;
import org.junit.*;

import java.io.*;

public class UserInputReaderTest {

    private static BufferedReader reader;
    private static final InputStream in = System.in;

    private static UserInputReader userInputReader;

    @BeforeClass
    public static void setup() {
        userInputReader = new UserInputReader();
    }

    @Test
    public void testReadInputNormally() {
        String input = "1.15";
        setInputStream(input);
        reader = new BufferedReader(new InputStreamReader(System.in));

        String actual = userInputReader.readInput(reader);

        Assert.assertEquals(input, actual);
    }

    @SneakyThrows
    @Test(expected = RuntimeException.class)
    public void testReadInputReaderException() {

        reader.close();
        String expected = "";
        String actual = userInputReader.readInput(reader);

        Assert.assertEquals(expected, actual);
    }

    private void setInputStream(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @SneakyThrows
    @AfterClass
    public static void after() {
        System.setIn(in);
        reader.close();
    }
}
