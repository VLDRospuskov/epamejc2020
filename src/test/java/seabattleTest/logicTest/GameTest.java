package seabattleTest.logicTest;

import homeworks.seabattle.logic.Game;
import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class GameTest {

    Game game = new Game();

    @Before
    public void setupReader() {
        ConsoleReader.reader = new Mock(new InputStreamReader(System.in), 10);
    }

    @Test
    public void endGameTest() {

        game.run();

        boolean actual = Positions.opponentDeadShipPositions.size()
                == Positions.opponentShipPositions.size();

        Assert.assertTrue(actual);
    }

    static class Mock extends BufferedReader {

        int count = -1;

        public Mock(Reader in, int sz) {
            super(in, sz);
        }

        @Override
        public String readLine() {

            String player = "player";
            String ship = "a1";
            String exit = "exit";

            count++;

            switch (count) {
                case 0:
                case 3:
                    return player;
                case 1:
                case 4:
                case 6:
                    return ship;
                case 2:
                case 5:
                default:
                    return exit;
            }
        }
    }
}
