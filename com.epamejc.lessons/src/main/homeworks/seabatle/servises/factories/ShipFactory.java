package homeworks.seabatle.servises.factories;

import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.ShipType;

import static homeworks.seabatle.myenum.ShipType.*;


public class ShipFactory {
    private static final int BOATLIVES = 1;
    private static final int DESTROYERLIVES = 2;
    private static final int CRUISERLIVES = 3;
    private static final int BATTLESHIPLIVES = 4;

    /**
     * method for ship creation
     *
     * @param type - enum
     * @return ship with type and lives amount, depends on request type param
     */
    public Ship getShip(ShipType type) {
        Ship ship = new Ship();
        switch (type) {
            case BOAT:
                ship = new Ship(BOAT, BOATLIVES);
                break;
            case DESTROYER:
                ship = new Ship(DESTROYER, DESTROYERLIVES);
                break;
            case CRUISER:
                ship = new Ship(CRUISER, CRUISERLIVES);
                break;
            case BATTLESHIP:
                ship = new Ship(BATTLESHIP, BATTLESHIPLIVES);
                break;
        }
        return ship;
    }
}
