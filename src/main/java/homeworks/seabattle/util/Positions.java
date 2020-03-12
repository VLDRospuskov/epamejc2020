package homeworks.seabattle.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Positions {

    public static List<Integer> playerHitPositions = new ArrayList<>();
    public static List<Integer> opponentHitPositions = new ArrayList<>();

    public static List<Integer> playerMissPositions = new ArrayList<>();
    public static List<Integer> opponentMissPositions = new ArrayList<>();

    public static List<Integer> playerShipPositions = new ArrayList<>();
    public static List<Integer> opponentShipPositions = new ArrayList<>();

    public static List<Integer> playerDeadShipPositions = new ArrayList<>();
    public static List<Integer> opponentDeadShipPositions = new ArrayList<>();

    public static List<Ship> playerShips = new ArrayList<>();
    public static List<Ship> opponentShips = new ArrayList<>();

    public static final List<String> allCells = Arrays.asList(
            "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "Y1", "J1",
            "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "Y2", "J2",
            "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3", "Y3", "J3",
            "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4", "Y4", "J4",
            "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "Y5", "J5",
            "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "Y6", "J6",
            "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "Y7", "J7",
            "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8", "Y8", "J8",
            "A9", "B9", "C9", "D9", "E9", "F9", "G9", "H9", "Y9", "J9",
            "A10", "B10", "C10", "D10", "E10", "F10", "G10", "H10", "Y10", "J10");


    public static void swapAndSet () {

        List<Integer> x;

        x = playerHitPositions;
        playerHitPositions = opponentHitPositions;
        opponentHitPositions = x;

        x = playerMissPositions;
        playerMissPositions = opponentMissPositions;
        opponentMissPositions = x;

        x = playerDeadShipPositions;
        playerDeadShipPositions = opponentDeadShipPositions;
        opponentDeadShipPositions = x;

        x = playerShipPositions;
        playerShipPositions = opponentShipPositions;
        opponentShipPositions = x;

        List<Ship> s;
        s = playerShips;
        playerShips = opponentShips;
        opponentShips = s;
    }

}
