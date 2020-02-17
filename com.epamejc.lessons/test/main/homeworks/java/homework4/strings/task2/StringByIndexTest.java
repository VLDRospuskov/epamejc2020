package main.homeworks.java.homework4.strings.task2;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class StringByIndexTest {

    private StringByIndex stringByIndex;
    private String inputString = "Supercalifragilisticexpialidocious";

    @Test
    public void TestAddLetterCorrect() {
        String input = "5\n6\n7\n14\n\n";
        stringByIndex = new StringByIndex(new Scanner(input), inputString);
        String expected = "call";
        String actual = stringByIndex.addLetter();

        assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void TestAddLetterNFE() {
        String input = "15\n6\n17\nbreak";
        stringByIndex = new StringByIndex(new Scanner(input), inputString);
        String actual = stringByIndex.addLetter();
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void TestAddLetterOOBE() {
        String input = "22\n113";
        stringByIndex = new StringByIndex(new Scanner(input), inputString);
        String actual = stringByIndex.addLetter();
    }

    @Test(expected = NoSuchElementException.class)
    public void TestAddLetterNSEE() {
        String input = "";
        stringByIndex = new StringByIndex(new Scanner(input), inputString);
        String actual = stringByIndex.addLetter();

    }
}