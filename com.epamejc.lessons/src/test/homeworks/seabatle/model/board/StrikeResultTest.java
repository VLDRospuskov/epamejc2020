package homeworks.seabatle.model.board;

import homeworks.seabatle.myenum.StrikeResult;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StrikeResultTest {

    @Test
    public void getDescription() {
        String[] expected = {"killed", "wounded", "missed", "shooted", "loseed"};
        String[] actual = new String[5];
        int i = 0;
        for (StrikeResult result : StrikeResult.values()) {
            actual[i] = result.getDescription();
            i++;
        }
        assertArrayEquals(expected, actual);
    }
}