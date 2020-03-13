package homework.homework3;

import homework.homework3.arrays.RandomCharacterGenerator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomCharacterGeneratorTest {

    @Test
    public void getChar() {
        for(int i = 0; i < 1_000_000; i++) {
            char ch = new RandomCharacterGenerator().getRandomChar();

            assertTrue(ch >= RandomCharacterGenerator.FIRST_ASCII_CODE);
            assertTrue(ch <= RandomCharacterGenerator.LAST_ASCII_CODE);
        }
    }
}