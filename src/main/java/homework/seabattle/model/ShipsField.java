package homework.seabattle.model;

import homework.seabattle.model.ships.Ship;

import java.util.HashSet;
import java.util.Set;

import static homework.seabattle.config.Config.*;

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

    public Set<Coordinate> getOwnEmptyCoordinates() {
        return new HashSet<>(ownEmptyCoordinates);
    }

    public void tryAddShip(Coordinate coordinate, Ship.Type type, int length) {
        if (length == 1) {
            addShip(Ship.createOneDeckShip(coordinate));
        } else {
            addShip(Ship.create(type, coordinate, length));
        }
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

