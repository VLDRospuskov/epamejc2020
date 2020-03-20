package homework.seabattle.model;

import homework.seabattle.model.ships.HorizontalShip;
import homework.seabattle.model.ships.Ship;
import homework.seabattle.model.ships.ShipType;
import homework.seabattle.model.ships.VerticalShip;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ShipsFieldTest {

    ShipsField shipsField;

    @Before
    public void setup() {
        shipsField = new ShipsField();
        shipsField.tryAddShip(new Coordinate('g', 1), ShipType.Type.HORIZONTAL, 4);
        shipsField.tryAddShip(new Coordinate('h', 3), ShipType.Type.HORIZONTAL, 3);
    }

    @Test()
    public void tryAddShip() {
        Coordinate startCoordinate = new Coordinate('a', 1);
        shipsField.tryAddShip(startCoordinate, ShipType.Type.VERTICAL, 4);

        assertEquals(3, shipsField.getOwnActiveShips().size());
        assertTrue(shipsField.getOwnActiveShips().contains(new VerticalShip(startCoordinate, 4)));
    }

    @Test
    public void removeActiveShip() {
        Set<Ship> primaryShips = shipsField.getOwnActiveShips();
        HorizontalShip ship = new HorizontalShip(new Coordinate('g', 1), 4);
        shipsField.removeActiveShip(ship);

        Set<Ship> expectedShipCoordinates = new HashSet<>(primaryShips);
        expectedShipCoordinates.remove(ship);
        assertEquals(expectedShipCoordinates, shipsField.getOwnActiveShips());
    }

    @Test
    public void addEmptyCoordinate() {
        Coordinate coordinate = new Coordinate('g', 1);
        assertFalse(shipsField.getOwnEmptyCoordinates().contains(coordinate));

        shipsField.addEmptyCoordinate(coordinate);
        assertTrue(shipsField.getOwnEmptyCoordinates().contains(coordinate));
    }

    @Test
    public void containsEmptyCoordinate() {
        assertTrue(shipsField.containsEmptyCoordinate(new Coordinate('b', 1)));
        assertTrue(shipsField.containsEmptyCoordinate(new Coordinate('a', 2)));
        assertFalse(shipsField.containsEmptyCoordinate(new Coordinate('j', 1)));
    }
}