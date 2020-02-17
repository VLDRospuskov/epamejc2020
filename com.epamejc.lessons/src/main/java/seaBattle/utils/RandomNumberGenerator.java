package seaBattle.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomInRange(int range) {
        Random rand = new Random();
        return rand.nextInt((range - 1) + 1) + 1;
    }

    public static String generateRandomDirection() {
        int randomDirection = RandomNumberGenerator.generateRandomInRange(4);
        return randomDirection == 0 ? "up" : randomDirection == 1
                ? "right" : randomDirection == 2 ? "down" : "left";
    }
}
