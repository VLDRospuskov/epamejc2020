package homework.seabattle.utils;

import homework.seabattle.actors.PlayerType;
import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ships.ShipType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework.seabattle.config.Strings.*;

public class Input {

    private final static Map<String, ShipType.Type> shipTypes;
    private final static Map<String, PlayerType.Type> playersTypes;

    static {
        shipTypes = new HashMap<>();
        shipTypes.put("h", ShipType.Type.HORIZONTAL);
        shipTypes.put("v", ShipType.Type.VERTICAL);

        playersTypes = new HashMap<>();
        playersTypes.put("c", PlayerType.Type.COMPUTER);
        playersTypes.put("h", PlayerType.Type.HUMAN);
    }

    public static PlayerType.Type enterPlayerType() {
        System.out.println(ENTER_PLAYER_TYPE);

        Scanner scanner = new Scanner(System.in);
        String inputString;
        PlayerType.Type type = PlayerType.Type.COMPUTER;
        boolean isEntered = false;

        while (!isEntered) {
            inputString = scanner.nextLine();

            if (inputString.equals("c") || inputString.equals("h")) {
                type = playersTypes.get(inputString);
                isEntered = true;
            } else {
                System.out.println(ENTER_PLAYER_TYPE_ERROR);
            }
        }
        return type;
    }

    public static String enterPlayerName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Coordinate enterCoordinate() {
        Scanner scanner = new Scanner(System.in);
        Coordinate coordinate = null;
        boolean isEntered = false;

        while (!isEntered) {
            String letterNumberStr = scanner.nextLine();
            try {
                coordinate = Coordinate.of(letterNumberStr);
                isEntered = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return coordinate;
    }

    public static ShipType.Type enterShipType() {
        System.out.println(ENTER_COURSE);

        Scanner scanner = new Scanner(System.in);
        String inputString;
        ShipType.Type type = null;
        boolean isEntered = false;

        while (!isEntered) {
            inputString = scanner.nextLine();

            if (inputString.equals("h") || inputString.equals("v")) {
                type = shipTypes.get(inputString);
                isEntered = true;
            } else {
                System.out.println(ENTER_COURSE_ERROR);
            }
        }
        return type;
    }
}
