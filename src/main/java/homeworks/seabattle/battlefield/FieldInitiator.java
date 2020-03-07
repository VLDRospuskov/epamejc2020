package homeworks.seabattle.battlefield;

import homeworks.seabattle.Positions;
import homeworks.seabattle.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FieldInitiator {

    protected List<Ship> ships = new ArrayList<>();
    private List<Integer> shipsAmount = Stream.of(4, 3, 2, 1)
            .collect(Collectors.toList());

    public abstract void init();

    protected void swapShipPositions() {

        List<Integer> x = Positions.playerShipPositions;
        Positions.playerShipPositions = Positions.opponentShipPositions;
        Positions.opponentShipPositions = x;

        List<Ship> s = Positions.playerShips;
        Positions.playerShips = Positions.opponentShips;
        Positions.opponentShips = s;
    }


    protected void filterAndSet(List<Integer> shipCells) {

        if (isStraightLineCells(shipCells) && isNoOverlapping(shipCells)) {

            if (isRightShip(shipCells)) {

                ships.add(new Ship(shipCells));

                Positions.playerShipPositions.addAll(shipCells);

                Positions.playerShips = ships;

//            } else {
//                System.out.println("You have no such type of ships left!");
            }

//        } else {
//            System.out.println("\nWrong input!\nTry again!");
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


    private boolean isNoOverlapping(List<Integer> shipCells) {

        List<Integer> busyCells = new ArrayList<>();
        Positions.playerShipPositions.forEach(x -> busyCells.addAll(getArea(busyCells, x)));

        return Collections.disjoint(busyCells, shipCells);
    }

    private List<Integer> getArea(List<Integer> busyCells, Integer x) {

        busyCells.add(x);

        switch (x % 10) {
            case 0:
                downRightQuarter(busyCells, x);
                upRightQuarter(busyCells, x);
                break;
            case 9:
                downLeftQuarter(busyCells, x);
                upLeftQuarter(busyCells, x);
                break;
            default:
                upRightQuarter(busyCells, x);
                upLeftQuarter(busyCells, x);
                downRightQuarter(busyCells, x);
                downLeftQuarter(busyCells, x);
        }
        return busyCells;
    }

    private void downLeftQuarter(List<Integer> busyCells, Integer x) {
        busyCells.add(x - 11);
        busyCells.add(x - 10);
        busyCells.add(x - 1);
    }

    private void downRightQuarter(List<Integer> busyCells, Integer x) {
        busyCells.add(x - 10);
        busyCells.add(x - 9);
        busyCells.add(x + 1);
    }

    private void upLeftQuarter(List<Integer> busyCells, Integer x) {
        busyCells.add(x - 1);
        busyCells.add(x + 9);
        busyCells.add(x + 10);
    }

    private void upRightQuarter(List<Integer> busyCells, Integer x) {
        busyCells.add(x + 1);
        busyCells.add(x + 10);
        busyCells.add(x + 11);
    }
}

