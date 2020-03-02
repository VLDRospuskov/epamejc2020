package homeworks.seaBattle.data;

import homeworks.seaBattle.logic.AutomaticShipPlacer;
import homeworks.seaBattle.logic.FieldOperations;
import homeworks.seaBattle.logic.ManualShipPlacer;
import homeworks.seaBattle.logic.ShipOperations;

import java.util.List;

public class Player {

    private FieldOperations battleFieldOperations = new FieldOperations();
    private ShipOperations shipOperations = new ShipOperations();
    private AutomaticShipPlacer automaticShipPlacer;
    private ManualShipPlacer manualShipPlacer;

    public Player() {
        battleFieldOperations.generateField();
        shipOperations.generateShips();
        automaticShipPlacer = new AutomaticShipPlacer(battleFieldOperations);
        manualShipPlacer = new ManualShipPlacer(battleFieldOperations);
    }

    public List<Cell> getField() {
        return battleFieldOperations.getField();
    }

    public ShipOperations shipsOperations() {
        return shipOperations;
    }

    public FieldOperations fieldOperations() {
        return battleFieldOperations;
    }

    public AutomaticShipPlacer automaticShipPlacer() { return automaticShipPlacer; }

    public ManualShipPlacer manualShipPlacer() { return manualShipPlacer;}

    public int getShipsCount() {
        return shipOperations.getShips().size();
    }
}
