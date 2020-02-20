package seaBattle.data;

import seaBattle.logic.AutomaticShipPlacer;
import seaBattle.logic.FieldOperations;
import seaBattle.logic.ShipOperations;

import java.util.List;

public class Player {

    private FieldOperations battleFieldOperations = new FieldOperations();
    private ShipOperations shipOperations = new ShipOperations();
    private AutomaticShipPlacer automaticShipPlacer;

    public Player() {
        battleFieldOperations.generateField();
        shipOperations.generateShips();
        automaticShipPlacer = new AutomaticShipPlacer(battleFieldOperations);
        //automaticShipPlacer.placeShipsAutomatically(shipOperations.getShips());
    }

    public List<Cell> getField() {
        return battleFieldOperations.getField();
    }

    public List<Ship> getShips() {
        return shipOperations.getShips();
    }

    public ShipOperations shipsOperations() {
        return shipOperations;
    }

    public FieldOperations fieldOperations() {
        return battleFieldOperations;
    }

    public AutomaticShipPlacer shipPlacer() { return automaticShipPlacer; }

    public int getShipsCount() {
        return shipOperations.getShips().size();
    }
}
