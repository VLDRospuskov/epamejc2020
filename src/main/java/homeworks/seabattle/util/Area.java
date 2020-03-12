package homeworks.seabattle.util;

import java.util.List;

public interface Area<T> {

    boolean isNoOverlapping(T position);

    default List<Integer> getArea(List<Integer> busyCells, Integer x) {

        busyCells.add(x);

        switch (x % 10) {
            case 0:
                rightHalf(busyCells, x);
                break;
            case 9:
                leftHalf(busyCells, x);
                break;
            default:
                rightHalf(busyCells, x);
                leftHalf(busyCells, x);
        }
        return busyCells;
    }

    default void rightHalf(List<Integer> busyCells, Integer x) {
        busyCells.add(x - 10);
        busyCells.add(x - 9);
        busyCells.add(x + 1);
        busyCells.add(x + 10);
        busyCells.add(x + 11);
    }

    default void leftHalf(List<Integer> busyCells, Integer x) {
        busyCells.add(x - 11);
        busyCells.add(x - 10);
        busyCells.add(x - 1);
        busyCells.add(x + 9);
        busyCells.add(x + 10);
    }
}
