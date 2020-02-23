package homeworks.utility.helper;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;

import java.io.*;

public class HelperTest {
    private static final InputStream backup = System.in;

    @AfterClass
    public static void close() {
        System.setIn(backup);
    }

    @Test
    @SneakyThrows
    public void testGetString() {
        String expected = "Hello World";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        String actual = Helper.getString();
        Assert.assertEquals(expected, actual);
    }

}
