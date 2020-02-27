package homework.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChangePlace33Test {

    @Test
    public void changePlaceNotNull() {
        class TestCase {
            private String input, output;
            private int index1, index2;

            public TestCase(String input, String output, int index1, int index2) {
                this.input = input;
                this.output = output;
                this.index1 = index1;
                this.index2 = index2;
            }
        }
        TestCase[] testCases = new TestCase[]{
                new TestCase("Hello", "eHllo", 0, 1),
                new TestCase("Dianka", "Dianka", 5, 2),
                new TestCase("Hello Dianka", "Dello Hianka", 0, 6),
        };

        for (TestCase tc : testCases) {
            assertEquals(tc.output, ChangePlace33.changePlaceCore(tc.input, tc.index1, tc.index2));
        }
    }
}