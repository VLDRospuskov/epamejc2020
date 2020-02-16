package homework.homework2.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomCharacterGeneratorTest {

    @Test
    public void getChar() {
        for(int i = 0; i < 1_000_000; i++) {
            char ch = new RandomCharacterGenerator().getChar();

            assertTrue(ch >= RandomCharacterGenerator.FIRST_ASCII_CODE);
            assertTrue(ch <= RandomCharacterGenerator.LAST_ASCII_CODE);
        }
    }
}