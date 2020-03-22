package seabattle;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShipsTest {


    @Test
    public void isHit() {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0, 1));
        coordinates.add(new Coordinates(0, 2));
        coordinates.add(new Coordinates(0, 3));
        Ships ship = new Ships(coordinates);
        assertFalse(ship.isHit(0, 0));
        assertTrue(ship.isHit(0, 1));
        assertTrue(ship.isHit(0, 2));
        assertTrue(ship.isHit(0, 3));
    }

    @Test
    public void isThisRightShip() {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0, 1));
        coordinates.add(new Coordinates(0, 2));
        coordinates.add(new Coordinates(0, 3));
        Ships ship = new Ships(coordinates);
        assertEquals(ship.isThisRightShip(0, 0, true), -1);
        assertEquals(ship.isThisRightShip(0, 3, false), 2);

    }

    @Test
    public void getShipCoordinates() {

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0, 1));
        coordinates.add(new Coordinates(0, 2));
        coordinates.add(new Coordinates(0, 3));
        Ships ship = new Ships(coordinates);
        assertEquals(ship.getShipCoordinates(), coordinates);
    }

    @Test
    public void isDead() {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0, 1));
        coordinates.add(new Coordinates(0, 2));
        coordinates.add(new Coordinates(0, 3));
        Ships ship = new Ships(coordinates);
        assertTrue(ship.isHit(0, 1));
        assertTrue(ship.isHit(0, 2));
        assertTrue(ship.isHit(0, 3));
        assertTrue(ship.isDead());
    }
}
