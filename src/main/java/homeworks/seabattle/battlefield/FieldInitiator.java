package homeworks.seabattle.battlefield;

import homeworks.seabattle.ConsoleReader;
import homeworks.seabattle.Positions;
import homeworks.seabattle.Ship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FieldInitiator {

    private List<String> cellPool = new ArrayList<>();
    private List<String> cells = Positions.allCells;
    private List<Ship> ships = new ArrayList<>();
    private List<Integer> shipsAmount = Stream.of(4, 3, 2, 1)
            .collect(Collectors.toList());

    public void init() throws IOException {

        swapShipPositions();

        FieldPrinter fieldPrinter = new FieldPrinter();

        String userShip;

        while (ships.size() != 10) {

            fieldPrinter.print();

            System.out.print("\nSelect cells to put your ship in\n" +
                    "for example 'a1 a2 a3 a4'\n" +
                    "dont forget that ship should be a straight line and not diagonal: ");

            userShip = ConsoleReader.reader.readLine();

            if (userShip.equalsIgnoreCase("exit")) {
                break;
            }

            if (userShip.length() != 0) {
                filterAndSet(userShip);
            }
        }
    }


    private void swapShipPositions() {

        List<Integer> x = Positions.playerShipPositions;
        Positions.playerShipPositions = Positions.opponentShipPositions;
        Positions.opponentShipPositions = x;

        List<Ship> s = Positions.playerShips;
        Positions.playerShips = Positions.opponentShips;
        Positions.opponentShips = s;
    }


    private void filterAndSet(String userShip) {

        List<String> shipCells = getList(userShip);

        if (isStraightLineCells(shipCells) && isNoOverlapping(shipCells)) {

            if (isRightShip(shipCells)) {

                cellPool.addAll(shipCells);

                ships.add(new Ship(Arrays.stream(findCellPositions(shipCells))
                        .boxed()
                        .collect(Collectors.toList())));

                Positions.playerShipPositions = Arrays
                        .stream(findCellPositions(cellPool))
                        .boxed()
                        .collect(Collectors.toList());

                Positions.playerShips = ships;
            } else {
                System.out.println("You have no such type of ships left!");
            }

        } else {
            System.out.println("\nWrong input!\nTry again!");
        }
    }

    private boolean isRightShip(List<String> shipCells) {
        if (shipsAmount.get(shipCells.size()-1) != 0) {
            shipsAmount.set(shipCells.size()-1, shipsAmount.get(shipCells.size()-1) - 1);
            return true;
        }
        return false;
    }

    private List<String> getList(String userShip) {
        return Arrays.stream(userShip.split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }


    private boolean isStraightLineCells(List<String> shipCells) {

        int size = shipCells.size();
        if (size > 1) {

            int[] cellPositions = findCellPositions(shipCells);

            int[] count = getCount(cellPositions);

            if (count[0] != cellPositions.length - 1 && count[1] != cellPositions.length - 1) {
                return false;
            }
        }
        return size < 5;
    }


    private int[] findCellPositions(List<String> shipCells) {

        int[] cellPositions = new int[shipCells.size()];

        for (int i = 0; i < shipCells.size(); i++) {
            cellPositions[i] = cells.indexOf(shipCells.get(i));
        }
        return cellPositions;
    }


    private int[] getCount(int[] cellPositions) {

        int dCount = 0;
        int oCount = 0;
        for (int i = 0; i < cellPositions.length; i++) {

            if (i != 0 && Math.abs(cellPositions[i] - cellPositions[i - 1]) == 1) {
                oCount++;
            } else if (i != 0 && Math.abs(cellPositions[i] - cellPositions[i - 1]) == 10) {
                dCount++;
            }
        }
        return new int[]{oCount, dCount};
    }


    private boolean isNoOverlapping(List<String> shipCells) {

        List<String> busyCells = new ArrayList<>();

        for (String s : cellPool) {

            busyCells.add(s);
            int target = cells.indexOf(s);

            if (s.equalsIgnoreCase(cells.get(0))) {
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (s.equalsIgnoreCase(cells.get(9))) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
            } else if (s.equalsIgnoreCase(cells.get(90))) {
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target + 1));
            } else if (s.equalsIgnoreCase(cells.get(99))) {
                busyCells.add(cells.get(target - 11));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 1));
            } else if (s.matches("^.1$")) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (s.matches("^.10$")) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 11));
            } else if (s.matches("^[Aa].$")) {
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (s.matches("^[Jj].$")) {
                busyCells.add(cells.get(target - 11));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
            } else {
                busyCells.add(cells.get(target - 11));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            }
        }
        return Collections.disjoint(busyCells, shipCells);
    }
}
