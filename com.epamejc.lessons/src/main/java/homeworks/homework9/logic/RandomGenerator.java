package homeworks.homework9.logic;

import java.math.BigDecimal;
import java.util.Random;

public class RandomGenerator {

    public static int getRandomOperation() {
        return new Random().nextInt(3);
    }

    public static BigDecimal getRandomAmount() {
        double result = new Random().nextInt(100_000 - 50_000 + 1) + 50_000;
        return BigDecimal.valueOf(result);
    }

    public static int getRandomNumber(int n) {
        return new Random().nextInt(n);
    }

}
