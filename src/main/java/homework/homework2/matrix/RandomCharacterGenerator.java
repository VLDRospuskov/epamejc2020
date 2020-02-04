package homework.homework2.matrix;

import java.util.Random;

public class RandomCharacterGenerator {
    private static final int FIRST_ASCII_CODE = 33;
    private static final int LAST_ASCII_CODE = 127;

    private final Random random = new Random();

    public char get() {
        return (char) (FIRST_ASCII_CODE + random.nextInt(LAST_ASCII_CODE - FIRST_ASCII_CODE));
    }
}
