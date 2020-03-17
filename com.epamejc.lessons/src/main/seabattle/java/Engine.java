package seabattle.java;

import java.util.ArrayList;

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

    public void startPvPWithManualShipPlacement() {
        System.out.println("\nPlayer 1 start placement ships...");
        manualShipPlacement(FIELD_1);
        System.out.println("\nPlayer 1 successfully set ships.");
        System.out.println("\nPlayer 2 start placement ships...");
        manualShipPlacement(FIELD_2);
        System.out.println("\nPlayer 2 successfully set ships.");
        battlePlayerVsPlayer();
    }

    public void startPvPWithAutoShipPlacement() {
        autoShipPlacement(FIELD_1);
        System.out.println("\nPlayer 1 successfully set ships.");
        autoShipPlacement(FIELD_2);
        System.out.println("\nPlayer 2 successfully set ships.");
        battlePlayerVsPlayer();
    }

    public void startPvCWithManualShipPlacement() {
        System.out.println("\nPlayer start placement ships...");
        manualShipPlacement(FIELD_1);
        System.out.println("\nPlayer successfully set ships.");
        autoShipPlacement(FIELD_2);
        System.out.println("\nComputer successfully set ships.");
        battlePlayerVsComputer();
    }

    public void startPvCWithAutoShipPlacement() {
        autoShipPlacement(FIELD_1);
        System.out.println("\nPlayer successfully set ships.");
        autoShipPlacement(FIELD_2);
        System.out.println("\nComputer successfully set ships.");
        battlePlayerVsComputer();
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
        field.getShips().add(new Ship(3, new Integer[]{7, 5}, new Integer[]{7, 7}, field));
        field.getShips().add(new Ship(4, new Integer[]{2, 4}, new Integer[]{2, 7}, field));
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

    private void battlePlayerVsComputer() {
        boolean isGameOver = false;
        while (!isGameOver) {
            playerMovePvC();
            isGameOver = checkEndGame();
            if (!isGameOver) {
                computerMovePvC();
                isGameOver = checkEndGame();
            }
        }
        System.out.println("Game over! " + getWinnerPvC());
    }

    private void battlePlayerVsPlayer() {
        boolean isGameOver = false;
        while (!isGameOver) {
            playerOneMovePvP();
            isGameOver = checkEndGame();

            if (!isGameOver) {
                playerTwoMovePvP();
                isGameOver = checkEndGame();
            }
        }
        System.out.println("Game over! " + getWinnerPvP());
    }

    private void playerOneMovePvP() {
        printTwoFields(FIELD_1, FIELD_2);
        System.out.println("\nPlayer 1 move...");
        playerMove(FIELD_2, FIELD_1);
    }

    private void playerTwoMovePvP() {
        printTwoFields(FIELD_2, FIELD_1);
        System.out.println("\nPlayer 2 move...");
        playerMove(FIELD_1, FIELD_2);
    }

    private void playerMovePvC() {
        printTwoFields(FIELD_1, FIELD_2);
        System.out.println("\nPlayer move...");
        playerMove(FIELD_2, FIELD_1);
    }

    private void computerMovePvC() {
        System.out.println("\nComputer move...");
        computerMove(FIELD_1, FIELD_2);
    }

    // TODO разбить метод
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

    private Field computerMove(Field field1, Field field2) {
        if (AI.getShootData() != null && !AI.getShootData().isDone()) {
            continueShooting(field1, field2, AI.getShootData().getSTART_YX());
        } else {
            startShooting(field1, field2);
        }
        if (!checkEndGame()) {
            System.out.println("\nMissed! The move goes to another player...\n");
            if (AI.getShootData().isDone()) {
                AI.setShootData(null);
            }
        }
        return field1;
    }

    private void startShooting(Field field1, Field field2) {
        Integer[] coordYX = randomShooting(field1);
        System.out.println("\nComputer shoot " + printCoord(coordYX));
        if (AI.getShootData() == null || AI.getShootData().isDone()) {
            AI.setShootData(new ShootData(field1, coordYX));
        }
        if (!checkIsCellAShip(field1, coordYX)) {
            AI.getShootData().setDone(true);
        }
        printTwoFields(field2, field1);
        continueShooting(field1, field2, coordYX);
    }

    private void continueShooting(Field field1, Field field2, Integer[] coordYX) {
        boolean isContinueMove;
        do {
            isContinueMove = false;
            if (checkIsCellAShip(field1, coordYX) && !checkEndGame()) {
                AI.finishingShooting(field1);
                printTwoFields(field2, field1);
                coordYX = AI.getShootData().getLastYX();
                isContinueMove = checkIsCellAShip(field1, coordYX) && !checkEndGame() && !AI.getShootData().isDone();
            }
        } while (isContinueMove && !checkEndGame());
    }

    private Integer[] randomShooting(Field field) {
        Integer[] coordYX = AI.generateRandomCoordinate(field);
        shoot(field, coordYX);
        return coordYX;
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

    private String getWinnerPvP() {
        if (countSunkShips(FIELD_1) > countSunkShips(FIELD_2)) {
            return "Player " + FIELD_2.getId() + " win!";
        }
        return "Player " + FIELD_1.getId() + " win!";
    }

    private String getWinnerPvC() {
        if (countSunkShips(FIELD_1) > countSunkShips(FIELD_2)) {
            return "Computer win!";
        }
        return "Player win!";
    }


}
