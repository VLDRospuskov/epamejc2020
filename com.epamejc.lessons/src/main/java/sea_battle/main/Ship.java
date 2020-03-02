package sea_battle.main;

import sea_battle.utils.ShipTypes;

import java.util.ArrayList;

public class Ship {

    private ShipTypes shipType;
    private ArrayList<Coordinates> coords;
    private int decksAlive;

    public Ship(ShipTypes shipType, ArrayList<Coordinates> coords) {
        this.shipType = shipType;
        this.coords = coords;
        this.decksAlive = this.coords.size();
    }

    public ShipTypes getShipType() {
        return shipType;
    }

    public ArrayList<Coordinates> getCoords() {
        return coords;
    }

    public void setDecksNotHited() {
        this.decksAlive--;
    }

    public boolean isAfloat() {
        return this.decksAlive > 0;
    }
}
