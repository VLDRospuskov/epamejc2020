package homeworks.HW3_arrays.pyramidGeneration;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class PyramidAppTest {

    public static homeworks.HW3_arrays.pyramidGeneration.PyramidApp pyramidApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        pyramidApp = new homeworks.HW3_arrays.pyramidGeneration.PyramidApp();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing user input to define pyramid height with correct input
     */
    @Test
    public void testDefinePyramidHeight() {
        int expectedHeight = 4;
        systemInMock.provideLines("4");
        Scanner scanner = new Scanner(System.in);
        int actualHeight = pyramidApp.definePyramidHeight(scanner);
        Assert.assertEquals(expectedHeight, actualHeight);
    }

    /**
     * Testing user input to define pyramid height with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefinePyramidHeightIncorrect() {
        systemInMock.provideLines("1000");
        Scanner scanner = new Scanner(System.in);
        pyramidApp.definePyramidHeight(scanner);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}