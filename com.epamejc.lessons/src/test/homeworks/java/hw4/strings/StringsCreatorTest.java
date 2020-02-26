package homeworks.java.hw4.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StringsCreatorTest {

    @Test
    public void testReturnEvenChars() {
        EvenOddReturner evenReturner = new EvenOddReturner();
        final String expected = "elJv!";
        String actual = evenReturner.makeStringFromEvenOrOddChars("HelloJava!", "even");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReturnOddChars() {
        EvenOddReturner oddReturner = new EvenOddReturner();
        final String expected = "Hloaa";
        String actual = oddReturner.makeStringFromEvenOrOddChars("HelloJava!", "odd");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLineByIndexes() {
        //("Hello World and Java" "4 8 13 8 8 4 1");
        LineByIndexesMaker lineByIndexesMaker = new LineByIndexesMaker();
        final String expected = "ornrroe";
        final ArrayList<Integer> listOfIndexes = new ArrayList<Integer>();
        listOfIndexes.add(4);
        listOfIndexes.add(8);
        listOfIndexes.add(13);
        listOfIndexes.add(8);
        listOfIndexes.add(8);
        listOfIndexes.add(4);
        listOfIndexes.add(1);
        String actual = lineByIndexesMaker.makeTheLineByIndexes("Hello World and Java", listOfIndexes);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceChars() {
        CharsReplacer charsReplacer = new CharsReplacer();
        Assert.assertEquals("Wello Horld And Java", charsReplacer.replaceTwoChars("Hello World And Java",
                0, 6));
        Assert.assertEquals("Helno World Ald Java", charsReplacer.replaceTwoChars("Hello World And Java",
                3, 13));
        Assert.assertEquals("Helld Worlo And Java", charsReplacer.replaceTwoChars("Hello World And Java",
                10, 4));
    }

    @Test
    public void testReverseWords() {
        WordsReverser wordsReverser = new WordsReverser();
        Assert.assertEquals("olleH dlroW dna avaJ", wordsReverser.reverseWordsAndPutOnInitialPlaces(
                "Hello World and Java"));
    }
}