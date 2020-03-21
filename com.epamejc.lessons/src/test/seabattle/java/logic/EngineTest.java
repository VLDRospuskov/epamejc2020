package seabattle.java.logic;

import org.junit.*;
import seabattle.java.models.Field;
import seabattle.java.models.Ship;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EngineTest {

    private Field field;
    private Engine engine;

    @Before
    public void setUp() {
        field = new Field(1);
        engine = new Engine();
    }

    @Test
    public void autoShipPlacementTest() {
        engine.autoShipPlacement(field);
        int expectedCountOfShips = 10;
        int actualCountOfShips = (int) field.getShips().stream().count();
        assertEquals(expectedCountOfShips, actualCountOfShips);
    }

    @Test
    public void checkAllShipsLimitTest() {
        field.getShips().add(new Ship(2, new Integer[]{2, 0}, new Integer[]{3, 0}, field));
        field.getShips().add(new Ship(2, new Integer[]{6, 0}, new Integer[]{7, 0}, field));
        field.getShips().add(new Ship(2, new Integer[]{2, 9}, new Integer[]{3, 9}, field));
        boolean expected = false;
        boolean actual = engine.checkAllShipsLimit(field);
        assertEquals(expected, actual);

        field = new Field(1);
        engine.autoShipPlacement(field);
        expected = true;
        actual = engine.checkAllShipsLimit(field);
        assertEquals(expected, actual);
    }

    @Test
    public void checkCertainShipsLimitTest() {
        int shipType = 2;
        field.getShips().add(new Ship(shipType, new Integer[]{2, 0}, new Integer[]{3, 0}, field));
        field.getShips().add(new Ship(shipType, new Integer[]{6, 0}, new Integer[]{7, 0}, field));
        boolean expected = false;
        boolean actual = engine.checkCertainShipsLimit(field, shipType);
        assertEquals(expected, actual);

        field.getShips().add(new Ship(shipType, new Integer[]{5, 5}, new Integer[]{5, 6}, field));
        expected = true;
        actual = engine.checkCertainShipsLimit(field, shipType);
        assertEquals(expected, actual);
    }

    @Test
    public void placeShipTest() {
        Integer shipType = 2;
        Integer[] startYX = {0, 0};
        Integer[] endYX = {0, 3};
        ArrayList params = new ArrayList();
        params.add(shipType);
        params.add(startYX);
        params.add(endYX);
        engine.placeShip(field, params, true);
        int expectedCountOfShips = 0;
        int actualCountOfShips = (int) field.getShips().stream().count();
        assertEquals(expectedCountOfShips, actualCountOfShips);

        endYX[1] = 1;
        params = new ArrayList();
        params.add(shipType);
        params.add(startYX);
        params.add(endYX);
        engine.placeShip(field, params, true);
        expectedCountOfShips = 1;
        actualCountOfShips = (int) field.getShips().stream().count();
        assertEquals(expectedCountOfShips, actualCountOfShips);
    }

}
