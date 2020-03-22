package homework.homework7;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class OperatingSpeedCalculatorTest {

    private OperatingSpeedCalculator calculator;

    @Before
    public void setup()
    {
        calculator = new OperatingSpeedCalculator();
    }

    @Test
    @SneakyThrows
    public void measureFileReaderWriterSpeed() {
        File file = new File("target1.txt");
        file.delete();

        assertFalse(file.exists());
        calculator.measureFileReaderWriterSpeed();
        assertTrue(file.exists());
        assertNotEquals(0L, file.length());
    }

    @Test
    public void measureBufferedReaderWriterSpeed() {
        File file = new File("target2.txt");
        file.delete();

        assertFalse(file.exists());
        calculator.measureBufferedReaderWriterSpeed();
        assertTrue(file.exists());
        assertNotEquals(0L, file.length());
    }
}