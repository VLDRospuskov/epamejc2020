package seabattle.field;

import lombok.Data;
import seabattle.enums.Direction;
import seabattle.enums.FieldCellState;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cell {
    Cell leftCell;
    Cell rightCell;
    Cell upCell;
    Cell downCell;


    private char cellSymbol = '-';
    private FieldCellState fieldCellState = FieldCellState.EMPTY_CELL;

    public boolean isLegalToStartShipHere(Direction direction, int lenght) {
        if (!isShipInSurroundings()) {
            if (lenght == 1) {
                return true;
            } else if (getNextCellByDirection(direction) != null) {
                return getNextCellByDirection(direction).isLegalToStartShipHere(direction, lenght - 1);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void surroundWithMissesTillEndOfShip(Direction direction) {
        List<Cell> cellSurroundings = getCellSurroundings();
        for (Cell cell : cellSurroundings) {
            if (cell.isCellOfState(FieldCellState.EMPTY_CELL)) {
                cell.applyMiss();
            }
        }
        Cell nextCell = getNextCellByDirection(direction);
        if (nextCell != null && nextCell.isCellOfState(FieldCellState.SHIP_CELL_DEAD)) {
            nextCell.surroundWithMissesTillEndOfShip(direction);
        }
    }

    public boolean isPartOfDeadShip() {
        return isPartOfDeadCellsSequence(Direction.UP)
                && isPartOfDeadCellsSequence(Direction.DOWN)
                && isPartOfDeadCellsSequence(Direction.LEFT)
                && isPartOfDeadCellsSequence(Direction.RIGHT);
    }

    private boolean isPartOfDeadCellsSequence(Direction direction) {
        Cell nextCell = getNextCellByDirection(direction);
        if (nextCell != null) {
            if (nextCell.isCellOfState(FieldCellState.SHIP_CELL_DEAD)) {
                return nextCell.isPartOfDeadCellsSequence(direction);
            }
            if (nextCell.isCellOfState(FieldCellState.SHIP_CELL_ALIVE)) {
                return false;
            }
        }
        return true;
    }

    private boolean isShipInSurroundings() {
        List<Cell> surroundingCells = getCellSurroundings();
        boolean shipFound = false;
        for (Cell cell : surroundingCells) {
            shipFound = shipFound || cell.fieldCellState == FieldCellState.SHIP_CELL_ALIVE;
        }
        return shipFound;
    }

    private List<Cell> getCellSurroundings() {
        List<Cell> surroundingCells = new ArrayList<>();
        surroundingCells.add(this);
        if (upCell != null) {
            surroundingCells.add(upCell);
            if (upCell.leftCell != null) {
                surroundingCells.add(upCell.leftCell);
            }
        }
        if (leftCell != null) {
            surroundingCells.add(leftCell);
            if (leftCell.downCell != null) {
                surroundingCells.add(leftCell.downCell);
            }
        }
        if (downCell != null) {
            surroundingCells.add(downCell);
            if (downCell.rightCell != null) {
                surroundingCells.add(downCell.rightCell);
            }
        }
        if (rightCell != null) {
            surroundingCells.add(rightCell);
            if (rightCell.upCell != null) {
                surroundingCells.add(rightCell.upCell);
            }
        }
        return surroundingCells;
    }

    public boolean isCellOfState(FieldCellState fieldCellState) {
        return this.fieldCellState == fieldCellState;
    }

    public Cell getNextCellByDirection(Direction direction) {
        switch (direction) {
            case RIGHT:
                return rightCell;
            case LEFT:
                return leftCell;
            case DOWN:
                return downCell;
            case UP:
                return upCell;
            default:
                return null;
        }
    }

    public void applyHit() {
        setCellSymbol('X');
        setFieldCellState(FieldCellState.SHIP_CELL_DEAD);
    }

    public void applyMiss() {
        setCellSymbol('+');
        setFieldCellState(FieldCellState.EMPTY_CELL_STRICKEN);
    }

    public void placeShip() {
        setCellSymbol('O');
        setFieldCellState(FieldCellState.SHIP_CELL_ALIVE);
    }

}
