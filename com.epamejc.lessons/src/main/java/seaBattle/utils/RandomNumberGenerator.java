package seaBattle.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomInRange(int range) {
        Random rand = new Random();
        int randomNum = rand.nextInt((range - 1) + 1) + 1;
        return randomNum;
    }
}
