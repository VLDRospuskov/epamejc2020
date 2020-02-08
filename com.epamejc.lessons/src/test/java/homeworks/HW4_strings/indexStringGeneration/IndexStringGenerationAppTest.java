package homeworks.HW4_strings.indexStringGeneration;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class IndexStringGenerationAppTest {

    public static homeworks.HW4_strings.indexStringGeneration.IndexStringGenerationApp indexedStringApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        indexedStringApp = new homeworks.HW4_strings.indexStringGeneration.IndexStringGenerationApp();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing user input to define char index with correct input
     */
    @Test
    public void testEnterIndex() {
        int expectedIndex = 3;
        String enteredString = "Hello";
        systemInMock.provideLines("3");
        Scanner scanner = new Scanner(System.in);
        int actualIndex = indexedStringApp.enterIndex(scanner, enteredString);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    /**
     * Testing user input to define char index with incorrect input
     */
    @Test(expected = Exception.class)
    public void testEnterIndexIncorrect() {
        String enteredString = "Hello";
        systemInMock.provideLines("7");
        Scanner scanner = new Scanner(System.in);
        indexedStringApp.enterIndex(scanner, enteredString);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}