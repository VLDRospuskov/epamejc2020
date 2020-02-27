package homework.Recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountDigits43Test {

    @Test
    public void count() {
        class TestCase {
            int input;
            int expectedOutput;

            private TestCase(int input, int expectedOutput) {
                this.input = input;
                this.expectedOutput = expectedOutput;
            }
        }

        TestCase[] testCase = new TestCase[]{
                new TestCase(123, 3),
                new TestCase(123456789, 9),
                new TestCase(1_2_3, 3),
                new TestCase(-123, 3)
        };

        for (TestCase tc : testCase) {
            assertEquals(tc.expectedOutput, CountDigits43.count(tc.input));
        }
    }
}