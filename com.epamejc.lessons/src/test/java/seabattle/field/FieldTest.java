package seabattle.field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import seabattle.enums.FieldCellState;
import seabattle.shipPlacement.ShipPlacingParams;

public class FieldTest {

    Field field = new Field(10, 10);

    @Before
    public void before() {
        field.placeShip(new ShipPlacingParams("a1", 4));
        field.applyHit(0, 3);
        field.applyMiss(0,4);
    }

    @Test
    public void testIsCellState() {
        Assert.assertTrue(field.isCellOfState(0,2,FieldCellState.SHIP_CELL_ALIVE));
        Assert.assertTrue(field.isCellOfState(0,3,FieldCellState.SHIP_CELL_DEAD));
        Assert.assertTrue(field.isCellOfState(0,4,FieldCellState.EMPTY_CELL_STRICKEN));
        Assert.assertTrue(field.isCellOfState(0,5,FieldCellState.EMPTY_CELL));
    }

    @Test
    public void testIsShipPlacementLegal() {
        ShipPlacingParams shipPlacingParamsIncorrect1 = new ShipPlacingParams("a3 up", 2);
        ShipPlacingParams shipPlacingParamsIncorrect2 = new ShipPlacingParams("a8 down", 4);
        ShipPlacingParams shipPlacingParamsCorrect = new ShipPlacingParams("b3 right", 2);

        Assert.assertFalse(field.isShipPlacementLegal(shipPlacingParamsIncorrect1));
        Assert.assertFalse(field.isShipPlacementLegal(shipPlacingParamsIncorrect2));
        Assert.assertTrue(field.isShipPlacementLegal(shipPlacingParamsCorrect));
    }

    @Test
    public void testPlaceShip() {
        ShipPlacingParams shipPlacingParams = new ShipPlacingParams("b3 right", 2);

        field.placeShip(shipPlacingParams);

        Assert.assertTrue(field.isCellOfState(2,1,FieldCellState.SHIP_CELL_ALIVE));
        Assert.assertTrue(field.isCellOfState(2,2,FieldCellState.SHIP_CELL_ALIVE));
        Assert.assertTrue(field.isCellOfState(2,3,FieldCellState.EMPTY_CELL));
    }



}
