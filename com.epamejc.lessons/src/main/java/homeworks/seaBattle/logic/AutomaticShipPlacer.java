package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.CellStatus;
import homeworks.seaBattle.utils.RandomNumberGenerator;

import java.util.List;

public class AutomaticShipPlacer {

    private FieldOperations fieldOperations;

    public AutomaticShipPlacer(FieldOperations fieldOperationsObject) {
        this.fieldOperations = fieldOperationsObject;
    }

    public void placeShips(List<Ship> ships) {
        for (Ship ship : ships) {
            placeShip(ship);
        }
    }

    /**
     * Method for placing one ship {@link Ship}
     *
     * @param ship ship to be placed
     */
    public void placeShip(Ship ship) {
        boolean isShipPlaced = false;
        while (!isShipPlaced) {

            int randomCoordX = RandomNumberGenerator.generateRandomInRange(10);
            int randomCoordY = RandomNumberGenerator.generateRandomInRange(10);
            String randomDirection = RandomNumberGenerator.generateRandomDirection();
            Cell selectedCell = fieldOperations.getCellByCoords(randomCoordX, randomCoordY);
            if (selectedCell != null && selectedCell.getCellStatus().equals(CellStatus.HIDDEN.getStatus())) {
                boolean isInsideBorders = fieldOperations.checkFieldBorder(randomDirection, randomCoordX,
                        randomCoordY, ship.getShipDecks());
                if (isInsideBorders) {
                    boolean isRadiusFree = checkRadius(randomDirection, randomCoordX, randomCoordY, ship.getShipDecks());
                    if (isRadiusFree) {
                        isShipPlaced = true;
                        initializeShip(ship, randomDirection, randomCoordX, randomCoordY);
                    }
                }
            }
        }
    }

    /**
     * Method checks the radius around the selected cell at a distance {@param shipDecks}
     *
     * @param direction direction of potential {@link Ship} placement
     * @param xCoord    horizontal coordinate
     * @param yCoord    vertical coordinate
     * @param shipDecks distance of potential {@link Ship} placement
     * @return true or false, if we can/can't place ship on selected attributes
     */
    public boolean checkRadius(String direction, int xCoord, int yCoord, int shipDecks) {
        switch (direction) {
            case "up": {
                List<Cell> radiusCellsList = fieldOperations.getTopDirectionRadius(xCoord, yCoord, shipDecks);
                return isRadiusCorrect(radiusCellsList);
            }
            case "right": {
                List<Cell> radiusCellsList = fieldOperations.getRightDirectionRadius(xCoord, yCoord, shipDecks);
                return isRadiusCorrect(radiusCellsList);
            }
            case "down": {
                List<Cell> radiusCellsList = fieldOperations.getBottomDirectionRadius(xCoord, yCoord, shipDecks);
                return isRadiusCorrect(radiusCellsList);
            }
            default: {
                List<Cell> radiusCellsList = fieldOperations.getLeftDirectionRadius(xCoord, yCoord, shipDecks);
                return isRadiusCorrect(radiusCellsList);
            }
        }
    }

    /**
     * Method checks if there are ship cells in the list of cells
     *
     * @param cellsInRadius list of selected cells {@link Cell}
     * @return true or false, if there aren't/are another ships cells
     */
    private boolean isRadiusCorrect(List<Cell> cellsInRadius) {
        for (Cell cell : cellsInRadius) {
            if (cell.isShipInCell()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method for initializing {@link Ship} attributes
     *
     * @param ship            ship object to be initialized
     * @param randomDirection generated direction of ship placement
     * @param randomCoordX    horizontal coordinate
     * @param randomCoordY    vertical coordinate
     */
    private void initializeShip(Ship ship, String randomDirection, int randomCoordX, int randomCoordY) {
        ship.setDirection(randomDirection);
        ship.setShipCoordX(randomCoordX);
        ship.setShipCoordY(randomCoordY);
        List<Cell> shipCells = fieldOperations.getShipCells(ship);
        for (Cell cell : shipCells) {
            cell.setCellShip(ship);
        }
    }
}
