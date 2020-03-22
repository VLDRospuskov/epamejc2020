package seabattle.enums;

import java.util.Random;

import static seabattle.enums.Direction.*;

public class DirectionMethods {

    public static Direction parseDirectionFromString(String value) {
        return Direction.valueOf(value.toUpperCase());
    }

    public static Direction getRandomDirection() {
        int randomInt = new Random().nextInt(4);
        switch (randomInt) {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return LEFT;
            case 3:
                return RIGHT;
            default:
                return null;
        }
    }

}
