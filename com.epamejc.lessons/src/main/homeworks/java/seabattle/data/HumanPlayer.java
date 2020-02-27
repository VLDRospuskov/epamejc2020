package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameStats;
import homeworks.java.seabattle.engine.GameIO;
import homeworks.java.seabattle.utils.RandomNameGenerator;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {

        super();
        generateName(name);
        this.setVisible(true);

    }

    @Override
    public GameStats shoot(Player enemy) {

        moves++;
        return enemy.getField().hit(GameIO.inputCoordinates());

    }

    private void generateName(String input) {

        if (input.equals("")) {
            this.setName(RandomNameGenerator.generateName());
        } else {
            this.setName("admiral " + input);
        }

    }

}
