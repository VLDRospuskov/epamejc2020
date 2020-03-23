package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.utils.RandomNameGenerator;

public class BotPlayer extends Player {

    private AI ai;

    public BotPlayer(AI ai) {

        super();
        this. ai = ai;
        this.setName(RandomNameGenerator.generateName());

    }

    @Override
    public GameState shoot(Player enemy) {

        moves++;
        return ai.shoot(enemy);

    }

}
