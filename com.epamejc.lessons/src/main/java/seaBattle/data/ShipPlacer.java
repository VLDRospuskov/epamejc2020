package seaBattle.data;

import seaBattle.data.enums.CellStatus;
import seaBattle.utils.RandomNumberGenerator;

import java.util.List;

public class ShipPlacer {

    private Field field;

    public ShipPlacer(Field fieldObject) {
        this.field = fieldObject;
    }

    public void placeShipsAutomatically(List<Ship> ships) {
        for (Ship ship : ships) {
            placeShip(ship);
        }
    }

    private void placeShip(Ship ship) {
        boolean isShipPlaced = false;
        while (!isShipPlaced) {

            int randomCoordX = RandomNumberGenerator.generateRandomInRange(10);
            int randomCoordY = RandomNumberGenerator.generateRandomInRange(10);
            String randomDirection = RandomNumberGenerator.generateRandomDirection();
//            int randomCoordX = 1;
//            int randomCoordY = 1;
//            String randomDirection = "right";

            //Проверяем, есть ли такая ячейка, есть на ней корабль
            Cell selectedCell = field.getCellByCoords(randomCoordX, randomCoordY);
            if (selectedCell != null && selectedCell.getCellStatus().equals(CellStatus.HIDDEN.getStatus())) {
                //Проверяем, помещается ли корабль в поле с таким направлением
                boolean isInsideBorders = checkBorder(randomDirection, randomCoordX, randomCoordY, ship.getShipDecks());
                if (isInsideBorders) {
                    //Проверяем радиус вокруг корабля. Забираем все ячейки, если хоть где-то есть корабль - то false
                    boolean isRadiusFree = checkRadius(randomDirection, randomCoordX, randomCoordY, ship.getShipDecks());
                    if (isRadiusFree) {
                        isShipPlaced = true; //Можно размещать корабль
                        initializeShip(ship, randomDirection, randomCoordX, randomCoordY);
                    }
                }
            }
        }
    }

    private boolean checkBorder(String direction, int xCoord, int yCoord, int shipDecks) {
        Cell checkCell;
        if (direction.equals("up")) {
            checkCell = field.getCellByCoords(xCoord, yCoord - shipDecks + 1);
        } else if (direction.equals("right")) {
            checkCell = field.getCellByCoords(xCoord + shipDecks - 1, yCoord);
        } else if (direction.equals("down")) {
            checkCell = field.getCellByCoords(xCoord, yCoord + shipDecks - 1);
        } else {
            checkCell = field.getCellByCoords(xCoord - shipDecks + 1, yCoord);
        }

        return checkCell != null;
    }

    private boolean checkRadius(String direction, int xCoord, int yCoord, int shipDecks) {
        if (direction.equals("up")) {
            List<Cell> radiusCellsList = field.getTopDirectionRadius(xCoord, yCoord, shipDecks);
            return isRadiusCorrect(radiusCellsList);
        } else if (direction.equals("right")) {
            List<Cell> radiusCellsList = field.getRightDirectionRadius(xCoord, yCoord, shipDecks);
            return isRadiusCorrect(radiusCellsList);
        } else if (direction.equals("down")) {
            List<Cell> radiusCellsList = field.getBottomDirectionRadius(xCoord, yCoord, shipDecks);
            return isRadiusCorrect(radiusCellsList);
        } else {
            List<Cell> radiusCellsList = field.getLeftDirectionRadius(xCoord, yCoord, shipDecks);
            return isRadiusCorrect(radiusCellsList);
        }
    }

    private boolean isRadiusCorrect(List<Cell> cellsInRadius) {
        for (Cell cell : cellsInRadius) {
            if (cell.isShipInCell()) {
                return false;
            }
        }
        return true;
    }

    private void initializeShip(Ship ship, String randomDirection, int randomCoordX, int randomCoordY) {
        ship.setDirection(randomDirection);
        ship.setShipCoordX(randomCoordX);
        ship.setShipCoordY(randomCoordY);
        List<Cell> shipCells = field.getShipCells(ship);
        for (Cell cell : shipCells) {
            cell.setCellShip(ship);
        }
    }
}
