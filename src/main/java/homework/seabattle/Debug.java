package homework.seabattle;

import java.util.List;
import java.util.Set;

import static homework.seabattle.Config.MAX_LETTER;
import static homework.seabattle.Config.MIN_LETTER;

public class Debug {
    /*
    O - oreol (area)
    S - ship
    _ - empty
     */
    public static void printMap(Set<Ship> ships) {
        String state = "";
        System.out.print("0ABCDEFGHIJ");
        for (int i = 1; i <= 10; i++) {
            System.out.print("\n" + i);
            for (char j = MIN_LETTER; j <= MAX_LETTER; j++) {
                state = "_";
                Coordinate currentCoord = new Coordinate(j, i);
                for (Ship ship : ships) {
                    for (Coordinate coordinate : ship.getCoordinates()) {
                        if (coordinate.equals(currentCoord)) {
                            state = "S";
                        }
                    }
                    for (Coordinate coordinate : ship.getAreaCoordinates()) {
                        if (coordinate.equals(currentCoord)) {
                            state = "O";
                        }
                    }
                }
                System.out.print(state);
            }
        }
        System.out.print("\n");
    }

    public static void setShipsLocation1(ShipsField shipsField) {
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 1), 4));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 3), 3));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 5), 3));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 7), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 9), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('j', 1), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('j', 4), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('j', 6), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('j', 8), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('j', 10), 1));
    }

    public static void setShipsLocation2(ShipsField shipsField) {
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('a', 1), 4));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('c', 1), 3));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('e', 1), 3));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('g', 1), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.VERTICAL, new Coordinate('i', 1), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('a', 10), 2));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('d', 10), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('f', 10), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('h', 10), 1));
        shipsField.tryAddShip(Ship.create(Ship.Type.HORIZONTAL, new Coordinate('j', 10), 1));
    }


}
