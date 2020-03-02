package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomaticShipPlacerTest {

    /**
     * Testing {@link AutomaticShipPlacer#checkRadius(String, int, int, int)}
     */
    @Test
    public void testCheckRadius() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        AutomaticShipPlacer automaticShipPlacer = new AutomaticShipPlacer(testFieldOperations);
        Ship singleDeckShip = generateShip(2, 2, Directions.UP.getDirection(), 1);
        testFieldOperations.getCellByCoords(2, 2).setCellShip(singleDeckShip);
        boolean actualResult1 = automaticShipPlacer.checkRadius(Directions.DOWN.getDirection(),
                4, 2, 2);
        boolean actualResult2 = automaticShipPlacer.checkRadius(Directions.RIGHT.getDirection(),
                4, 2, 2);
        boolean actualResult3 = automaticShipPlacer.checkRadius(Directions.UP.getDirection(),
                4, 2, 2);
        boolean actualResult4 = automaticShipPlacer.checkRadius(Directions.LEFT.getDirection(),
                4, 2, 2);
        Assert.assertTrue(actualResult1);
        Assert.assertTrue(actualResult2);
        Assert.assertTrue(actualResult3);
        Assert.assertFalse(actualResult4);
    }

    /**
     * Method generates {@link Ship} object with specific attributes
     * @param coordX horizontal coordinate value
     * @param coordY vertical coordinate value
     * @param direction direction of ship
     * @param shipDecksNumber number of ship decks
     * @return {@link Ship} object
     */
    private Ship generateShip(int coordX, int coordY, String direction, int shipDecksNumber) {
        Ship testShip = new Ship(ShipType.DESTROYER.getType(), shipDecksNumber);
        testShip.setDirection(direction);
        testShip.setShipCoordX(coordX);
        testShip.setShipCoordY(coordY);
        return testShip;
    }
}