package seabattle.field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import seabattle.enums.Direction;
import seabattle.shipPlacement.ShipPlacingParams;

public class CellTest {

    Field field = new Field(10, 10);

    @Before
    public void before() {
        field.placeShip(new ShipPlacingParams("a1", 4));
        field.applyHit(0, 3);
        field.applyMiss(0,4);
    }

    @Test
    public void testIsLegalToStartShipHere() {
        Cell cell = field.getCellField()[3][2];
        Assert.assertTrue(cell.isLegalToStartShipHere(Direction.RIGHT, 4));
        Assert.assertTrue(cell.isLegalToStartShipHere(Direction.DOWN, 4));
        Assert.assertFalse(cell.isLegalToStartShipHere(Direction.LEFT, 4));
        Assert.assertFalse(cell.isLegalToStartShipHere(Direction.UP, 4));
    }

    @Test
    public void testIsPartOfDeadShip() {
        Cell cell1 = field.getCellField()[0][0];
        Cell cell2 = field.getCellField()[4][4];

        field.applyHit(4,4);
        field.applyHit(4,5);

        Assert.assertFalse(cell1.isPartOfDeadShip());
        Assert.assertTrue(cell2.isPartOfDeadShip());
    }

}
