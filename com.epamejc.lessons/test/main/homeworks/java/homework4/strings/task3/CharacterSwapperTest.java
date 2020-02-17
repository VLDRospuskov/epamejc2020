package main.homeworks.java.homework4.strings.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterSwapperTest {

    private CharacterSwapper characterSwapper = new CharacterSwapper("Hello world");

    @Test
    public void TestSwap() {
        String expected = "dello worlH";
        String actual = characterSwapper.swap(0, 10);

        assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void TestSwapOOBE() {
        String actual = characterSwapper.swap(0, 15);
    }
}