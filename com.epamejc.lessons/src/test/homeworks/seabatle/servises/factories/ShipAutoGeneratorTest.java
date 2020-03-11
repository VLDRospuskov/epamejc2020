package homeworks.seabatle.servises.factories;

import homeworks.seabatle.model.board.ShipsRepository;
import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.ShipType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShipAutoGeneratorTest {
    private ShipAutoGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new ShipAutoGenerator();
    }

    @Test
    public void testGetGeneratedRepository() {
        for (int i = 0; i < 20000; i++) {
            ShipsRepository repository = generator.getGeneratedRepository();
            assertNotNull(repository);
            List<Ship> ships = repository.getAll();
            int countBoat = 0;
            int countDestroyer = 0;
            int countCruiser = 0;
            int countBattleShip = 0;
            for (Ship ship : ships) {
                if (ShipType.BOAT.equals(ship.getType())) {
                    countBoat++;
                } else if (ShipType.DESTROYER.equals(ship.getType())) {
                    countDestroyer++;
                } else if (ShipType.CRUISER.equals(ship.getType())) {
                    countCruiser++;
                } else if (ShipType.BATTLESHIP.equals(ship.getType())) {
                    countBattleShip++;
                }
                int[] coords = ship.getCoords();
                for (int j = 0; j < coords.length; j++) {
                    assertTrue(coords[j] < 100);
                }
            }
            assertEquals(4, countBoat);
            assertEquals(3, countDestroyer);
            assertEquals(2, countCruiser);
            assertEquals(1, countBattleShip);
        }
    }

    @Test
    public void testChekCoord() {
        int[] one = {99, 103, 12};
        int[] two = {99, 78, 12};
        int[] three = {102};
        int[] four = {111};
        assertTrue(generator.checkCoords(two));
        assertFalse(generator.checkCoords(one));
        assertFalse(generator.checkCoords(three));
        assertFalse(generator.checkCoords(four));
    }

}