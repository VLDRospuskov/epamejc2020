package seabattle.Players;

import lombok.Data;
import seabattle.*;
import seabattle.Enums.FieldCellState;
import seabattle.Menus.MenuShipPlacer;

@Data
public class Player {
    private String name;
    private Player enemy;
    private Field mainField = new Field(Settings.fieldRows, Settings.fieldColumns);
    private Field supportField = new Field(Settings.fieldRows, Settings.fieldColumns);
    private ShipsCounter shipsCounter;

    public boolean isStrikeSuccessful(int row, int column) {
        return enemy.mainField.isCellOfState(row, column, FieldCellState.SHIP_CELL_ALIVE);
    }

    public boolean isStrikeMissing(int row, int column) {
        return enemy.mainField.isCellOfState(row, column, FieldCellState.EMPTY_CELL);
    }

    public boolean isStrikeLethal(int row, int column) {
        return enemy.mainField.getCellField()[row][column].isPartOfDeadShip();
    }

    public void shoot(int row, int column) {
        if (isStrikeSuccessful(row, column)) {
            enemy.takeHit(row, column);
            supportField.applyHit(row, column);
        } else {
            enemy.mainField.applyMiss(row, column);
            supportField.applyMiss(row, column);
        }
    }

    private void takeHit(int row, int column) {
        //shipsCounter.decreaseShipsLeftCounter();
        //mainField.surroundShipWithMisses(row, column);
        mainField.applyHit(row, column);
    }

    public void placeShips() {
        new MenuShipPlacer().runForPlayer(this);
    }

}
