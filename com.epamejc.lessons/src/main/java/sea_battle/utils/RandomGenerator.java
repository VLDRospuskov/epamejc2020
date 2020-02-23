package sea_battle.utils;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static int[] generateCoordinates() {
        int[] coords = new int[2];
        coords[0] = random.nextInt(10);
        coords[1] = random.nextInt(10);

        return coords;
    }

    public static int generatePoint(int n) {
        return random.nextInt(n);
    }

    public static boolean generateDirection() {
        int direction = random.nextInt(2);

        if (direction == 0) {
            return true;
        } else {
            return false;
        }
    }
}
