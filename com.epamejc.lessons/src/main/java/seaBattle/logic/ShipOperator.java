package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.Ship;
import seaBattle.data.ShipType;
import seaBattle.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShipOperator {

    private List<Ship> playerShips = new ArrayList<>();
    private List<Ship> botShips = new ArrayList<>();
    private int lincorNumber;
    private int cruiserNumber;
    private int destroyerNumber;
    private int boatNumber;

    public ShipOperator(int lincorNumber, int cruiserNumber, int destroyerNumber, int boatNumber) {
        this.lincorNumber = lincorNumber;
        this.cruiserNumber = cruiserNumber;
        this.destroyerNumber = destroyerNumber;
        this.boatNumber = boatNumber;
    }

    public void generateShips() {
        for (int i = 0; i < lincorNumber; i++) {
            playerShips.add(new Ship(ShipType.LINCOR.getType(), 4));
            botShips.add(new Ship(ShipType.LINCOR.getType(), 4));
        }
        for (int j = 0; j < cruiserNumber; j++) {
            playerShips.add(new Ship(ShipType.CRUISER.getType(), 3));
            botShips.add(new Ship(ShipType.CRUISER.getType(), 3));
        }
        for (int k = 0; k < destroyerNumber; k++) {
            playerShips.add(new Ship(ShipType.DESTROYER.getType(), 2));
            botShips.add(new Ship(ShipType.DESTROYER.getType(), 2));
        }
        for (int l = 0; l < boatNumber; l++) {
            playerShips.add(new Ship(ShipType.BOAT.getType(), 1));
            botShips.add(new Ship(ShipType.BOAT.getType(), 1));
        }
        playerShips.sort(Comparator.comparingInt(Ship::getShipDecks).reversed());
        botShips.sort(Comparator.comparingInt(Ship::getShipDecks).reversed());
    }

    public void placeShipsAutomatically(FieldOperator fieldOperator) {
        List<Cell> playerField = fieldOperator.getPlayerField();
        for (Ship s : playerShips) {
            setShip(s, playerField, fieldOperator);
        }
    }

    private void setShip(Ship ship, List<Cell> field, FieldOperator fieldOperator) {
        int randomCoordX = RandomNumberGenerator.generateRandomInRange(10);
        int randomCoordY = RandomNumberGenerator.generateRandomInRange(10);
        int randomDirection = RandomNumberGenerator.generateRandomInRange(4);
        String direction = randomDirection == 0 ? "up" : randomDirection == 1
                ? "right" : randomDirection == 2 ? "down" : "left";
        Cell startingCell = null;
        //Ищем свободную ячейку
        while (startingCell == null) {
            startingCell = fieldOperator.getFreeCell(randomCoordX, randomCoordY, field);
        }

        boolean isCheckedPositioning = false;
        while (!isCheckedPositioning) {
            boolean isFreeCell = false; //здесь проверить, есть ли корабль на этой позиции
            boolean isInsideBorders = fieldOperator.checkBorder(randomCoordX, randomCoordY, field, direction, ship.getShipDecks());
            if (isInsideBorders) {
                //здесь мы знаем, что данный корабль с этим направлением поместится в границах
                //надо проверить клетки вокруг.
                boolean isCorrectRadius;
                fieldOperator.getCellsInRadius(randomCoordX, randomCoordY, direction, field, ship.getShipDecks());
            }
        }
        int a = 10;
        //проверить координаты - помещается ли корабль
    }
}
