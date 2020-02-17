package main.homeworks.java.homework4.strings.task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordReverserTest {

    @Test
    public void reverse() {
        String input1 = "The sixth sick sheik's sixth sheep's sick";
        String input2 = "I have got a date at a quarter to eight; I’ll see you at the gate, so don’t be late.";
        String expected1 = "ehT htxis kcis s'kiehs htxis s'peehs kcis";
        String expected2 = "I evah tog a etad ta a retrauq ot thgie; ll’I ees uoy ta eht etag, os t’nod eb etal.";
        String actual1 = new WordReverser(input1).reverse();
        String actual2 = new WordReverser(input2).reverse();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}