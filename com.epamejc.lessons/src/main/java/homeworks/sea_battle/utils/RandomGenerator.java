package homeworks.sea_battle.utils;

import homeworks.sea_battle.data.Coordinates;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    //Generates random coordinates for ships installing or bot shots.
    public static Coordinates generateCoordinates() {
        return new Coordinates(random.nextInt(10), random.nextInt(10));
    }

    //Generates random direction for ships installing
    public static boolean generateDirection() {
        return random.nextBoolean();
    }

    public static int generatePoint(int n) {
        return random.nextInt(n);
    }
}
