package homework.seabattle.utils;

import homework.seabattle.actors.Player;
import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ships.Ship;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework.seabattle.config.Strings.*;

public class Input {

    private final static Map<String, Ship.Type> shipTypes;
    private final static Map<String, Player.Type> playersTypes;

    static {
        shipTypes = new HashMap<>();
        shipTypes.put("h", Ship.Type.HORIZONTAL);
        shipTypes.put("v", Ship.Type.VERTICAL);

        playersTypes = new HashMap<>();
        playersTypes.put("c", Player.Type.COMPUTER);
        playersTypes.put("h", Player.Type.HUMAN);
    }

    public static Player.Type enterPlayerType() {
        System.out.println(ENTER_PLAYER_TYPE);

        Scanner scanner = new Scanner(System.in);
        String inputString;
        Player.Type type = null;
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

    public static Ship.Type enterShipType() {
        System.out.println(ENTER_COURSE);

        Scanner scanner = new Scanner(System.in);
        String inputString;
        Ship.Type type = null;
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
