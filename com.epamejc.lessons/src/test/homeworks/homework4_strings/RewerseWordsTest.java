package homeworks.homework4_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RewerseWordsTest {
    RewerseWords rewerse;

    @Before
    public void setUp() {
        rewerse = new RewerseWords();
    }

    @Test
    public void testGetResult() {
        String request1 = "world of warcraft";
        String request2 = "я переворачиваю только!! слова!";
        String request3 = "Twentyone 21";

        String expected1 = "dlrow fo tfarcraw";
        String expected2 = "я юавичаровереп окьлот!! аволс!";
        String expected3 = "enoytnewT 21";

        assertEquals(expected1, rewerse.getResult(request1));
        assertEquals(expected2, rewerse.getResult(request2));
        assertEquals(expected3, rewerse.getResult(request3));

    }
}