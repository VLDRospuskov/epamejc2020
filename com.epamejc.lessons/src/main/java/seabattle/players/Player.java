package seabattle.players;

import lombok.Data;
import lombok.SneakyThrows;
import seabattle.shipsCounter.ShipsCounter;
import seabattle.enums.FieldCellState;
import seabattle.field.Field;
import seabattle.menus.Menu;
import seabattle.menus.MenuShipPlacer;
import seabattle.settings.Settings;

@Data
public class Player {
    protected String name;
    protected Player enemy;
    protected Field mainField = new Field(Settings.fieldRows, Settings.fieldColumns);
    protected Field supportField = new Field(Settings.fieldRows, Settings.fieldColumns);
    protected ShipsCounter shipsCounter;

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
        mainField.applyHit(row, column);
    }

    public void placeShips() {
        new MenuShipPlacer().runForPlayer(this);
    }

    @SneakyThrows
    public String getShootingCommand() {
        return Menu.reader.readLine();
    }

}
