package seabattle;

import lombok.Data;
import seabattle.Enums.Direction;
import seabattle.Enums.FieldCellState;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cell {
    Cell leftCell;
    Cell rightCell;
    Cell upCell;
    Cell downCell;


    private char cellSymbol = '-';//183;//'_';
    private FieldCellState fieldCellState = FieldCellState.EMPTY_CELL;
    //private boolean availableForShipDeck = true;

    //private ShipCellState shipCellState;

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
//            if (cell.isCellOfState(FieldCellState.SHIP_CELL_DEAD)){
//                cell.getNextCellByDirection(direction).surroundWithMissesTillEndOfShip(direction);
//            }
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

    public boolean isAvailableForShipDeck() {
        return true; //availableForShipDeck;
    }

//    public boolean isShipInSurroundings() {
//        boolean isShipFound = false;
//        if (leftCell!=null) {
//            isShipFound = leftCell.isCellOfState(FieldCellState.SHIP_CELL_ALIVE);
//            if (leftCell.leftCell!=null) {
//                isShipFound = leftCell.leftCell.isCellOfState(FieldCellState.SHIP_CELL_ALIVE); // TODO сделать это методами Field, чтобы найти корабль в окрестностях по массиву, а не ссылкам
//            }
//        }
//    }

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
//        //boolean isHitSuccessful = true;
//        switch (fieldCellState) {
//            case EMPTY_CELL:
//                //System.out.println("You missed.");
//                setCellSymbol('+');//(char) 215);
//                //isHitSuccessful = false;
//                setFieldCellState(FieldCellState.EMPTY_CELL_STRICKEN);
//                break;
//            case SHIP_CELL_ALIVE:
//                //System.out.println("Nice strike! Shoot again.");
//                setCellSymbol('X');//(char) 9746);
//                setFieldCellState(FieldCellState.SHIP_CELL_DEAD);
//                break;
//            default:
//                //System.out.println("This cell is already stricken! Shoot again!");
//                break;
//        }
//        //return isHitSuccessful;
    }

    public void applyMiss() {
        setCellSymbol('+');
        setFieldCellState(FieldCellState.EMPTY_CELL_STRICKEN);
    }

    public void placeShip() {
        setCellSymbol('O');//(char) 9744);
        //isShipCell = true;
        setFieldCellState(FieldCellState.SHIP_CELL_ALIVE);
    }

}
