package homework.seabattle.model.ships;

import homework.seabattle.model.Coordinate;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class VerticalShipTest {
    private VerticalShip ship1;
    private VerticalShip ship3;
    private VerticalShip ship2;
    private VerticalShip ship4;

    @Before
    public void setUp() {
        ship1 = new VerticalShip(new Coordinate('a', 1), 4);
        ship2 = new VerticalShip(new Coordinate('d', 6), 3);
        ship3 = new VerticalShip(new Coordinate('c', 3), 1);
        ship4 = new VerticalShip(new Coordinate('j', 9), 2);
    }

    @Test
    public void calculateAllCoordinates() {
        assertEquals(getExpectedCoordinates('a', 1, 4), ship1.getCoordinates());
        assertEquals(getExpectedCoordinates('d', 6, 3), ship2.getCoordinates());
        assertEquals(getExpectedCoordinates('c', 3, 1), ship3.getCoordinates());
        assertEquals(getExpectedCoordinates('j', 9, 2), ship4.getCoordinates());
    }

    private List<Coordinate> getExpectedCoordinates(char letter, int startNumber, int length) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int number = startNumber; number < startNumber + length; number++) {
            coordinates.add(new Coordinate(letter, number));
        }
        return coordinates;
    }

    @Test
    public void calculateArea() {
        Set<Coordinate> area1 = new HashSet<>();
        area1.add(new Coordinate('b', 1));
        area1.add(new Coordinate('b', 2));
        area1.add(new Coordinate('b', 3));
        area1.add(new Coordinate('b', 4));
        area1.add(new Coordinate('b', 5));
        area1.add(new Coordinate('a', 5));

        Set<Coordinate> area3 = new HashSet<>();
        area3.add(new Coordinate('b', 2));
        area3.add(new Coordinate('c', 2));
        area3.add(new Coordinate('d', 2));
        area3.add(new Coordinate('d', 3));
        area3.add(new Coordinate('d', 4));
        area3.add(new Coordinate('c', 4));
        area3.add(new Coordinate('b', 4));
        area3.add(new Coordinate('b', 3));

        Set<Coordinate> area4 = new HashSet<>();
        area4.add(new Coordinate('i', 10));
        area4.add(new Coordinate('i', 9));
        area4.add(new Coordinate('i', 8));
        area4.add(new Coordinate('j', 8));

        assertEquals(area1, ship1.getAreaCoordinates());
        assertEquals(area3, ship3.getAreaCoordinates());
        assertEquals(area4, ship4.getAreaCoordinates());
    }

    @Test
    public void create() {

        Coordinate startCoordinate = new Coordinate('a', 1);
        Ship ship = Ship.create(ShipType.Type.VERTICAL, startCoordinate, 2);

        assertTrue(ship instanceof VerticalShip);
        assertEquals(Arrays.asList(startCoordinate, new Coordinate('a', 2)), ship.getCoordinates());
    }

    @Test
    public void addCoordinate() {
        List<Coordinate> primaryShipCoordinates = ship4.getCoordinates();
        Coordinate coordinate = new Coordinate('j', 8);
        ship4.addCoordinate(coordinate);

        List<Coordinate> expectedShipCoordinates = new ArrayList<>(primaryShipCoordinates);
        expectedShipCoordinates.add(coordinate);
        assertEquals(expectedShipCoordinates, ship4.getCoordinates());
    }

    @Test
    public void removeCoordinate() {
        List<Coordinate> primaryShipCoordinates = ship4.getCoordinates();
        Coordinate coordinate = new Coordinate('j', 9);
        ship4.removeCoordinate(coordinate);

        List<Coordinate> expectedShipCoordinates = new ArrayList<>(primaryShipCoordinates);
        expectedShipCoordinates.remove(coordinate);
        assertEquals(expectedShipCoordinates, ship4.getCoordinates());
    }

    @Test
    public void contains() {
        assertFalse(ship1.contains(new Coordinate('b', 1)));
        assertTrue(ship1.contains(new Coordinate('a', 2)));
        assertTrue(ship2.contains(new Coordinate('d', 7)));
        assertTrue(ship3.contains(new Coordinate('c', 3)));
        assertTrue(ship4.contains(new Coordinate('j', 10)));
    }

    @Test
    public void occupies() {
        assertTrue(ship1.occupies(new Coordinate('b', 1)));
        assertTrue(ship1.occupies(new Coordinate('a', 2)));
        assertTrue(ship1.occupies(new Coordinate('a', 5)));
        assertFalse(ship1.occupies(new Coordinate('c', 1)));
        assertTrue(ship3.occupies(new Coordinate('c', 2)));
        assertTrue(ship3.occupies(new Coordinate('c', 3)));
        assertTrue(ship4.occupies(new Coordinate('i', 10)));
    }

    @Test
    public void intersects() {
        HorizontalShip checkedShip1 = new HorizontalShip(new Coordinate('a', 1), 2);
        HorizontalShip checkedShip2 = new HorizontalShip(new Coordinate('a', 2), 2);
        VerticalShip checkedShip3 = new VerticalShip(new Coordinate('a', 5), 1);

        assertTrue(ship1.intersects(checkedShip1));
        assertTrue(ship1.intersects(checkedShip2));
        assertTrue(ship1.intersects(checkedShip3));
        assertFalse(ship1.intersects(ship4));
    }
}