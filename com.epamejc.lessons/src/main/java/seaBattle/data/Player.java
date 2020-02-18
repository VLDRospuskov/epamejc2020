package seaBattle.data;

import java.util.List;

public class Player {

    private Field battleField = new Field();
    private BattleShips battleShips = new BattleShips();
    private ShipPlacer shipPlacer;

    public Player() {
        battleField.generateField();
        battleShips.generateShips();
        shipPlacer = new ShipPlacer(battleField);
        shipPlacer.placeShipsAutomatically(battleShips.getShips());
    }

    public List<Cell> getField() {
        return battleField.getField();
    }

    public int getShipsCount() {
        return battleShips.getShips().size();
    }
}
