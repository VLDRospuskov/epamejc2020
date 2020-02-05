package test.lessons.java.lesson11.example1;

import org.junit.*;

import main.lessons.java.lesson11.example1.*;
import static org.junit.Assert.assertEquals;

public class OperationsTest {

    @Rule
    public PrepareRule prepareRule = new PrepareRule();
    private static main.lessons.java.lesson11.example1.Operations operations;

    @Before
    public void setup2() {
        System.out.println("SETUP BEFORE");
    }

    @BeforeClass
    public static void setup() {
        operations = new Operations();
//        System.out.println("SETUP BEFORE CLASS");
    }
//
//    @After
//    public void after() {
//        System.out.println("AFTER");
//    }

    @AfterClass
    public static void after2() {
        System.out.println("AFTER CLASS");
    }

    @Test
    public void testGetSum() {
        System.out.println("TEST 1");
        int actual = operations.getSum(3, 5);
        int actualSecond = operations.getSum(3, 5);
        int expected = 8;
        int expectedSecond = 10;
        assertEquals(expected, actual);
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    public void testGetSumOfStringsWithCorrectValues() {
        System.out.println("TEST 2");
        int actual = operations.getSumOfStrings("10", "12");
        int expected = 22;
        assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetSumOfStringsWithIncorrectValues() {
        System.out.println("TEST 3");
        operations.getSumOfStrings("String", "12");
    }

}
