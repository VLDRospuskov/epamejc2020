package homework.seabattle.actors;

import homework.seabattle.model.CellState;
import homework.seabattle.model.Coordinate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void create() {
        Player player = Player.create(PlayerType.Type.HUMAN);
        assertTrue(player instanceof User);

        player = Player.create(PlayerType.Type.COMPUTER);
        assertTrue(player instanceof Bot);
    }

    @Test
    public void onShotFailed() {
        User user = new User();

        Coordinate coordinate = new Coordinate('a', 1);
        CellState.State state = user.getTacticalSituation().getCellState(coordinate);
        assertEquals(CellState.State.UNCHECKED, state);

        user.onShotFailed(coordinate);
        state = user.getTacticalSituation().getCellState(coordinate);
        assertEquals(CellState.State.EMPTY, state);
    }
}