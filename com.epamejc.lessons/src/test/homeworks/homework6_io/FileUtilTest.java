package homeworks.homework6_io;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void compareSpeed() {
        FileUtil fileUtil = new FileUtil();
        String actualResult = fileUtil.compareSpeed();
        String expectedResult = "Stream slower. Difference is";
        assertTrue(actualResult.contains(expectedResult));
    }
}