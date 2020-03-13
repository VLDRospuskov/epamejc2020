package homework.seabattle.utils;

import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ShipsField;
import homework.seabattle.model.ships.Ship;

/*
Class for debugging, allows setting ships location without console input
 */
public class Debug {
    public static void setShipsLocation1(ShipsField shipsField) {
        shipsField.tryAddShip(new Coordinate('g', 1), Ship.Type.HORIZONTAL, 4);
        shipsField.tryAddShip(new Coordinate('h', 3), Ship.Type.HORIZONTAL, 3);
        shipsField.tryAddShip(new Coordinate('h', 5), Ship.Type.HORIZONTAL, 3);
        shipsField.tryAddShip(new Coordinate('i', 7), Ship.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('i', 9), Ship.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('b', 1), Ship.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('b', 4), Ship.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 6), Ship.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 8), Ship.Type.VERTICAL, 1);
        shipsField.tryAddShip(new Coordinate('b', 10), Ship.Type.VERTICAL, 1);
    }

    public static void setShipsLocation2(ShipsField shipsField) {
        shipsField.tryAddShip(new Coordinate('a', 3), Ship.Type.VERTICAL, 4);
        shipsField.tryAddShip(new Coordinate('c', 3), Ship.Type.VERTICAL, 3);
        shipsField.tryAddShip(new Coordinate('e', 3), Ship.Type.VERTICAL, 3);
        shipsField.tryAddShip(new Coordinate('g', 3), Ship.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('i', 3), Ship.Type.VERTICAL, 2);
        shipsField.tryAddShip(new Coordinate('a', 10), Ship.Type.HORIZONTAL, 2);
        shipsField.tryAddShip(new Coordinate('d', 10), Ship.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('f', 10), Ship.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('h', 10), Ship.Type.HORIZONTAL, 1);
        shipsField.tryAddShip(new Coordinate('j', 10), Ship.Type.HORIZONTAL, 1);
    }
}
