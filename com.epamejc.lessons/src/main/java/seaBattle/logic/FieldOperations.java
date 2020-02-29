package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.Configuration;
import seaBattle.data.Ship;
import seaBattle.data.enums.CellStatus;
import seaBattle.data.enums.Directions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FieldOperations {

    private List<Cell> field = new ArrayList<>();

    public void generateField() {
        int cellIndex = 0;
        for (int i = 1; i <= Configuration.getFieldSize(); i++) {
            for (int j = 1; j <= Configuration.getFieldSize(); j++) {
                field.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
    }

    public List<Cell> getField() {
        return field;
    }

    public Cell getCellByCoords(int xCoord, int yCoord) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == xCoord
                        && cell.getyCoord() == yCoord)
                .findAny()
                .orElse(null);
    }

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

    private List<Cell> getTopDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() <= ship.getShipCoordY() &&
                        cell.getyCoord() >= ship.getShipCoordY() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getRightDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() >= ship.getShipCoordX() &&
                        cell.getxCoord() <= ship.getShipCoordX() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getBottomDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() >= ship.getShipCoordY() &&
                        cell.getyCoord() <= ship.getShipCoordY() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getLeftDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() <= ship.getShipCoordX() &&
                        cell.getxCoord() >= ship.getShipCoordX() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }

    public int getPotentialDirectionsNumber(Ship ship, Cell cell) {
        int count = 0;
        if (!doesHaveShip(getTopDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            if (getTopDirectionCells(ship).size() == ship.getShipDecks()) {
                count++;
            }
        }
        if (!doesHaveShip(getRightDirectionRadius(cell.getxCoord(), cell.getyCoord(), ship.getShipDecks()))) {
            int test = getRightDirectionCells(ship).size();
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

    private boolean doesHaveShip(List<Cell> cellList) {
        long cruiserCount = cellList.stream().filter(ship -> ship.getCellShip() != null).count();
        for(Cell cell : cellList) {
            if (cell.getCellShip() != null) {
                return true;
            }
        }
        return false;
    }
}
