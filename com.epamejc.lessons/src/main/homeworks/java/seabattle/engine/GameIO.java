package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Player;
import homeworks.java.seabattle.data.enums.Ships;
import homeworks.java.utils.UserInputReader;

import java.util.List;

/**
 * This class handles all game IO problems, including player inputs, the input parsing, all game outputs.
 */
public class GameIO {

    private int DECK_SIZE = new Settings().getDeckSize();
    private final String REGEX = "^[a-zA-Z]\\d+$";
    private final String WRONG_INPUT = "Wrong input, please try again!";

    public void printGame(List<Player> players) {
        System.out.println("\n\n\n");
        System.out.println(printName(players.get(0).getName()) + "\t" + printName(players.get(1).getName()) + "\n");
        System.out.println(shipsRemains(players));
        System.out.println(printHead() + "\t" + printHead());

        for (int i = 0; i < DECK_SIZE; i++) {
            System.out.println((char) (65 + i) + "\t" +
                    players.get(0).getField().printLine(i, players.get(0).isVisible()) + "\t" +
                    (char) (65 + i) + "\t" +
                    players.get(1).getField().printLine(i, players.get(1).isVisible()));
        }

    }

    public String getParsedInput() {

        System.out.print("Enter coords to shoot: ");
        boolean isOK = false;
        String input = "";
        while (!isOK) {
            input = UserInputReader.readInput().toLowerCase();
            if (input.length() != 0 && input.matches(REGEX)) {
                isOK = true;
            } else {
                System.out.println(WRONG_INPUT);
            }
        }
        System.out.println();
        return input;

    }

    public String getInput() {

        return UserInputReader.readInput();

    }

    public void print(String message) {

        System.out.println(message);

    }

    public String nameInput() {

        System.out.println("Enter Your name, or press \"Enter\" to generate it randomly: ");
        return UserInputReader.readInput();

    }

    private String printName(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (int i = 0; i <= DECK_SIZE - name.length() / 4; i++) {
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    private String printHead() {

        StringBuilder stringBuilder = new StringBuilder("\t");
        for (int i = 1; i <= DECK_SIZE; i++) {
            stringBuilder.append(i).append("\t");
        }
        return stringBuilder.toString();

    }

    private String shipTypeRamains(Ships type, Player player) {

        StringBuilder stringBuilder = new StringBuilder();
        long count = player.getField().getShips().stream()
                .filter(ship -> ship.getType().equals(type))
                .count();
        return stringBuilder.append(type.getName()).append("s remains: ").append(count).toString();

    }

    private String shipsRemains(List<Player> players) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Ships ship : Ships.values()) {
            String message = shipTypeRamains(ship, players.get(0));
            stringBuilder.append(message);
            for (int i = 0; i <= DECK_SIZE - message.length() / 4 + 1; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append(shipTypeRamains(ship, players.get(1))).append("\n");
        }
        return stringBuilder.toString();

    }

}
