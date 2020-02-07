package homeworks.java.arrays;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class EngineTest {

    private final InputStream in = System.in;
    private final OutputStream out = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void SetOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void setInputStream(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void testRunInput1() {

        Engine engine = new Engine();
        String input = "1\n13 10\n5\n";

        String expectedOutput = "Welcome to an Array test program!\n" +
                "\n" +
                "\n" +
                "_________________________________________________\n" +
                "|1. Array input                                 |\n" +
                "|2. Display an array                            |\n" +
                "|3. Display every odd row and column as string  |\n" +
                "|4. Display every even row and column as string |\n" +
                "|5. Exit                                        |\n" +
                "|_______________________________________________|\n" +
                "Введите размерность массива массиов:\n" +
                "\n" +
                "Пример: 14 2\n" +
                "\n" +
                "Array created!\n" +
                "\n" +
                "_________________________________________________\n" +
                "|1. Array input                                 |\n" +
                "|2. Display an array                            |\n" +
                "|3. Display every odd row and column as string  |\n" +
                "|4. Display every even row and column as string |\n" +
                "|5. Exit                                        |\n" +
                "|_______________________________________________|\n";

        setInputStream(input);
        engine.run();

        assertEquals(expectedOutput, getOutput());
    }

    @AfterClass()
    public void afterAll() {
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }
}

