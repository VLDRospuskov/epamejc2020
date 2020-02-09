package homeworks.java.hw3.arrays_2;


import org.junit.*;
import static org.junit.Assert.*;

public class StringGeneratorFromArrayByStrategyTest {

    private static StringGeneratorFromArrayByStrategy generator;

    @Before
    public void setup() {
        generator = new StringGeneratorFromArrayByStrategy();
    }

    @Test
    public void buildArrayTest() {
        int expectedLinesCount = 3;
        int expectedCharsCount = 5;
        int nums[] = {3, 5};
        char[][] arr = generator.buildArray(nums);
        int appliedLinesCount = arr.length;
        int appliedCharsCount = arr[0].length;
        assertEquals(expectedLinesCount, appliedLinesCount);
        assertEquals(expectedCharsCount, appliedCharsCount);
    }

    @Test
    public void getStrategyTest() {
        int[] nums = {3, 3};
        char[][] arr = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        String strategyA = "A";
        String strategyB = "B";
        String expectedA = "acgi";
        String expectedB = "e";
        String actualA = generator.getStrategy(nums, arr, strategyA);
        String actualB = generator.getStrategy(nums, arr, strategyB);
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
    }
}
