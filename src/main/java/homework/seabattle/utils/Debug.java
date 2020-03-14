package homework.seabattle.utils;

import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ShipsField;
import homework.seabattle.model.ships.ShipType;

/*
Class for debugging, allows setting ships location without console input
 */
public class Debug {
    public static void setShipsLocation1(ShipsField shipsField) {
        shipsField.tryAddShip(new Coordinate('g', 1), ShipType.Type.HORIZONTAL, 4);
        shipsField.tryAddShip(new Coordinate('h', 3), ShipType.Type.HORIZONTAL, 3);
        shipsField.tryAddShip(new Coordinate('h', 5), ShipType.Type.HORIZONTAL, 3);
        shipsField.tryAddShip(new Coordinate('i', 7), ShipType.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('i', 9), ShipType.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('b', 1), ShipType.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('b', 4), ShipType.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 6), ShipType.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 8), ShipType.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 10), ShipType.Type.VERTICAL, 1);
    }

    public static void setShipsLocation2(ShipsField shipsField) {
        shipsField.tryAddShip(new Coordinate('a', 3), ShipType.Type.VERTICAL, 4);
        shipsField.tryAddShip(new Coordinate('c', 3), ShipType.Type.VERTICAL, 3);
        shipsField.tryAddShip(new Coordinate('e', 3), ShipType.Type.VERTICAL, 3);
        shipsField.tryAddShip(new Coordinate('g', 3), ShipType.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('i', 3), ShipType.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('a', 10), ShipType.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('d', 10), ShipType.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('f', 10), ShipType.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('h', 10), ShipType.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('j', 10), ShipType.Type.HORIZONTAL, 1);
    }
}
