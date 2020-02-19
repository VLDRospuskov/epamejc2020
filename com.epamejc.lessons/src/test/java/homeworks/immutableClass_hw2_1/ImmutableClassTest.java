package homeworks.immutableClass_hw2_1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class ImmutableClassTest {
    private static ImmutableClass immutableClass;
    private static int[] ints = {1, 2, 3};
    private static String name = "John";
    private static double aDouble = 0.2;


    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Immutable Class test");
        immutableClass = new ImmutableClass(ints, name, aDouble);
    }

    @Test
    public void getAr() {
        int[] actual = immutableClass.getAr();
        int[] expected = ints;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getName() {
        String actual = name;
        String expected = immutableClass.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getDoubleValue() {
        double actual = aDouble;
        double expected = immutableClass.getDoubleValue();
        assertEquals(expected,actual,0.001);
    }
}
