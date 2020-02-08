package homeworks.HW4_strings.replaceCharsByIndices;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ReplaceCharsApplicationTest {

    public static homeworks.HW4_strings.replaceCharsByIndices.ReplaceCharsApplication indexExchangeApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        indexExchangeApp = new homeworks.HW4_strings.replaceCharsByIndices.ReplaceCharsApplication();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing user input to define indices with correct input
     */
    @Test
    public void testEnterIndexes() {
        int[] expectedIndexArray = new int[]{2, 4};
        String inputString = "Hello world";
        ReplaceCharsByIndices replaceCharsObject = new ReplaceCharsByIndices();

        systemInMock.provideLines("2 s 4");
        Scanner scanner = new Scanner(System.in);
        int[] actualIndexArray = indexExchangeApp.enterIndexes(scanner, inputString, replaceCharsObject);
        Assert.assertEquals(expectedIndexArray[0], actualIndexArray[0]);
        Assert.assertEquals(expectedIndexArray[1], actualIndexArray[1]);
    }

    /**
     * Testing user input to define indices with incorrect input
     */
    @Test(expected = Exception.class)
    public void testEnterIndexesIncorrect() {
        int[] expectedIndexArray = new int[]{2, 10};
        String inputString = "Hel";
        ReplaceCharsByIndices replaceCharsObject = new ReplaceCharsByIndices();

        systemInMock.provideLines("2 s 4");
        Scanner scanner = new Scanner(System.in);
        int[] actualIndexArray = indexExchangeApp.enterIndexes(scanner, inputString, replaceCharsObject);
        Assert.assertEquals(expectedIndexArray[0], actualIndexArray[0]);
        Assert.assertEquals(expectedIndexArray[1], actualIndexArray[1]);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}