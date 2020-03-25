package seabattle.players;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import seabattle.enums.FieldCellState;
import seabattle.shipPlacement.ShipPlacingParams;

public class PlayerTest {
    Player player1 = new Player();
    Player player2 = new Player();

    @Before
    public void initField() {
        player1.setEnemy(player2);
        player2.setEnemy(player1);
        player2.mainField.placeShip(new ShipPlacingParams("a1", 4));
        player2.mainField.placeShip(new ShipPlacingParams("a3", 1));
    }

    @Test
    public void testIsStrikeSuccessful() {
        Assert.assertTrue(player1.isStrikeSuccessful(0,0));
        Assert.assertFalse(player1.isStrikeSuccessful(1,1));
    }

    @Test
    public void testIsStrikeLethal() {
        Assert.assertTrue(player1.isStrikeLethal(2,0));
    }

    @Test
    public void testIsStrikeMissing() {
        Assert.assertFalse(player1.isStrikeMissing(0,0));
        Assert.assertTrue(player1.isStrikeMissing(1,1));
    }

    @Test
    public void testShoot() {
        player1.shoot(0,0);
        Assert.assertTrue(player2.mainField.isCellOfState(0,0, FieldCellState.SHIP_CELL_DEAD));
    }



}
