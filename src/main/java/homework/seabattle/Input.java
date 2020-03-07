package homework.seabattle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework.seabattle.Strings.*;

public class Input {

    private static Map<String, Ship.Type> shipTypes;
    private static Map<Integer, String> enterShipMessages;

    static {
        shipTypes = new HashMap<>();
        shipTypes.put("h", Ship.Type.HORIZONTAL);
        shipTypes.put("v", Ship.Type.VERTICAL);

        enterShipMessages = new HashMap<>();
        enterShipMessages.put(1, ENTER_ONE_DECK);
        enterShipMessages.put(2, ENTER_TWO_DECKS);
        enterShipMessages.put(3, ENTER_THREE_DECKS);
        enterShipMessages.put(4, ENTER_FOUR_DECKS);
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
        String inputString = "";
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

    public static void enterShip(ShipsField shipsField, int length) {
        System.out.println(enterShipMessages.get(length));

        Ship ship = null;
        Coordinate coordinate = null;
        Ship.Type type = null;

        boolean isShipEntered = false;
        while (!isShipEntered) {
            coordinate = Input.enterCoordinate();

            if (length == 1) {
                ship = Ship.createOneDeckShip(coordinate);
            } else {
                type = Input.enterShipType();
                ship = Ship.create(type, coordinate, length);
            }

            try {
                shipsField.tryAddShip(ship);
                isShipEntered = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
