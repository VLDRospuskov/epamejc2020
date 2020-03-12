package homeworks.homework2;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableClassTest {

    private static ImmutableClass immutableClass;
    private static int[] ints = {1, 2, 3, 4, 5};
    private static String string = "test String";
    private static double aDouble = 3.14;

    @BeforeClass
    public static void BeforeClass() {

        immutableClass = new ImmutableClass(ints, string, aDouble);
    }

    @Test
    public void getAr() {
        int[] actual = immutableClass.getAr();
        assertArrayEquals(ints, actual);
    }

    @Test
    public void getName() {
        String actual = immutableClass.getName();
        assertEquals(string, actual);
    }

    @Test
    public void getDoubleValue() {
        double actual = immutableClass.getDoubleValue();
        assertEquals(aDouble, actual, 0.001);
    }

}