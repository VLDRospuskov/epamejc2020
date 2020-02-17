package homework.homework7.battlefield;

import homework.homework7.ConsoleReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FieldInitiator {

    public List<String> cellPool = new ArrayList<>();

    public void init() throws IOException {

        while (true) {

            System.out.print("Select cells to put your ship in\n" +
                    "for example 'a1 a2 a3 a4'\n" +
                    "dont forget that ship should be a straight line and not diagonal: ");
            String userShip = ConsoleReader.reader.readLine();
            if (userShip.equalsIgnoreCase("exit")) {
                break;
            }
            filterAndAddToCellPool(userShip);
        }
        ConsoleReader.reader.close();
    }

    private void filterAndAddToCellPool (String userShip) {

        String[] shipCells = userShip.split(" ");

        if (isStraightLineCells(shipCells) && isNoOverlapping(shipCells)) {

            for (int i = 0; i < shipCells.length; i++) {

                cellPool.add(shipCells[i]);
                System.out.println(cellPool.get(i));

            }
        } else {
            System.out.println("Wrong input!\nTry again!");
        }
    }

    private String[] allCells = {
            "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
            "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10",
            "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10",
            "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
            "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10",
            "Y1", "Y2", "Y3", "Y4", "Y5", "Y6", "Y7", "Y8", "Y9", "Y10",
            "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"};

    private boolean isNoOverlapping(String[] shipCells) {

        List<String> cells = new ArrayList<>();
        List<String> userCells = new ArrayList<>();
        Collections.addAll(userCells, shipCells);
        Collections.addAll(cells, allCells);
        List<String> busyCells = new ArrayList<>();

        for (int i=0; i<cellPool.size(); i++) {

            busyCells.add(cellPool.get(i));
            int target = cells.indexOf(cellPool.get(i));

            if (cellPool.get(i).equalsIgnoreCase(cells.get(0))) {
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (cellPool.get(i).equalsIgnoreCase(cells.get(9))) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
            } else if (cellPool.get(i).equalsIgnoreCase(cells.get(90))) {
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target + 1));
            } else if (cellPool.get(i).equalsIgnoreCase(cells.get(99))) {
                busyCells.add(cells.get(target - 11));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 1));
            } else if (cellPool.get(i).matches("[Aa].")) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 9));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (cellPool.get(i).matches("[Jj].")) {
                busyCells.add(cells.get(target - 1));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 11));
            } else if (cellPool.get(i).matches(".1")) {
                busyCells.add(cells.get(target - 10));
                busyCells.add(cells.get(target - 9));
                busyCells.add(cells.get(target + 1));
                busyCells.add(cells.get(target + 10));
                busyCells.add(cells.get(target + 11));
            } else if (cellPool.get(i).matches(".10")) {
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

        return Collections.disjoint(busyCells, userCells);
    }



    private boolean isStraightLineCells (String[] shipCells) {


        if (shipCells.length > 1) {
            List<String> cells = new ArrayList<>();
            Collections.addAll(cells, allCells);
//        int head = cells.indexOf(shipCells[0].toUpperCase());
            int[] cellPositions = new int[shipCells.length];

            for (int i = 0; i < shipCells.length; i++) {
                cellPositions[i] = cells.indexOf(shipCells[i].toUpperCase());
            }

            int dCount = 0;
            int oCount = 0;
            for (int i=0; i<cellPositions.length; i++) {

                if (i != 0 && Math.abs(cellPositions[i] - cellPositions[i - 1]) == 1) {
                    oCount++;
                } else if (i != 0 && Math.abs(cellPositions[i] - cellPositions[i - 1]) == 10) {
                    dCount++;
                }
            }
            if (oCount != cellPositions.length-1 && dCount != cellPositions.length-1) {
                return false;
            }
        }
        return shipCells.length < 5;
    }




//            if (head == -1) {
////                    || (head < 99 && !shipCells[i].equalsIgnoreCase(cells.get(head + 1)))
////                    || (head < 90 && !shipCells[i].equalsIgnoreCase(cells.get(head + 10)))
////                    || (head > 0 && !shipCells[i].equalsIgnoreCase(cells.get(head - 1)))
////                    || (head > 9 && !shipCells[i].equalsIgnoreCase(cells.get(head - 10)))) {
//
//                cells.clear();
//                return false;
//            } else if (head == 99) {
//
//            }
//            head = i;
//        }
//        cells.clear();
//        return true;
    }

//    private boolean isCell (String userCell) {
//        String cellRegex = "^[AaBbCcDdEeFfGgHhYyJj]" + "([123456789]|10) $";
//        return userCell.matches(cellRegex);
//    }
//}
