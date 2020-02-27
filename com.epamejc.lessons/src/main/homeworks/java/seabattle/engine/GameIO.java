package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.data.HumanPlayer;
import homeworks.java.seabattle.data.Player;
import homeworks.java.seabattle.data.enums.Ships;
import homeworks.java.utils.UserInputReader;

import java.util.List;

import static homeworks.java.seabattle.data.Field.deckSize;

public class GameIO {

    private static final String REGEX = "^[a-zA-Z]\\d+$";
    private static final String SPLIT_REGEX = "(?<=[a-zA-Z])(?=\\d)";
    private static final String WRONG_INPUT = "Wrong input, please try again!";
    private static int count = 1;

    public static void printGame(List<Player> players) {
        System.out.println(printName(players.get(0).getName()) + "\t" + printName(players.get(1).getName()) + "\n");
        System.out.println(shipsRemains(players));
        System.out.println(printHead() + "\t" + printHead());

        for (int i = 0; i < deckSize; i++) {
            System.out.println((char) (65 + i) + "\t" +
                    players.get(0).getField().printLine(i, players.get(0).isVisible()) + "\t" +
                    (char) (65 + i) + "\t" +
                    players.get(1).getField().printLine(i, players.get(1).isVisible()));
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

    public static String getInput () {

        return UserInputReader.readInput();

    }

    public static void print(String message) {

        System.out.println(message);

    }

    public static String nameInput() {

        System.out.println("Enter Your name, or press \"Enter\" to generate it randomly: ");
        return UserInputReader.readInput();

    }

    private static boolean checkCell(Cell cell) {

        return (cell.getCoordY() <= deckSize && cell.getCoordX() <= deckSize);

    }

    private static String printName(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (int i = 0; i <= deckSize - name.length() / 4; i++) {
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
        return stringBuilder.append(type.getName()).append("s remains: ").append(count).toString();

    }

    private static String shipsRemains(List<Player> players) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Ships ship : Ships.values()) {
            String message = shipTypeRamains(ship, players.get(0));
            stringBuilder.append(message);
            for (int i = 0; i <= deckSize - message.length() / 4 + 1; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append(shipTypeRamains(ship, players.get(1))).append("\n");
        }
        return stringBuilder.toString();

    }
}
