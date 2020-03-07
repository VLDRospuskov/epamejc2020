package seabattle.java;

import java.util.ArrayList;

import static seabattle.java.Utils.*;


public class Engine {

    Field field1;
    Field field2;

    public Engine() {
        field1 = new Field();
        field2 = new Field();
        printTwoField(field1, field2);
    }

    public void startWithManualShipPlacement() {
//        manualShipPlacement(field1);
        testShipPlacement(field1);
        testShipPlacement(field2);
        printTwoField(field1, field2);
//        printField(field1);
//        printHiddenField(field1);
        battle(field1, field2);


    }
    public void testShipPlacement(Field field) {
        field.getShips().add(new Ship(1, new Integer[]{0,0}, new Integer[]{0,0}, field));
        field.getShips().add(new Ship(1, new Integer[]{9,0}, new Integer[]{9,0}, field));
        field.getShips().add(new Ship(1, new Integer[]{9,9}, new Integer[]{9,9}, field));
        field.getShips().add(new Ship(1, new Integer[]{0,9}, new Integer[]{0,9}, field));
        field.getShips().add(new Ship(2, new Integer[]{2,0}, new Integer[]{3,0}, field));
        field.getShips().add(new Ship(2, new Integer[]{6,0}, new Integer[]{7,0}, field));
        field.getShips().add(new Ship(2, new Integer[]{2,9}, new Integer[]{3,9}, field));
        field.getShips().add(new Ship(3, new Integer[]{1,2}, new Integer[]{3,2}, field));
        field.getShips().add(new Ship(3, new Integer[]{6,6}, new Integer[]{8,6}, field));
        field.getShips().add(new Ship(4, new Integer[]{3,4}, new Integer[]{6,4}, field));
    }

    public void manualShipPlacement(Field field) {
        ArrayList params;
        boolean isShipLimit = false;
        while (!isShipLimit) {
            params = scanShipParams(field);
            placeShip(field, params);
            isShipLimit  = checkShipsLimit(field);
            printField(field);
        }
    }

    public boolean checkShipsLimit(Field field) {
        final int SHIP_LIMIT = 20;
        int shipsChecksum = field.getShips().stream()
                .map(ship -> ship.getShipType())
                .reduce(0, (left, right) -> left + right);

        if (shipsChecksum == SHIP_LIMIT) {
            return true;
        }
        return false;

    }

    public Field placeShip(Field field, ArrayList params) {
        Integer shipType = (Integer) params.get(0);
        Integer[] startYX = (Integer[]) params.get(1);
        Integer[] endYX = (Integer[]) params.get(2);

        field.getShips().add(new Ship(shipType, startYX, endYX, field));
        boolean shipInitOk = field.getShips().get(field.getShips().size() - 1).isInitOk();
        if (!shipInitOk) {
            field.getShips().remove(field.getShips().size() - 1);
        }
        return field;
    }

    private void battle(Field field1, Field field2) {
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.println("\n Player 1 move.");
            printTwoField(field1, field2);
            playerMove(field2, field1);

            System.out.println("\n Player 2 move.");
            printTwoField(field2, field1);
            playerMove(field1, field2);

        }
    }

    private boolean checkEndGame(Field field) {
        return true;
    }

    private Field playerMove(Field field1, Field field2) {
        boolean isContinueMove = true;
        while (isContinueMove) {
            Integer[] coordYX = scanCoordinates();
            if (field1.getField().get(coordYX[0]).get(coordYX[1]).isHit()) {
                System.out.println("\nYou already shoot there! The move goes to another player.");
                return field1;
            }
            shoot(field1, coordYX);
            int cellStatus = field1.getField().get(coordYX[0]).get(coordYX[1]).getStatus();
            printTwoField(field2, field1);
            isContinueMove = false;
            if (cellStatus == 1) {
                isContinueMove = true;
                System.out.println("\nGot it! Shoot again!");
            }
        }

        return field1;
    }

    private Field shoot(Field field, Integer[] coordYX) {
        field.getField().get(coordYX[0]).get(coordYX[1]).setHit(true);
        return field;
    }

}
