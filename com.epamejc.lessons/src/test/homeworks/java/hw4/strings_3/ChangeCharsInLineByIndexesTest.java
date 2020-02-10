package homeworks.java.hw4.strings_3;

import org.junit.*;
import static org.junit.Assert.*;

public class ChangeCharsInLineByIndexesTest {

    private static ChangeCharsInLineByIndexes changer;

    @Before
    public void setup() {
        changer = new ChangeCharsInLineByIndexes();
    }

    @Test
    public void buildStringTest() {
        int[] indexes = {2, 4};
        String input = "Interface";
        String expected = "Inretface";
        String actual = changer.buildString(indexes, input);
        assertEquals(expected, actual);
    }
}
