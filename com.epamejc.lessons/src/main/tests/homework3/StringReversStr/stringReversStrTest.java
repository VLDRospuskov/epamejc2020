package homework3.StringReversStr;

import org.junit.Test;

import static org.junit.Assert.*;

public class stringReversStrTest {

    @Test
    public void reversStr() {

        stringReversStr stringReversStr = new stringReversStr();
        assertEquals(stringReversStr.reversStr("qwerty"),"ytrewq");
    }
}