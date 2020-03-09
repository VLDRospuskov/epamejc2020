package homework.seabattle;

import java.util.HashSet;
import java.util.Set;

import static homework.seabattle.Config.*;

public class ShipsField {

    private Set<Ship> ownActiveShips = new HashSet<>();

    private Set<Coordinate> ownEmptyCoordinates;

    {
        ownEmptyCoordinates = new HashSet<>();
        for (char i = MIN_LETTER; i <= MAX_LETTER; i++) {
            for (int j = MIN_NUMBER; j <= MAX_NUMBER; j++) {
                ownEmptyCoordinates.add(new Coordinate(i, j));
            }
        }
    }

    public Set<Ship> getOwnActiveShips() {
        return new HashSet<>(ownActiveShips);
    }

    public void tryAddShip(Coordinate coordinate, Ship.Type type, int length) {
        if (length == 1) {
            addShip(Ship.createOneDeckShip(coordinate));
        } else {
            addShip(Ship.create(type, coordinate, length));
        }
    }

    public void printShipsOnMap() {
        String state;
        System.out.print("  ABCDEFGHIJ");
        for (int number = 1; number <= MAX_NUMBER; number++) {
            System.out.print("\n" + number + (number != MAX_NUMBER ? " " : ""));
            for (char letter = MIN_LETTER; letter <= MAX_LETTER; letter++) {
                state = "";
                Coordinate currentCoord = new Coordinate(letter, number);
                if (ownEmptyCoordinates.contains(currentCoord)) {
                    state = "~";
                } else {
                    for (Ship ship : ownActiveShips) {
                        if (ship.contains(currentCoord)) {
                            state = "S";
                            break;
                        }
                    }
                }
                System.out.print(state);
            }
        }
        System.out.print("\n");
    }

    private void addShip(Ship newShip) {
        if (!newShip.isValid()) {
            throw new IllegalArgumentException("Entered ship is out of map");
        }

        for (Ship ship : ownActiveShips) {
            if (ship.intersects(newShip)) {
                throw new IllegalArgumentException("Entered ship intersects ship area that already exists");
            }
        }

        ownEmptyCoordinates.removeAll(newShip.getCoordinates());
        ownActiveShips.add(newShip);
    }

    public void removeActiveShip(Ship ship) {
        ownActiveShips.remove(ship);
    }

    public void addEmptyCoordinate(Coordinate coordinate) {
        ownEmptyCoordinates.add(coordinate);
    }

    public boolean containsEmptyCoordinate(Coordinate coordinate) {
        return ownEmptyCoordinates.contains(coordinate);
    }
}

