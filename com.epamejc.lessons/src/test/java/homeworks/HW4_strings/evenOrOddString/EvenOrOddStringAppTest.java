package homeworks.HW4_strings.evenOrOddString;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class EvenOrOddStringAppTest {

    public static homeworks.HW4_strings.evenOrOddString.EvenOrOddStringApp evenOrOddStringApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        evenOrOddStringApp = new homeworks.HW4_strings.evenOrOddString.EvenOrOddStringApp();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing user input to define filter type with correct input
     */
    @Test
    public void testEnterFilterType() {
        String expectedType = "even";
        systemInMock.provideLines("even");
        Scanner scanner = new Scanner(System.in);
        String actualType = evenOrOddStringApp.enterFilterType(scanner);
        Assert.assertEquals(expectedType, actualType);
    }

    /**
     * Testing user input to define filter type with incorrect input
     */
    @Test(expected = Exception.class)
    public void testEnterFilterTypeIncorrect() {
        String expectedType = "odd";
        systemInMock.provideLines("odd10");
        Scanner scanner = new Scanner(System.in);
        evenOrOddStringApp.enterFilterType(scanner);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}