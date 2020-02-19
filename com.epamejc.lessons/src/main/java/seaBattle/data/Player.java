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

    public List<Ship> getShips() {
        return battleShips.getShips();
    }

    public BattleShips shipsOperations() {
        return battleShips;
    }

    public Field fieldOperations() {
        return battleField;
    }

    public int getShipsCount() {
        return battleShips.getShips().size();
    }
}
