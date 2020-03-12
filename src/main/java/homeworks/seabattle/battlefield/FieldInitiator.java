package homeworks.seabattle.battlefield;

import homeworks.seabattle.util.Area;
import homeworks.seabattle.util.Positions;
import homeworks.seabattle.util.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FieldInitiator implements Area<List<Integer>> {

    private List<Integer> shipsAmount = Stream.of(4, 3, 2, 1)
            .collect(Collectors.toList());

    public abstract void init();

    @Override
    public boolean isNoOverlapping(List<Integer> shipCells) {

        List<Integer> busyCells = new ArrayList<>();
        Positions.playerShipPositions.forEach(x -> busyCells.addAll(getArea(busyCells, x)));

        return Collections.disjoint(busyCells, shipCells);
    }

    protected void filterAndSet(List<Integer> shipCells) {

        if (isStraightLineCells(shipCells) && isNoOverlapping(shipCells)) {

            if (isRightShip(shipCells)) {

                Positions.playerShipPositions.addAll(shipCells);

                Positions.playerShips.add(new Ship(shipCells));
            }
        }
    }

    private boolean isRightShip(List<Integer> shipCells) {
        if (shipCells.size() > 0 && shipsAmount.get(shipCells.size() - 1) != 0) {
            shipsAmount.set(shipCells.size() - 1, shipsAmount.get(shipCells.size() - 1) - 1);
            return true;
        }
        return false;
    }


    private boolean isStraightLineCells(List<Integer> shipCells) {

        if (shipCells.size() > 1) {

            int[] count = getCount(shipCells);

            if (count[0] != shipCells.size() - 1 && count[1] != shipCells.size() - 1) {
                return false;
            }
        }
        return shipCells.size() < 5 && !shipCells.contains(-1);
    }


    private int[] getCount(List<Integer> shipCells) {

        int dCount = 0;
        int oCount = 0;

        for (int i = 0; i < shipCells.size(); i++) {

            if (i != 0 && Math.abs(shipCells.get(i) - shipCells.get(i - 1)) == 1) {
                oCount++;
            } else if (i != 0 && Math.abs(shipCells.get(i) - shipCells.get(i - 1)) == 10) {
                dCount++;
            }
        }
        return new int[]{oCount, dCount};
    }
}

