package homework.Recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class Fibonacci41Test {

    @Test
    public void fibNaive() {
        class TestCase {
            int input;
            int expectedOutput;

            private TestCase(int input, int expectedOutput) {
                this.input = input;
                this.expectedOutput = expectedOutput;
            }
        }

        TestCase[] testCase = new TestCase[]{
                new TestCase(1, 1),
                new TestCase(2, 1),
                new TestCase(3, 2),
                new TestCase(4, 3),
                new TestCase(5, 5),
                new TestCase(6, 8),
                new TestCase(7, 13),
        };
        for (TestCase tc : testCase) {
            assertEquals(tc.expectedOutput, Fibonacci41.FibNaive(tc.input));
        }
    }
}