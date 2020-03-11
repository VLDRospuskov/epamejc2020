package homeworks.seabatle.model.board;

import homeworks.seabatle.exception.ShipCreationRequestException;
import homeworks.seabatle.exception.ShipNotFoundException;
import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.ShipType;
import homeworks.seabatle.servises.factories.ShipFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerShipsRepositoryTest {
    private PlayerShipsRepository repository;
    private ShipFactory factory;
    private Ship batleShip;
    private Ship destroyer;
    private Ship boat;
    private Ship cruiser;
    private int[] bCoords = {12, 22, 32, 42};
    private int[] cCoords = {27, 28, 29};
    private int[] dCoords = {72, 73};
    private int[] boatCoords = {9};
    private static final String SUCCESS = " successfully added!";

    @Before
    public void setUp() throws Exception {
        repository = new PlayerShipsRepository();
        factory = new ShipFactory();

        batleShip = factory.getShip(ShipType.BATTLESHIP);

        batleShip.setCoords(bCoords);
        cruiser = factory.getShip(ShipType.CRUISER);

        cruiser.setCoords(cCoords);
        destroyer = factory.getShip(ShipType.DESTROYER);

        destroyer.setCoords(dCoords);
        boat = factory.getShip(ShipType.BOAT);

        boat.setCoords(boatCoords);

    }

    @Test
    public void testAddShip() {

        assertEquals(batleShip.getType() + SUCCESS, repository.addShip(batleShip));
        assertEquals(cruiser.getType() + SUCCESS, repository.addShip(cruiser));
        assertEquals(destroyer.getType() + SUCCESS, repository.addShip(destroyer));
        assertEquals(boat.getType() + SUCCESS, repository.addShip(boat));
    }

    @Test(expected = ShipCreationRequestException.class)
    public void testAddWrongCoordShip() {
        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);
        Ship fakeDestroyer = factory.getShip(ShipType.DESTROYER);
        int[] dCoords = {15, 16};
        fakeDestroyer.setCoords(dCoords);
        repository.addShip(fakeDestroyer);
    }

    @Test
    public void testGetShip() {
        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);

        assertEquals(batleShip, repository.getShip(bCoords[0]));
        assertEquals(batleShip, repository.getShip(bCoords[1]));
        assertEquals(batleShip, repository.getShip(bCoords[2]));
        assertEquals(batleShip, repository.getShip(bCoords[3]));

        assertEquals(cruiser, repository.getShip(cCoords[0]));
        assertEquals(cruiser, repository.getShip(cCoords[1]));
        assertEquals(cruiser, repository.getShip(cCoords[2]));

        assertEquals(destroyer, repository.getShip(dCoords[0]));
        assertEquals(destroyer, repository.getShip(dCoords[1]));

        assertEquals(boat, repository.getShip(boatCoords[0]));
    }

    @Test(expected = ShipNotFoundException.class)
    public void testFakeGetShip() {
        repository.addShip(batleShip);
        repository.getShip(89);
    }


    @Test
    public void testUpdateShip() {
        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);

        batleShip.decrementLives();
        cruiser.decrementLives();
        destroyer.decrementLives();
        boat.decrementLives();

        repository.updateShip(batleShip);
        repository.updateShip(cruiser);
        repository.updateShip(destroyer);
        repository.updateShip(boat);

        assertEquals(batleShip.getLives(), repository.getShip(bCoords[0]).getLives());
        assertEquals(cruiser.getLives(), repository.getShip(cCoords[0]).getLives());
        assertEquals(destroyer.getLives(), repository.getShip(dCoords[0]).getLives());
        assertEquals(boat.getLives(), repository.getShip(boatCoords[0]).getLives());
    }

    @Test
    public void testGetAll() {
        List<Ship> ships = Arrays.asList(batleShip, cruiser, destroyer, boat);
        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);
        assertEquals(ships, repository.getAll());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, repository.getSize());
        List<Ship> ships = Arrays.asList(batleShip, cruiser, destroyer, boat);
        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);
        assertEquals(ships.size(), repository.getSize());
    }

    @Test
    public void testDelete() {

        repository.addShip(batleShip);
        repository.addShip(cruiser);
        repository.addShip(destroyer);
        repository.addShip(boat);

        assertEquals(4, repository.getSize());
        repository.delete(batleShip);
        assertEquals(3, repository.getSize());
        repository.delete(cruiser);
        assertEquals(2, repository.getSize());
        repository.delete(destroyer);
        assertEquals(1, repository.getSize());
        repository.delete(boat);
        assertEquals(0, repository.getSize());
    }
}