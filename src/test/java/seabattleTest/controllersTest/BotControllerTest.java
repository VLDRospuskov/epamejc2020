package seabattleTest.controllersTest;

import homeworks.seabattle.controllers.BotController;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.util.Positions;
import homeworks.seabattle.util.Ship;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BotControllerTest {

    Controller bot;

    @Before
    public void restart() {
        bot = new BotController();
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
    public void botMissTest() {
        bot.makeMove();

        int expectedMissSize = 1;
        int actualMissSize = Positions.playerMissPositions.size();

        Assert.assertEquals(expectedMissSize, actualMissSize);
    }

    @Test
    public void botHitAndKillTest() {

        List<Integer> shipPositions1 = Stream.iterate(20, x -> x + 1)
                .limit(10)
                .collect(Collectors.toList());

        List<Integer> shipPositions2 = Stream.iterate(0, x -> x + 1)
                .limit(10)
                .collect(Collectors.toList());

        List<Integer> shipPositions3 = Stream.iterate(40, x -> x + 10)
                .limit(6)
                .collect(Collectors.toList());

        Positions.opponentShips.add(new Ship(shipPositions1));
        Positions.opponentShips.add(new Ship(shipPositions2));
        Positions.opponentShips.add(new Ship(shipPositions3));

        Positions.opponentShipPositions.addAll(shipPositions1);
        Positions.opponentShipPositions.addAll(shipPositions2);
        Positions.opponentShipPositions.addAll(shipPositions3);

        while (Positions.opponentDeadShipPositions.size() < Positions.opponentShipPositions.size()) {
            bot.makeMove();
        }

        int expectedDeadCellsSize = 26;
        int actualDeadCellsSize = Positions.opponentDeadShipPositions.size();

        Assert.assertEquals(expectedDeadCellsSize, actualDeadCellsSize);
    }
}
