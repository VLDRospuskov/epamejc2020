package homeworks.homework3.task2_2;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ABStrategyTest {

    private static char[][] chars = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o'
            , 'p'}};
    private static ABStrategy abStrategy;

    @BeforeClass
    public static void BeforeClass() {
        abStrategy = new ABStrategy();
    }

    @Test
    public void selectAStrategy() {
        String expected = "acik";
        String actual = abStrategy.selectStrategy(chars, "a");
        assertEquals(expected, actual);
    }

    @Test
    public void selectBStrategy() {
        String expected = "fhnp";
        String actual = abStrategy.selectStrategy(chars, "b");
        assertEquals(expected, actual);
    }

    @Test
    public void selectUnexpectedStrategy() {
        String expected = "";
        String actual = abStrategy.selectStrategy(chars, "g");
        assertEquals(expected, actual);
    }

}