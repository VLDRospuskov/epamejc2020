package homeworks.seabatle.model.board;

import homeworks.seabatle.exception.IncorrectShootRequestException;
import homeworks.seabatle.model.players.Player;
import homeworks.seabatle.model.players.User;
import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.factories.ShipAutoGenerator;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {
    private GameBoard board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new User();
        player2 = new User();

        ShipsRepository repository1 = new ShipAutoGenerator().getGeneratedRepository();
        Field field1 = new Field(repository1);

        ShipsRepository repository2 = new ShipAutoGenerator().getGeneratedRepository();
        Field field2 = new Field(repository2);

        player1.setField(field1);
        player2.setField(field2);

        board = new GameBoard(player1, player2);

    }

    @Test
    public void testGetPlayerStrikeResult() {


        StrikeResult result = board.getPlayerStrikeResult(12, player1);
        String StringResult1 = result.toString();
        StrikeResult result2 = board.getPlayerStrikeResult(13, player1);
        String StringResult2 = result2.toString();
        StrikeResult.valueOf(StringResult1);
        StrikeResult.valueOf(StringResult2);
    }

    @Test
    public void testGetPlayerStrikeResult1() {
        StrikeResult result = board.getPlayerStrikeResult("A2", player1);
        String StringResult1 = result.toString();
        StrikeResult result2 = board.getPlayerStrikeResult("E7", player1);
        String StringResult2 = result2.toString();
        StrikeResult.valueOf(StringResult1);
        StrikeResult.valueOf(StringResult2);
    }

    @Test(expected = IncorrectShootRequestException.class)
    public void testGetFakePlayerStrikeResult1() {
        StrikeResult result = board.getPlayerStrikeResult("A2222", player1);

    }

    @Test
    public void printBatlefield() {
        board.printBattlefield();
    }
}