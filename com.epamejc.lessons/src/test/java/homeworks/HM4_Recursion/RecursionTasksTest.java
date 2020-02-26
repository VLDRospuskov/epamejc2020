package homeworks.HM4_Recursion;

import org.junit.Assert;
import org.junit.Test;

public class RecursionTasksTest {

    RecursionTasks recursionTasks = new RecursionTasks();

    @Test
    public void testFibonacci() {
        int expected = 13;
        int actual = recursionTasks.fibonacci(7);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPower() {
        int expected = 81;
        int actual = recursionTasks.power(3, 4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfDigits() {
        int expected = 9;
        int actual = recursionTasks.numberOfDigits(543219876);

        Assert.assertEquals(expected, actual);
    }

}
