package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Configuration;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.CellStatus;
import homeworks.seaBattle.data.enums.Directions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FieldOperations {

    private List<Cell> field = new ArrayList<>();

    /**
     * Method generates new field with {@link Configuration#getFieldSize()} size
     */
    public void generateField() {
        int cellIndex = 0;
        for (int i = 1; i <= Configuration.getFieldSize(); i++) {
            for (int j = 1; j <= Configuration.getFieldSize(); j++) {
                field.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
    }

    /**
     * Method returns field object
     * @return field
     */
    public List<Cell> getField() {
        return field;
    }

    /**
     * Method returns {@link Cell} object with specified coordinates {@paramref xCoord} and {@paramref yCoord}
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @return {@link Cell} object
     */
    public Cell getCellByCoords(int xCoord, int yCoord) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == xCoord
                        && cell.getyCoord() == yCoord)
                .findAny()
                .orElse(null);
    }

    /**
     * Method returns {@link Cell} object with coordinates {@paramref xCoord} and {@paramref yCoord} in specified
     * direction {@paramref direction} at a distance of a step {@paramref step}
     * @param direction direction of step
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param step distance
     * @return {@link Cell} object
     */
    public Cell getCellByDirection(String direction, int xCoord, int yCoord, int step) {
        Cell cell;
        if (direction.equals(Directions.UP.getDirection())) {
            cell = getCellByCoords(xCoord, yCoord - step + 1);
        } else if (direction.equals(Directions.RIGHT.getDirection())) {
            cell = getCellByCoords(xCoord + step - 1, yCoord);
        } else if (direction.equals(Directions.DOWN.getDirection())) {
            cell = getCellByCoords(xCoord, yCoord + step - 1);
        } else {
            cell = getCellByCoords(xCoord - step + 1, yCoord);
        }

        return cell;
    }

    /**
     * Method returns {@link List} of {@link Cell} objects inside {@link Ship}
     * @param ship {@link Ship} object
     * @return {@link List} of cells inside ship
     */
    public List<Cell> getShipCells(Ship ship) {
        if (ship.getDirection().equals(Directions.UP.getDirection())) {
            return getTopDirectionCells(ship);
        } else if (ship.getDirection().equals(Directions.RIGHT.getDirection())) {
            return getRightDirectionCells(ship);
        } else if (ship.getDirection().equals(Directions.DOWN.getDirection())) {
            return getBottomDirectionCells(ship);
        } else {
            return getLeftDirectionCells(ship);
        }
    }

    /**
     * Method returns {@link List} of {@link Cell} cells inside and around the ship {@link Ship}
     * @param ship {@link Ship} object
     * @return {@link List} of cells inside and around ship
     */
    public List<Cell> getShipAndRadiusCells(Ship ship) {
        if (ship.getDirection().equals(Directions.UP.getDirection())) {
            return getTopDirectionRadius(ship.getShipCoordX(), ship.getShipCoordY(), ship.getShipDecks());
        } else if (ship.getDirection().equals(Directions.RIGHT.getDirection())) {
            return getRightDirectionRadius(ship.getShipCoordX(), ship.getShipCoordY(), ship.getShipDecks());
        } else if (ship.getDirection().equals(Directions.DOWN.getDirection())) {
            return getBottomDirectionRadius(ship.getShipCoordX(), ship.getShipCoordY(), ship.getShipDecks());
        } else {
            return getLeftDirectionRadius(ship.getShipCoordX(), ship.getShipCoordY(), ship.getShipDecks());
        }
    }

    /**
     * Method checks the field border in a given direction {@paramref direction} and distance {@paramref step}
     * @param direction direction of border check
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param step distance of border check
     * @return boolean is inside field border
     */
    public boolean checkFieldBorder(String direction, int xCoord, int yCoord, int step) {
        Cell checkCell;
        if (direction.equals(Directions.UP.getDirection())) {
            checkCell = getCellByCoords(xCoord, yCoord - step + 1);
        } else if (direction.equals(Directions.RIGHT.getDirection())) {
            checkCell = getCellByCoords(xCoord + step - 1, yCoord);
        } else if (direction.equals(Directions.DOWN.getDirection())) {
            checkCell = getCellByCoords(xCoord, yCoord + step - 1);
        } else {
            checkCell = getCellByCoords(xCoord - step + 1, yCoord);
        }

        return checkCell != null;
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside a radius in a top-direction
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param shipDecks distance of radius in a top-direction
     * @return {@link List} of cells inside and around ship
     */
    public List<Cell> getTopDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - shipDecks; y <= yCoord + 1; y++) {
            for (int x = xCoord - 1; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside a radius in a right-direction
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param shipDecks distance of radius in a top-direction
     * @return {@link List} of cells inside and around ship
     */
    public List<Cell> getRightDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + 1; y++) {
            for (int x = xCoord - 1; x <= xCoord + shipDecks; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside a radius in a bottom-direction
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param shipDecks distance of radius in a top-direction
     * @return {@link List} of cells inside and around ship
     */
    public List<Cell> getBottomDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + shipDecks; y++) {
            for (int x = xCoord - 1; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside a radius in a left-direction
     * @param xCoord horizontal coordinate value
     * @param yCoord vertical coordinate value
     * @param shipDecks distance of radius in a top-direction
     * @return {@link List} of cells inside and around ship
     */
    public List<Cell> getLeftDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + 1; y++) {
            for (int x = xCoord - shipDecks; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside ship {@paramref ship} in top-direction
     * @param ship ship with location attributes
     * @return {@link List} of cells inside ship
     */
    private List<Cell> getTopDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() <= ship.getShipCoordY() &&
                        cell.getyCoord() >= ship.getShipCoordY() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside ship {@paramref ship} in right-direction
     * @param ship ship with location attributes
     * @return {@link List} of cells inside ship
     */
    private List<Cell> getRightDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() >= ship.getShipCoordX() &&
                        cell.getxCoord() <= ship.getShipCoordX() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside ship in bottom-direction
     * @param ship ship with location attributes
     * @return {@link List} of cells inside ship
     */
    private List<Cell> getBottomDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() >= ship.getShipCoordY() &&
                        cell.getyCoord() <= ship.getShipCoordY() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    /**
     * Method returns {@link List} of {@link Cell} cells located inside ship in left-direction
     * @param ship ship with location attributes
     * @return {@link List} of cells inside ship
     */
    private List<Cell> getLeftDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() <= ship.getShipCoordX() &&
                        cell.getxCoord() >= ship.getShipCoordX() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }

    /**
     * Method returns the number of potential options for placement ship
     * around selected cell {@paramref cell}
     * @param ship {@link Ship} object
     * @param cell {@link Cell} cell with coordinates
     * @return number of options
     */
    public int getPotentialDirectionsNumber(Ship ship, Cell cell) {
        int count = 0;
        if (!doesHaveShip(getTopDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            if (getTopDirectionCells(ship).size() == ship.getShipDecks()) {
                count++;
            }
        }
        if (!doesHaveShip(getRightDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            if (getRightDirectionCells(ship).size() == ship.getShipDecks()) {
                count++;
            }
        }
        if (!doesHaveShip(getBottomDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            if (getBottomDirectionCells(ship).size() == ship.getShipDecks()) {
                count++;
            }
        }
        if (!doesHaveShip(getLeftDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            if (getLeftDirectionCells(ship).size() == ship.getShipDecks()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method checks is the ship in the selected list of cells
     * @param cellList {@link List} of {@link Cell} cells
     * @return true if cellList has ships
     */
    private boolean doesHaveShip(List<Cell> cellList) {
        for(Cell cell : cellList) {
            if (cell.getCellShip() != null) {
                return true;
            }
        }
        return false;
    }
}
