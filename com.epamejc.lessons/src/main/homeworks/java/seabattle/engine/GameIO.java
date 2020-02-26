package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.data.Player;
import homeworks.java.seabattle.enums.Ships;
import homeworks.java.utils.UserInputReader;

import static homeworks.java.seabattle.data.Field.deckSize;

public class GameIO {

    private static final String REGEX = "^[a-zA-Z]\\d+$";
    private static final String SPLIT_REGEX = "(?<=[a-zA-Z])(?=\\d)";
    private static final String WRONG_INPUT = "Wrong input, please try again!";

    public static void printGame(Player firstPlayer, Player secondPlayer) {
        System.out.println(printName(firstPlayer.getName()) + "\t" + printName(secondPlayer.getName()) + "\n");
        System.out.println(shipsRemains(firstPlayer, secondPlayer));
        System.out.println(printHead() + "\t" + printHead());

        for (int i = 0; i < deckSize; i++) {
            System.out.println((char) (65 + i) + "\t" +
                    firstPlayer.getField().printLine(i, firstPlayer.isVisible()) + "\t" +
                    (char) (65 + i) + "\t" +
                    secondPlayer.getField().printLine(i, secondPlayer.isVisible()));
        }

    }

    public static Cell inputCoordinates() {

        boolean isOK = false;
        String input;
        Cell cell = null;
        while (!isOK) {
            input = UserInputReader.readInput();
            if (input.length() != 0 && input.matches(REGEX)) {
                String[] split = input.split(SPLIT_REGEX);
                cell = new Cell(Character.toLowerCase(split[0].charAt(0)) - 96, Integer.valueOf(split[1]));
                isOK = checkCell(cell);

            }
            if (!isOK) {
                System.out.println(WRONG_INPUT);
            }
        }
        return cell;
    }

    private static boolean checkCell(Cell cell) {

        return (cell.getCoordY() <= deckSize && cell.getCoordX() <= deckSize);

    }

    private static String printName(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deckSize; i++) {
            if (i == deckSize / 2) {
                stringBuilder.append(name);
            }
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    private static String printHead() {

        StringBuilder stringBuilder = new StringBuilder("\t");
        for (int i = 1; i <= deckSize; i++) {
            stringBuilder.append(i).append("\t");
        }
        return stringBuilder.toString();

    }

    private static String shipTypeRamains(Ships type, Player player) {

        StringBuilder stringBuilder = new StringBuilder();
        long count = player.getField().getShips().stream()
                .filter(ship -> ship.getType().equals(type))
                .count();
        return stringBuilder.append(type.getName()).append("s remains").append(":\t").append(count).toString();

    }

    private static String shipsRemains(Player firstPlayer, Player secondPlayer) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Ships ship : Ships.values()) {
            stringBuilder.append(shipTypeRamains(ship, firstPlayer));
            for (int i = 0; i < deckSize - 3; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append(shipTypeRamains(ship, secondPlayer)).append("\n");
        }
        return stringBuilder.toString();

    }
}
