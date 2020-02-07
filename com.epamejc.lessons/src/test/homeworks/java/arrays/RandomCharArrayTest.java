package homeworks.java.arrays;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class RandomCharArrayTest {

    private static final InputStream in = System.in;
    private static final OutputStream out = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private BufferedReader bufferedReader;

    @Before
    public void setOutput() {
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
    public void testGenerateArr() {
        RandomCharArray array = new RandomCharArray();
        String input = "13 12\n";
        setInputStream(input);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String expectedOutput = "Введите размерность массива массиов:\n" +
                "\n" +
                "Пример: 14 2\n" +
                "\n" +
                "Array created!\n";

        array.generateArr(bufferedReader);
        assertEquals(expectedOutput, getOutput());


    }

    @AfterClass
    public static void systemRestore() {
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

}
