package homework.homework3.arrays;

import java.util.Random;

public class RandomCharacterGenerator {
    public static final int FIRST_ASCII_CODE = 33;
    public static final int LAST_ASCII_CODE = 127;

    private final Random random = new Random();

    public char getChar() {
        return (char) (FIRST_ASCII_CODE + random.nextInt(LAST_ASCII_CODE - FIRST_ASCII_CODE));
    }
}
