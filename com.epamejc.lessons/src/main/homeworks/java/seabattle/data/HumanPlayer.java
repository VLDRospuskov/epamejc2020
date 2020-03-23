package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.engine.GameIO;
import homeworks.java.seabattle.utils.RandomNameGenerator;

public class HumanPlayer extends Player {

    private final String REGEX = "(?<=[a-zA-Z])(?=\\d)";
    private GameIO io;

    public HumanPlayer(GameIO io) {

        super();
        generateName(io.nameInput());
        this.setVisible(true);
        this.io = io;

    }

    @Override
    public GameState shoot(Player enemy) {

        moves++;
        String input = io.getParsedInput();
        return enemy.getField().hit(makeCell(input));

    }

    private void generateName(String input) {

        if (input.equals("")) {
            this.setName(RandomNameGenerator.generateName());
        } else {
            this.setName("admiral " + input);
        }

    }

    private Cell makeCell(String input) {

        String[] split = input.split(REGEX);
        return new Cell(split[0].toLowerCase().charAt(0) - 96, Integer.valueOf(split[1]));

    }

}
