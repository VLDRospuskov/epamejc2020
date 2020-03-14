package homeworks.sea_battle.data;

import homeworks.sea_battle.enums.ShipTypes;

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

    public ArrayList<Coordinates> getCoords() {
        return coords;
    }

    public void reduceDecksAlive() {
        this.decksAlive--;
    }

    public boolean isAfloat() {
        return this.decksAlive > 0;
    }

}
