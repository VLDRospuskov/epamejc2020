package seabattleTest;

import homeworks.seabattle.battlefield.BotFieldInitiator;
import homeworks.seabattle.battlefield.FieldInitiator;
import homeworks.seabattle.util.Positions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BotFieldInitiatorTest {

    FieldInitiator bot = new BotFieldInitiator();

    @Before
    public void setupBot () {
        bot = new BotFieldInitiator();
    }

    @After
    public void cleanUp () {
        Positions.playerShips.clear();
        Positions.playerShipPositions.clear();
    }

    @Test
    public void amountOfShipsTest () {

        bot.init();

        int expected = 10;
        int actual = Positions.playerShips.size();

        assertEquals(expected, actual);
    }

    @Test
    public void amountOfCellsTest () {

        bot.init();

        int expected = 20;
        int actual = Positions.playerShipPositions.size();

        assertEquals(expected, actual);
    }
}
