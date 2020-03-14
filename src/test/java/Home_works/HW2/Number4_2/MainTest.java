package Home_works.HW2.Number4_2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void pow() {
            int inputBase = 3;
            int inputPower = 2;
            long expectedNumber = 9;
            long actualNumber = Main.pow(inputBase, inputPower);

            Assert.assertEquals(expectedNumber, actualNumber);
        }
    }