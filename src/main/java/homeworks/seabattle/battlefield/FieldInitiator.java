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

public class FieldInitiator {

    public List<String> cellPool = new ArrayList<>();

    public List<Ship> ships = new ArrayList<>();

    private List<String> cells = Positions.allCells;

    public List<Integer> init() throws IOException {

        FieldPrinter fieldPrinter = new FieldPrinter();
        while (true) {

            fieldPrinter.print();

            System.out.print("\nSelect cells to put your ship in\n" +
                    "for example 'a1 a2 a3 a4'\n" +
                    "dont forget that ship should be a straight line and not diagonal: ");
            String userShip = ConsoleReader.reader.readLine();
            if (userShip.equalsIgnoreCase("exit")) {
                break;
            }

            filterAndAddToCellPool(userShip);
        }
        return Arrays
                .stream(findCellPositions(cellPool))
                .boxed()
                .collect(Collectors.toList());
    }


    private void filterAndAddToCellPool(String userShip) {

        List<String> shipCells = Arrays
                .stream(userShip.split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.toList());


        if (isStraightLineCells(shipCells) && isNoOverlapping(shipCells)) {

            for (String shipCell : shipCells) {
                cellPool.add(shipCell.toUpperCase());
            }
            ships.add(new Ship(Arrays.stream(findCellPositions(shipCells))
                    .boxed()
                    .collect(Collectors.toList())));
        } else {
            System.out.println("\nWrong input!\nTry again!");
        }
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
}
