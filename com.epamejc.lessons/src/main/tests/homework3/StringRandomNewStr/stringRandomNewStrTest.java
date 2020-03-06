package homework3.StringRandomNewStr;

import org.junit.Test;

import static org.junit.Assert.*;

public class stringRandomNewStrTest {

    @Test
    public void applyStrategy() {
        stringRandomNewStr stringRandomNewStr = new stringRandomNewStr();

        assertEquals(stringRandomNewStr.applyStrategy("testqwerty","A"),"tsqet");
    }
}