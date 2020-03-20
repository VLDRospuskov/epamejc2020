package seabattle.Enums;

import java.util.Random;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction parseDirectionFromString(String value) {
        return Direction.valueOf(value.toUpperCase());
//        if (value.equals("up")) {
//            return UP;
//        }
//        if (value.equals("down")) {
//            return DOWN;
//        }
//        if (value.equals("left")) {
//            return LEFT;
//        }
//        if (value.equals("right")) {
//            return RIGHT;
//        }
//        return null;
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
