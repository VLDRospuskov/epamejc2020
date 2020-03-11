package homeworks.seabatle.model.ship;

import homeworks.seabatle.exception.ShipCreationRequestException;
import homeworks.seabatle.myenum.ShipType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ShipTest {
    Ship batleShip;
    int batleLives = 4;
    Ship boat;
    int bLive = 1;
    int[] coords1 = {2, 3, 4, 5};
    int[] coords2 = {22, 32, 42, 52};
    int[] coords3 = {2};
    int[] fakecoords = {12, 13};

    @Before
    public void setUp() throws Exception {
        boat = new Ship(ShipType.BOAT, bLive);
        batleShip = new Ship(ShipType.BATTLESHIP, batleLives);

    }

    @Test
    public void testEmptyConstructor() {
        Ship ship = new Ship();
    }

    @Test
    public void testDecrementLives() {
        assertEquals(bLive, boat.getLives());
        boat.decrementLives();
        assertEquals(--bLive, boat.getLives());

        assertEquals(batleLives, batleShip.getLives());
        batleShip.decrementLives();
        assertEquals(--batleLives, batleShip.getLives());

    }

    @Test
    public void testSetCoords() {
        batleShip.setCoords(coords1);
        assertArrayEquals(coords1, batleShip.getCoords());

        batleShip.setCoords(coords2);
        assertArrayEquals(coords2, batleShip.getCoords());

        boat.setCoords(coords3);
        assertArrayEquals(coords3, boat.getCoords());
    }

    @Test(expected = ShipCreationRequestException.class)
    public void testSetFakeBattleCoords() {
        batleShip.setCoords(fakecoords);
    }

    @Test(expected = ShipCreationRequestException.class)
    public void testSetFakeBoatCoords() {
        batleShip.setCoords(fakecoords);
    }

    @Test
    public void testGetLives() {
        assertEquals(bLive, boat.getLives());
        assertEquals(batleLives, batleShip.getLives());
    }

    @Test
    public void testGetId() {
        assertTrue(batleShip.getId() != boat.getId());
    }

    @Test
    public void testGetCoords() {
        batleShip.setCoords(coords1);
        assertArrayEquals(coords1, batleShip.getCoords());

        boat.setCoords(coords3);
        assertArrayEquals(coords3, boat.getCoords());

    }

    @Test
    public void testGetType() {
        assertEquals(ShipType.BATTLESHIP, batleShip.getType());
        assertEquals(ShipType.BOAT, boat.getType());
    }

}