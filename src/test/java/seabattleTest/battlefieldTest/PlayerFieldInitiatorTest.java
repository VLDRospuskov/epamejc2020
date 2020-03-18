package seabattleTest.battlefieldTest;

import homeworks.seabattle.initiator.FieldInitiator;
import homeworks.seabattle.initiator.PlayerFieldInitiator;
import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class PlayerFieldInitiatorTest {

    FieldInitiator initiator;

    @Before
    public void getMock () {
        ConsoleReader.reader = new Mock(new InputStreamReader(System.in), 10);
        initiator = new PlayerFieldInitiator();
    }

    @After
    public void reset () {
        Positions.playerShipPositions.clear();
        Positions.playerShips.clear();
    }

    @Test
    public void shipAmountTest () {

        initiator.init();

        int expectedAmountOfShips = 3;
        int actualAmountOfShips = Positions.playerShips.size();

        Assert.assertEquals(expectedAmountOfShips, actualAmountOfShips);
    }

    @Test
    public void cellAmountTest () {

        initiator.init();

        int expectedAmountOfCells = 7;
        int actualAmountOfCells = Positions.playerShipPositions.size();

        Assert.assertEquals(expectedAmountOfCells, actualAmountOfCells);
    }


    static class Mock extends BufferedReader {

        int count = -1;

        public Mock(Reader in, int sz) {
            super(in, sz);
        }

        @Override
        public String readLine () {

            String ship1Good = "A1 B1 C1 D1";
            String ship2Bad = "E3 F3 G3 H3";
            String ship3Bad = "A2 A3";
            String ship4Good = "F2 F3";
            String ship5Bad = "H1 Y2 J3";
            String ship6Bad = "ghj";
            String ship7Bad = "";
            String ship8Good = "j10";
            String ship9Bad = "";

            count++;

            switch (count) {
                case 0: return ship1Good;
                case 1: return ship2Bad;
                case 2: return ship3Bad;
                case 3: return ship4Good;
                case 4: return ship5Bad;
                case 5: return ship6Bad;
                case 6: return ship7Bad;
                case 7: return ship8Good;
                case 8: return ship9Bad;
                default: return "exit";
            }
        }
    }
}
