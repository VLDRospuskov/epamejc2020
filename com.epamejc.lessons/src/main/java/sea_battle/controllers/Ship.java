package sea_battle.controllers;

import sea_battle.utils.ShipTypes;

import java.util.ArrayList;

public class Ship {

    private ShipTypes shipType;
    private ArrayList<Coordinates> coords;
    private int decksNotHited;

    public Ship(ShipTypes shipType, ArrayList<Coordinates> coords) {
        this.shipType = shipType;
        this.coords = coords;
        this.decksNotHited = this.coords.size();
    }

    public ShipTypes getShipType() {
        return shipType;
    }

    public ArrayList<Coordinates> getCoords() {
        return coords;
    }

    public void setDecksNotHited() {
        this.decksNotHited--;
    }

    public boolean isAfloat() {
        return this.decksNotHited > 0;
    }
}
