package seabattle.java;

import java.util.ArrayList;
import java.util.Random;

import static seabattle.java.Utils.*;


public class Engine {

    final Field FIELD_1;
    final Field FIELD_2;
    final AI AI;

    public Engine() {
        FIELD_1 = new Field(1);
        FIELD_2 = new Field(2);
        AI = new AI();
    }

    public void startWithManualShipPlacement() {
//        manualShipPlacement(field1);
        autoShipPlacement(FIELD_1);
        autoShipPlacement(FIELD_2);
//        testShipPlacement(field1);
//        testShipPlacement(field2);
//        printTwoFields(field1, field2);
        printField(FIELD_1);
        printField(FIELD_2);
//        printHiddenField(field1);
        battle();


    }

    public void testShipPlacement(Field field) {
        field.getShips().add(new Ship(1, new Integer[]{0, 0}, new Integer[]{0, 0}, field));
        field.getShips().add(new Ship(1, new Integer[]{9, 0}, new Integer[]{9, 0}, field));
        field.getShips().add(new Ship(1, new Integer[]{9, 9}, new Integer[]{9, 9}, field));
        field.getShips().add(new Ship(1, new Integer[]{0, 9}, new Integer[]{0, 9}, field));
        field.getShips().add(new Ship(2, new Integer[]{2, 0}, new Integer[]{3, 0}, field));
        field.getShips().add(new Ship(2, new Integer[]{6, 0}, new Integer[]{7, 0}, field));
        field.getShips().add(new Ship(2, new Integer[]{2, 9}, new Integer[]{3, 9}, field));
        field.getShips().add(new Ship(3, new Integer[]{1, 2}, new Integer[]{3, 2}, field));
        field.getShips().add(new Ship(3, new Integer[]{6, 6}, new Integer[]{8, 6}, field));
        field.getShips().add(new Ship(4, new Integer[]{3, 4}, new Integer[]{6, 4}, field));
    }

    public void manualShipPlacement(Field field) {
        ArrayList params;
        boolean isShipLimit = false;
        while (!isShipLimit) {
            params = scanShipParams(field);
            placeShip(field, params, false);
            isShipLimit = checkAllShipsLimit(field);
            printField(field);
        }
    }

    public void autoShipPlacement(Field field) {
        for (int i = 1; i <= 4; i++) {
            ArrayList params;
            int shipType = i;
            boolean isShipLimit = false;
            while (!isShipLimit) {
                params = AI.generateRandomShipParamsByShipType(shipType);
                placeShip(field, params, true);
                isShipLimit = checkCertainShipsLimit(field, shipType);
            }
        }
    }



    public boolean checkAllShipsLimit(Field field) {
        final int SHIP_LIMIT = 20;
        int shipsChecksum = field.getShips().stream()
                .map(ship -> ship.getShipType())
                .reduce(0, (left, right) -> left + right);
        if (shipsChecksum == SHIP_LIMIT) {
            return true;
        }
        return false;
    }

    public boolean checkCertainShipsLimit(Field field, int shipType) {
        final int SHIP_LIMIT = getMaxCountOfShipByType(shipType);
        int shipsCount = (int) field.getShips().stream()
                .filter(ship -> ship.getShipType() == shipType)
                .count();
        return shipsCount == SHIP_LIMIT;
    }

    public Field placeShip(Field field, ArrayList params, boolean isSilient) {
        Integer shipType = (Integer) params.get(0);
        Integer[] startYX = (Integer[]) params.get(1);
        Integer[] endYX = (Integer[]) params.get(2);

        field.getShips().add(new Ship(shipType, startYX, endYX, field));
        int lastElement = field.getShips().size() - 1;
        boolean shipInitOk = field.getShips().get(lastElement).isInitOk();
        if (!shipInitOk) {
            if (!isSilient) {
                field.getShips().get(lastElement).printBadCoordinates();
            }
            field.getShips().remove(lastElement);
        }
        return field;
    }

    private void battle() {
        boolean isGameOver = false;
        while (!isGameOver) {
            playerOneManualMove();
            isGameOver = checkEndGame();

            if (!isGameOver) {
                playerTwoAutoMove();
                isGameOver = checkEndGame();
            }
        }
        System.out.println("Game over! Player " + getWinner() + " WIN!");
    }

    private void playerOneManualMove() {
        printTwoFields(FIELD_1, FIELD_2);
        System.out.println("\nPlayer 1 shoot.");
        playerMove(FIELD_2, FIELD_1);
    }

    private void playerTwoManualMove() {
        printTwoFields(FIELD_2, FIELD_1);
        System.out.println("\nPlayer 2 shoot.");
        playerMove(FIELD_1, FIELD_2);
    }

    private void playerTwoAutoMove() {
        printTwoFields(FIELD_2, FIELD_1);
        System.out.println("\nComputer shoot.");
        autoMove(FIELD_1, FIELD_2);
    }

    private Field playerMove(Field field1, Field field2) {
        boolean isContinueMove = true;
        while (isContinueMove && !checkEndGame()) {
            Integer[] coordYX = scanCoordinates();
            if (field1.getField().get(coordYX[0]).get(coordYX[1]).isHit()) {
                System.out.println("\nYou already shoot there! The move goes to another player.");
                return field1;
            }
            shoot(field1, coordYX);
            printTwoFields(field2, field1);
            isContinueMove = false;
            if (field1.getField().get(coordYX[0]).get(coordYX[1]).getStatus() == 1 && !checkEndGame()) {
                isContinueMove = true;
                System.out.println("\nGot it! Shoot again!");
            }
        }
        if (!checkEndGame()) {
            System.out.println("\nMissed! The move goes to another player...\n");
        }
        return field1;
    }

    private Field autoMove(Field field1, Field field2) {
        boolean isContinueShooting;
            do {
                isContinueShooting = false;
                Integer[] coordYX = randomShoting(field1);
                printTwoFields(field2, field1);
                if (field1.getField().get(coordYX[0]).get(coordYX[1]).getStatus() == 1 && !checkEndGame()) {
                    isContinueShooting = true;
                    System.out.println("\nGot it! Shoot again!");
                }
            } while (isContinueShooting && !checkEndGame());
        if (!checkEndGame()) {
            System.out.println("\nMissed! The move goes to another player...\n");
        }
        return field1;
    }

    private Integer[] randomShoting(Field field) {
        Integer[] coordYX = AI.generateRandomCoordinate(field);
        shoot(field, coordYX);
        return coordYX;
    }

    private void finishingShoting() {

    }



    protected boolean checkEndGame() {
        int sunkShipsCountOnField1 = countSunkShips(FIELD_1);
        int allShipsCountOnField1 = FIELD_1.getShips().size();
        int sunkShipsCountOnField2 = countSunkShips(FIELD_2);
        int allShipsCountOnField2 = FIELD_2.getShips().size();
        return sunkShipsCountOnField1 == allShipsCountOnField1 || sunkShipsCountOnField2 == allShipsCountOnField2;
    }

    private int countSunkShips(Field field) {
        field.getShips().stream()
                .forEach(ship -> ship.checkSunk(field));
        int sunkShipsCount = (int) field.getShips().stream()
                .filter(ship -> ship.isSunk())
                .count();
        return sunkShipsCount;
    }

    private int getWinner() {
        if (countSunkShips(FIELD_1) > countSunkShips(FIELD_2)) {
            return FIELD_2.getId();
        }
        return FIELD_2.getId();
    }

    protected Field shoot(Field field, Integer[] coordYX) {
        field.getField().get(coordYX[0]).get(coordYX[1]).setHit(true);
        return field;
    }


}
