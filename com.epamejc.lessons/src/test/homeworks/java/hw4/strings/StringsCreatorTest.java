package homeworks.java.hw4.strings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.*;

public class StringsCreatorTest {
    private StringsCreator stringsCreator;

    @Before
    public void setUp(){
        stringsCreator = new StringsCreator();
    }

    @After
    public void restore(){
        stringsCreator = null;
    }

    @Test
    public void returnEvenChars() {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("HelloJava!\neven\n"));
        String expected = "elJv!";
        String actual = stringsCreator.returnEvenOrOddChars(bufferedReader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returnOddChars(){
        BufferedReader bufferedReader = new BufferedReader(new StringReader("HelloJava!\nodd\n"));
        String expected = "Hloaa";
        String actual = stringsCreator.returnEvenOrOddChars(bufferedReader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeLineByIndexes() {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("Hello World and Java\n4 8 13 8 8 4 1"));
        String expected = "ornrroe";
        String actual = stringsCreator.makeLineByIndexes(bufferedReader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceChars() {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("Hello World and Java\n0\n6"));
        String expected = "Wello Horld and Java";
        String actual = stringsCreator.replaceChars(bufferedReader);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseWords() {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("Hello World and Java"));
        String expected = "olleH dlroW dna avaJ";
        String actual = stringsCreator.reverseWords(bufferedReader);
        Assert.assertEquals(expected, actual);
    }
}