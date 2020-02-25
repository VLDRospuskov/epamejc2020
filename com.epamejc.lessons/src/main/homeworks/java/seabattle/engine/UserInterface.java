package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.data.Field;
import homeworks.java.seabattle.data.Player;
import homeworks.java.utils.UserInputReader;

public class UserInterface {

    private String REGEX = "^[a-z]\\d+$";
    private String SPLIT_REGEX = "(?=\\d)";

    public void printGame(Player player1, Player player2) {

        System.out.println(player1.getField().printPlayerName(player1.getName()) +
                "\t" + player2.getField().printPlayerName(player2.getName()));
        System.out.println(player1.getField().printHead() + "\t" +
                player2.getField().printHead());
        for (int i = 0; i < Field.deckSize; i++) {
            System.out.println((char) (65 + i) + "  " +
                    player1.getField().printLine(i) + "\t" +
                    (char) (65 + i) + "  " +
                    player2.getField().printLine(i));
        }

    }

    public Cell userInput() {

        String input;
        int coordX = -1,
                coordY = -1;

        while (coordX > Field.deckSize || coordY > Field.deckSize || coordX < 0 || coordY < 0) {
            input = UserInputReader.readInput();
            if (input.length() != 0 && input.matches(REGEX)) {
                String[] split = input.split(SPLIT_REGEX);

                coordX = Character.toLowerCase(split[0].charAt(0)) - 96;
                coordY = Integer.valueOf(split[1]);
            } else {
                System.out.println("Wrong input");
            }
        }
        return new Cell(coordX, coordY);

    }

}
