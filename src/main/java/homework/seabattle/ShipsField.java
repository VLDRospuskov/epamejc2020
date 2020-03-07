package homework.seabattle;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import static homework.seabattle.Config.*;

@Data
public class ShipsField {

    private Set<Ship> ownActiveShips = new HashSet<>();
    private Set<Coordinate> ownEmptyCoordinates;

    {
        ownEmptyCoordinates = new HashSet<>();
        for (char i = MIN_LETTER; i < MAX_LETTER; i++) {
            for (int j = MIN_NUMBER; j < MAX_NUMBER; j++) {
                ownEmptyCoordinates.add(new Coordinate(i, j));
            }
        }
    }

    public void tryAddShip(Ship newShip) {
        if (!newShip.isValid()) {
            throw new IllegalArgumentException("Entered ship is out of map");
        }

        for (Coordinate coordinate : newShip.getCoordinates()) {
            for (Ship ship : ownActiveShips) {
                if (ship.occupies(coordinate)) {
                    throw new IllegalArgumentException("Entered ship intersects ship area that already exists");
                }
            }
        }

        ownEmptyCoordinates.removeAll(newShip.getCoordinates());
        ownActiveShips.add(newShip);
    }
}

