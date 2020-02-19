package seaBattle.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomInRange(int range) {
        Random rand = new Random();
        return rand.nextInt((range - 1) + 1) + 1;
    }

    public static String generateRandomDirection() {
        int randomDirection = (int) (Math.random() * 4);
//        int randomDirection = RandomNumberGenerator.generateRandomInRange(4);

        return randomDirection == 0 ? "up" : randomDirection == 1
                ? "right" : randomDirection == 2 ? "down" : "left";
    }

    public static int [] generateRandomCoordinates(int range) {
        int[] randomCoords = new int[2];
        Random rand = new Random();
        randomCoords[0] = rand.nextInt((range - 1) + 1) + 1;
        randomCoords[1] = rand.nextInt((range - 1) + 1) + 1;
        return randomCoords;
    }
}
