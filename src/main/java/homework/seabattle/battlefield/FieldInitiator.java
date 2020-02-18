package homework.seabattle.battlefield;

import homework.seabattle.ConsoleReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FieldInitiator {


    public List<String> cellPool = new ArrayList<>();
//    public static String[] allCells = {
//            "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
//            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
//            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
//            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
//            "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10",
//            "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10",
//            "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
//            "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10",
//            "Y1", "Y2", "Y3", "Y4", "Y5", "Y6", "Y7", "Y8", "Y9", "Y10",
//            "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"};


    public void init() throws IOException {

        Field field = new Field();
        while (true) {

            List<Integer> shipPositions = Arrays
                    .stream(findCellPositions(cellPool))
                    .boxed()
                    .collect(Collectors.toList());

            field.printField(shipPositions);

            System.out.print("\nSelect cells to put your ship in\n" +
                    "for example 'a1 a2 a3 a4'\n" +
                    "dont forget that ship should be a straight line and not diagonal: ");
            String userShip = ConsoleReader.reader.readLine();
            if (userShip.equalsIgnoreCase("exit")) {
                break;
            }

            filterAndAddToCellPool(userShip);
        }
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

        } else {
            System.out.println("\nWrong input!\nTry again!");
        }
    }


    private String[] allCells = {
            "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "Y1", "J1",
            "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "Y2", "J2",
            "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3", "Y3", "J3",
            "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4", "Y4", "J4",
            "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "Y5", "J5",
            "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "Y6", "J6",
            "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "Y7", "J7",
            "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8", "Y8", "J8",
            "A9", "B9", "C9", "D9", "E9", "F9", "G9", "H9", "Y9", "J9",
            "A10", "B10", "C10", "D10", "E10", "F10", "G10", "H10", "Y10", "J10"};


    private boolean isNoOverlapping(List<String> shipCells) {

        List<String> cells = Arrays.asList(allCells);

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

        List<String> cells = Arrays.asList(allCells);

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
