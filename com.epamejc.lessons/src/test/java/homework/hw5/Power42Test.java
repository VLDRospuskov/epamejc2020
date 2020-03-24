package homework.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Power42Test {

    @Test
    public void power() {
        class TestCase {
            int input1;
            int input2;
            int expectedOutput;


            public TestCase(int input1, int input2, int expectedOutput) {
                this.input1 = input1;
                this.input2 = input2;
                this.expectedOutput = expectedOutput;
            }
        }

        TestCase[] testCase = new TestCase[]{
                new TestCase(3, 1, 3),
                new TestCase(3, 2, 9),
                new TestCase(3, 3, 27),
                new TestCase(10, 1, 10),
                new TestCase(10, 2, 100),
                new TestCase(10, 3, 1000)
        };

        for (TestCase tc : testCase) {
            assertEquals(tc.expectedOutput, Power42.power(tc.input1, tc.input2));
        }
    }
}