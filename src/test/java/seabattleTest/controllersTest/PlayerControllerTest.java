package seabattleTest.controllersTest;

import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import homeworks.seabattle.util.Ship;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerControllerTest {

    Controller player = new PlayerController();

    @Before
    public void setupReader() {

        ConsoleReader.reader = new Mock(new InputStreamReader(System.in), 10);

        List<Integer> shipPositions = Stream.iterate(24, x -> x + 10)
                .limit(4)
                .collect(Collectors.toList());

        Positions.opponentShips.add(new Ship(shipPositions));
        Positions.opponentShipPositions.addAll(shipPositions);
    }

    @After
    public void cleanUp() {
        Positions.opponentDeadShipPositions.clear();
        Positions.playerMissPositions.clear();
        Positions.opponentShipPositions.clear();
        Positions.opponentShips.clear();
        Positions.playerHitPositions.clear();
    }

    @Test
    public void playerMissTest() {

        player.makeMove();

        int expectedMissSize = 1;
        int actualMissSize = Positions.playerMissPositions.size();

        Assert.assertEquals(expectedMissSize, actualMissSize);
    }

    @Test
    public void playerHitAndKillTest() {

        player.makeMove();
        player.makeMove();

        int expectedDeadCellsSize = 4;
        int actualDeadCellsSize = Positions.opponentDeadShipPositions.size();

        Assert.assertEquals(expectedDeadCellsSize, actualDeadCellsSize);
    }

    @Test
    public void playerHitAndKillWithExitTest() {

        List<Integer> anotherShip = Stream.iterate(20, x -> x + 10)
                .limit(4)
                .collect(Collectors.toList());

        Positions.opponentShips.add(new Ship(anotherShip));
        Positions.opponentShipPositions.addAll(anotherShip);

        player.makeMove();
        player.makeMove();

        int expectedDeadCellsSize = 0;
        int actualDeadCellsSize = Positions.opponentDeadShipPositions.size();

        Assert.assertEquals(expectedDeadCellsSize, actualDeadCellsSize);
    }


    static class Mock extends BufferedReader {

        int count = -1;

        public Mock(Reader in, int sz) {
            super(in, sz);
        }

        @Override
        public String readLine() {

            String hit1Good = "e3";
            String hit2Good = "e4";
            String hit3Bad = "e4";
            String hit4Good = "e5";
            String miss5Good = "a10";
            String miss6Bad = "a10";
            String hit7Good = "e6";

            count++;

            switch (count) {
                case 0:
                    return hit1Good;
                case 1:
                    return hit2Good;
                case 2:
                    return hit3Bad;
                case 3:
                    return hit4Good;
                case 4:
                    return miss5Good;
                case 5:
                    return miss6Bad;
                case 6:
                    return hit7Good;
                case 7:
                    return "dfg";
                default:
                    return "exit";
            }
        }
    }
}
