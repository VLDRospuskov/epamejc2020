package homework.seabattle.actors;

import homework.seabattle.model.CellState;
import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ShipsField;
import org.junit.Before;
import org.junit.Test;

import static homework.seabattle.config.Config.*;
import static org.junit.Assert.assertEquals;

public class BotTest {

    private Bot bot;

    @Before
    public void setup() {
//        bot = new Bot();
    }

    @Test
    public void createShipsLocation() {
        bot = new Bot();

        bot.createShipsLocation();
        ShipsField shipsField = bot.getShipsField();
        assertEquals(INITIAL_SHIPS_COUNT, shipsField.getOwnActiveShips().size());
        assertEquals(MAX_NUMBER * MAX_NUMBER - (4 + THREEDECKS_SHIPS_COUNT * 3
                + TWODECKS_SHIPS_COUNT * 2 + ONEDECK_SHIPS_COUNT * 1), shipsField.getOwnEmptyCoordinates().size());
    }

    @Test
    public void onShotFailed() {
        bot = new Bot();

        Coordinate coordinate = new Coordinate('a', 1);
        CellState.State state = bot.getTacticalSituation().getCellState(coordinate);
        assertEquals(CellState.State.UNCHECKED, state);

        bot.onShotFailed(coordinate);
        state = bot.getTacticalSituation().getCellState(coordinate);
        assertEquals(CellState.State.EMPTY, state);
    }
}