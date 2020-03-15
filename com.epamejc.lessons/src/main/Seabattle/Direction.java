package Seabattle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {

    UP,
    DOWN,
    RIGHT,
    LEFT;

    private static final List<Direction> DIRECTIONS =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = DIRECTIONS.size();
    private static final Random RANDOM = new Random();

    public static Direction randomDirection() {
        return DIRECTIONS.get(RANDOM.nextInt(SIZE));
    }

    @Override
    public String toString() {
        switch (this) {
            case UP:
                return "up";
            case DOWN:
                return "down";
            case RIGHT:
                return "right";
            case LEFT:
                return "left";
            default:
                return null;
        }
    }
}
