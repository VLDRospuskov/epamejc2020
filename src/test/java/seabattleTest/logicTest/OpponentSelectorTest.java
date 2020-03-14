package seabattleTest.logicTest;

import homeworks.seabattle.logic.OpponentSelector;
import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class OpponentSelectorTest {

    OpponentSelector selector = new OpponentSelector();

    @Before
    public void setupReader() {
        ConsoleReader.reader = new Mock(new InputStreamReader(System.in), 10);
    }

    @After
    public void cleanUp() {
        Positions.playerShips.clear();
        Positions.playerShipPositions.clear();
    }

    @Test
    public void getBotControllerTest() {

        Mock.count = -1;

        String expected = "class homeworks.seabattle.controllers.BotController";
        String actual = selector.select().getClass().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerControllerTest() {

        Mock.count = 1;

        String expected = "class homeworks.seabattle.controllers.PlayerController";
        String actual = selector.select().getClass().toString();

        Assert.assertEquals(expected, actual);
    }

    static class Mock extends BufferedReader {

        static int count;

        public Mock(Reader in, int sz) {
            super(in, sz);
        }

        @Override
        public String readLine() {

            String badInput1 = "sscryauu";
            String botInput2 = "bot";
            String playerInput3 = "player";
            String exit = "exit";

            count++;

            switch (count) {
                case 0:
                    return badInput1;
                case 1:
                    return botInput2;
                case 2:
                    return playerInput3;
                default:
                    return exit;
            }
        }
    }
}
