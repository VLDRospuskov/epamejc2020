package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Field;
import homeworks.sea_battle.data.Ship;
import homeworks.sea_battle.enums.ShipTypes;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AutomaticShipSetterTest {

    private static ShipsSetterCommands shipsSetterCommands;
    private static Field field;
    private static ArrayList<Ship> ships;

    @BeforeClass
    public static void setup() {
        shipsSetterCommands = new AutomaticShipSetter();
        field = new Field();

    }

    @Test
    public void testCreateShips() {
        ships = shipsSetterCommands.createShips(field, ShipTypes.SINGLE_DECK, 4);
        int expectedSize = 4;
        int actualSize = ships.size();

        Assert.assertEquals(expectedSize, actualSize);

        for (Ship ship : ships) {
            ArrayList<Coordinates> coordinates = ship.getCoords();
            int expectedCoordsSize = 1;
            int actualCoordSize = coordinates.size();
            ShipTypes expectedType = ShipTypes.SINGLE_DECK;
            ShipTypes actualType = ship.getShipType();
            boolean expectedIsAfloat = true;
            boolean actualIsAfloat = ship.isAfloat();

            Assert.assertEquals(expectedCoordsSize, actualCoordSize);
            Assert.assertEquals(expectedType, actualType);
            Assert.assertEquals(expectedIsAfloat, actualIsAfloat);
        }

    }
}