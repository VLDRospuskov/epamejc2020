package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManualShipPlacerTest {

    /**
     * Testing {@link ManualShipPlacer#checkEnteredCoordinates(Ship, int[])}
     */
    @Test
    public void testCheckEnteredCoordinates() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        ManualShipPlacer manualShipPlacer = new ManualShipPlacer(testFieldOperations);
        Ship singleDeckShip1 = generateShip(2, 2, Directions.UP.getDirection(), 1);
        Ship singleDeckShip2 = generateShip(6, 2, Directions.UP.getDirection(), 1);
        Ship singleDeckShip3 = generateShip(4, 4, Directions.UP.getDirection(), 1);
        testFieldOperations.getCellByCoords(2, 2).setCellShip(singleDeckShip1);
        testFieldOperations.getCellByCoords(6, 2).setCellShip(singleDeckShip2);
        testFieldOperations.getCellByCoords(4, 4).setCellShip(singleDeckShip3);
        Ship testPlacementShip1 = generateShip(4, 1, Directions.DOWN.getDirection(), 2);
        int[] testCoordinates1 = {4,1};
        boolean actualResult1 = manualShipPlacer.checkEnteredCoordinates(testPlacementShip1, testCoordinates1);
        Ship testPlacementShip2 = generateShip(4, 1, Directions.DOWN.getDirection(), 3);
        boolean actualResult2 = manualShipPlacer.checkEnteredCoordinates(testPlacementShip2, testCoordinates1);
        Assert.assertTrue(actualResult1);
        Assert.assertFalse(actualResult2);
    }

    /**
     * Testing {@link ManualShipPlacer#checkPotentialDirection(Ship, String)}
     */
    @Test
    public void testCheckPotentialDirection() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        ManualShipPlacer manualShipPlacer = new ManualShipPlacer(testFieldOperations);
        Ship singleDeckShip1 = generateShip(2, 2, Directions.UP.getDirection(), 1);
        Ship singleDeckShip2 = generateShip(6, 2, Directions.UP.getDirection(), 1);
        Ship singleDeckShip3 = generateShip(4, 4, Directions.UP.getDirection(), 1);
        testFieldOperations.getCellByCoords(2, 2).setCellShip(singleDeckShip1);
        testFieldOperations.getCellByCoords(6, 2).setCellShip(singleDeckShip2);
        testFieldOperations.getCellByCoords(4, 4).setCellShip(singleDeckShip3);
        String testDirection1 = Directions.DOWN.getDirection();
        String testDirection2 = Directions.LEFT.getDirection();
        Ship testShip1 = generateShip(4, 1, "", 2);
        Ship testShip2 = generateShip(4, 1, "", 4);
        boolean actualResult1 = manualShipPlacer.checkPotentialDirection(testShip1, testDirection1);
        boolean actualResult2 = manualShipPlacer.checkPotentialDirection(testShip2, testDirection1);
        boolean actualResult3 = manualShipPlacer.checkPotentialDirection(testShip1, testDirection2);
        Assert.assertTrue(actualResult1);
        Assert.assertFalse(actualResult2);
        Assert.assertFalse(actualResult3);
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