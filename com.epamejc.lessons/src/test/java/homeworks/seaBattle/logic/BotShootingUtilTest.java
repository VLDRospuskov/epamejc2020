package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BotShootingUtilTest {

    /**
     * Testing {@link BotShootingUtil#randomShooting(int[])} with first shot (lucky or not)
     */
    @Test
    public void testRandomShooting() {
        Player humanPlayer = new Player();
        BotShootingUtil botShootingUtil = new BotShootingUtil(humanPlayer);
        int[] shotCoordinates1 = {1, 1};
        int[] shotCoordinates2 = {3, 3};
        boolean shot1 = botShootingUtil.randomShooting(shotCoordinates1);
        Ship testShip1 = generateShip(3,3, Directions.DOWN.getDirection(), 1);
        Cell cell2 =  humanPlayer.fieldOperations().getCellByCoords(3,3);
        cell2.setCellShip(testShip1);
        boolean shot2 = botShootingUtil.randomShooting(shotCoordinates2);
        Assert.assertFalse(shot1);
        Assert.assertTrue(shot2);
    }

    /**
     * Testing {@link BotShootingUtil#shot(int[])} with second shot after the first successful hit
     */
    @Test
    public void testShot() {
        Player humanPlayer = new Player();
        BotShootingUtil botShootingUtil = new BotShootingUtil(humanPlayer);
        Ship testShip1 = generateShip(3,8, Directions.LEFT.getDirection(), 2);
        Cell shipCell1 = humanPlayer.fieldOperations().getCellByCoords(3,8);
        Cell shipCell2 = humanPlayer.fieldOperations().getCellByCoords(4,8);
        shipCell1.setCellShip(testShip1);
        shipCell2.setCellShip(testShip1);
        botShootingUtil.setShotCoordinatesTest(new int[] {3,8}, Directions.RIGHT.getDirection());
        boolean shot1 = botShootingUtil.shot(new int[] {1,1});
        botShootingUtil.setShotCoordinatesTest(new int[] {3,8}, Directions.UP.getDirection());
        boolean shot2 = botShootingUtil.shot(new int[] {1,1});
        Assert.assertTrue(shot1);
        Assert.assertFalse(shot2);
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