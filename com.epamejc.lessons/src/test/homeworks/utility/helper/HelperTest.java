package homeworks.utility.helper;

import lombok.SneakyThrows;
import org.junit.*;

import java.io.*;

public class HelperTest {
    public static BufferedReader reader;

    @BeforeClass
    public static void setup() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Stream opened");
    }

    @Test
    @SneakyThrows
    public void testGetInt() {
        InputStream sysInBackup = System.in;

        String expected = "Hello World";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        String actual = Helper.getString();
        Assert.assertEquals(actual, expected);

        System.setIn(sysInBackup);
    }

}
