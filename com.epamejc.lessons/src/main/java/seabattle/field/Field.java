package seabattle.field;

import lombok.Getter;
import seabattle.enums.Direction;
import seabattle.enums.FieldCellState;
import seabattle.shipPlacement.ShipPlacingParams;

@Getter
public class Field {
    private Cell[][] cellField;

    public Field(int numberOfRows, int numberOfColumns) {
        initField(numberOfRows, numberOfColumns);
    }

    public boolean isCellOfState(int row, int column, FieldCellState fieldCellState) {
        return cellField[row][column].isCellOfState(fieldCellState);
    }

    public void applyHit(int row, int column) {
        cellField[row][column].applyHit();
    }

    public void applyMiss(int row, int column) {
        cellField[row][column].applyMiss();
    }

    public void surroundShipWithMisses(int row, int column) {
        Cell currentCell = cellField[row][column];
        currentCell.surroundWithMissesTillEndOfShip(Direction.LEFT);
        currentCell.surroundWithMissesTillEndOfShip(Direction.UP);
        currentCell.surroundWithMissesTillEndOfShip(Direction.DOWN);
        currentCell.surroundWithMissesTillEndOfShip(Direction.RIGHT);
    }

    public void placeShip(ShipPlacingParams shipPlacingParams) {
        Cell currentCell = cellField[shipPlacingParams.getRow()][shipPlacingParams.getColumn()];
        for (int i = 0; i < shipPlacingParams.getNumberOfDecks(); i++) {
            currentCell.placeShip();
            currentCell = currentCell.getNextCellByDirection(shipPlacingParams.getDirection());
        }
    }

    public boolean isShipPlacementLegal(ShipPlacingParams shipPlacingParams) {
        int row = shipPlacingParams.getRow();
        int column = shipPlacingParams.getColumn();
        int size = shipPlacingParams.getNumberOfDecks();
        Direction direction = shipPlacingParams.getDirection();
        Cell currentCell = cellField[row][column];
        return currentCell.isLegalToStartShipHere(direction, size);
    }

    private void initField(int rows, int columns) {
        cellField = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cellField[i][j] = new Cell();
                if (i != 0) {
                    cellField[i][j].setUpCell(cellField[i - 1][j]);
                    cellField[i][j].upCell.setDownCell(cellField[i][j]);
                }
                if (j != 0) {
                    cellField[i][j].setLeftCell(cellField[i][j - 1]);
                    cellField[i][j].leftCell.setRightCell(cellField[i][j]);
                }
            }
        }
    }

}
