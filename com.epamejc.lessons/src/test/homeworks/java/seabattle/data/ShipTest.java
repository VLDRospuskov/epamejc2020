package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;
import org.junit.Assert;
import org.junit.Test;

public class ShipTest {

    @Test
    public void testHit() {

        GameState expected = GameState.HIT;

        Ship ship = new Ship(Ships.CRUISER, 4);
        GameState actual = ship.hit();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testDestroyed() {

        GameState expected = GameState.DESTROYED;

        Ship ship = new Ship(Ships.BOAT, 1);
        GameState actual = ship.hit();

        Assert.assertEquals(expected, actual);

    }

}
