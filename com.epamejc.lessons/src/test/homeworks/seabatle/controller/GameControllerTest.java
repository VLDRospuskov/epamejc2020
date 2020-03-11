package homeworks.seabatle.controller;

import homeworks.seabatle.servises.locationservice.LocationService;
import homeworks.seabatle.servises.locationservice.LocationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {

    GameController controller;

    @Before
    public void setUp() throws Exception {
        controller = new GameController();
    }

    @Test
    public void chooseRegime() {
        BufferedReader reader = getReader("singleplayer");
        String expected = "You chose singleplayer mode";
        String actual;
        try {
            actual = controller.chooseMode(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void choose2Regime() {
        BufferedReader reader = getReader("multiplayer");
        String expected = "You chose multiplayer mode";
        String actual;
        try {
            actual = controller.chooseMode(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void nameUsers() {
        chooseRegime();
        BufferedReader reader = getReader("Alex");
        String expected = "Hello Alex! Hello Computer!";
        String actual;
        try {
            actual = controller.nameUsers(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void createGameBoard() {
        chooseRegime();
        nameUsers();
        String request = "auto";
        BufferedReader reader = getReader(request);
        String expected = "Game Board is created!";
        String actual;
        try {
            actual = controller.createGameBoard(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void printBattleField() {
        chooseRegime();
        nameUsers();
        createGameBoard();
        String battleField = controller.printBattleField();
        assertEquals(562, battleField.length());
    }


    @Test
    public void runBattle() {
        chooseRegime();
        nameUsers();
        createGameBoard();
        printBattleField();
        LocationService service = new LocationServiceImpl();
        String request = IntStream
                .range(0, 100)
                .mapToObj(i -> service.translateRequest(i) + "\n")
                .collect(Collectors.joining());
        BufferedReader reader = getReader(request);
        String expected = "is a winner!!! Congratulations, admiral!";
        String actual;
        try {
            actual = controller.runBattle(reader, 0);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testManualShipBuild() {
        String request = "manual\nA1 A4\nF2 H2\nJ7 J9\nG10 I10\nA9 B9\nC1 C2\nF7 F8\nA5 A6\nH10\nA6\nI5\nD9";
        chooseRegime();
        nameUsers();
        System.out.println(request);
        BufferedReader reader = getReader(request);
        String expected = "Game Board is created!";
        String actual;
        try {
            actual = controller.createGameBoard(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(expected, actual);
    }

    private BufferedReader getReader(String request) {
        StringReader reader = new StringReader(request);
        return new BufferedReader(reader);
    }
}