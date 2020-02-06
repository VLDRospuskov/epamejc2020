package homeworks.HW3_arrays.arrayGeneration;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimensionalArrayTest {

    public static homeworks.HW3_arrays.arrayGeneration.TwoDimensionalArray array;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void defineLinesQuantity() {
        int expectedLinesNum = 4;
        systemInMock.provideLines("4");
        Scanner scanner = new Scanner(System.in);
        int actualLinesNum = array.defineLinesQuantity(scanner);
        Assert.assertEquals(expectedLinesNum, actualLinesNum);

    }
}