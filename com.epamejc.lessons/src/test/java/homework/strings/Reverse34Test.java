package homework.strings;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.*;

public class Reverse34Test {

    @Test
    public void reverseStrNotNull() {
        String[] inputData = new String[]{"Hello", ""};
        String[] outputData = new String[]{"olleH", ""};

        for (int i = 0; i < inputData.length; i++) {
            assertEquals(outputData[i], Reverse34.reverseStr(inputData[i]));
        }
    }

    @Test(expected = NullPointerException.class)
    public void reverseStrNull() {
        Reverse34.reverseStr(null);
    }

    @Test(expected = NullPointerException.class)
    public void reverseCoreNull() {
        Reverse34.reverseCore(null);
    }

    @Test
    public void reverseCoreNotNull() {
        String[] inputData = new String[]{"Hello", "Hello World", ""};
        String[] outputData = new String[]{"olleH", "olleH dlroW", ""};

        for (int i = 0; i < inputData.length; i++) {
            assertEquals(outputData[i], Reverse34.reverseCore(inputData[i]));
        }
    }
}