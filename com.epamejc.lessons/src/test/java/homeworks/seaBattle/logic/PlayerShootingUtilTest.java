package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.Assert;
import org.junit.Test;

public class PlayerShootingUtilTest {

    /**
     * Testing {@link PlayerShootingUtil#shot(int[])}
     */
    @Test
    public void testShot() {
        Player botPlayer = new Player();
        PlayerShootingUtil playerShootingUtil = new PlayerShootingUtil(botPlayer);
        int[] shotCoordinates1 = {1, 1};
        int[] shotCoordinates2 = {3, 3};
        boolean shot1 = playerShootingUtil.shot(shotCoordinates1);
        Ship testShip1 = generateShip(3,3, Directions.DOWN.getDirection(), 1);
        Cell cell2 =  botPlayer.fieldOperations().getCellByCoords(3,3);
        cell2.setCellShip(testShip1);
        boolean shot2 = playerShootingUtil.shot(shotCoordinates2);
        Assert.assertFalse(shot1);
        Assert.assertTrue(shot2);
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