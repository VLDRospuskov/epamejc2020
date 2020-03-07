package homeworks.java.hw4.strings_2;

import org.junit.*;
import static org.junit.Assert.*;

public class GenerateStringFromInputStringByIndexTest {

    private GenerateStringFromInputStringByIndex generator;

    @Before
    public void setup() {
        generator = new GenerateStringFromInputStringByIndex();
    }

    @Test
    public void getCharByIndexTest() {
        char expected = 'l';
        char actual = generator.getCharByIndex(2, "Hello");
        assertEquals(expected, actual);
    }


}
