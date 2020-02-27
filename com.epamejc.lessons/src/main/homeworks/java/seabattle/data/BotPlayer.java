package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameStats;
import homeworks.java.seabattle.engine.AI;
import homeworks.java.seabattle.utils.RandomNameGenerator;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class BotPlayer extends Player {

    private AI ai;

    public BotPlayer() {

        super();
        ai = new AI();
        this.setName(RandomNameGenerator.generateName());

    }

    @Override
    @SneakyThrows
    public GameStats shoot(Player enemy) {

        TimeUnit.MILLISECONDS.sleep(500);
        moves++;
        GameStats gameStats = enemy.getField().hit(ai.shoot());
        ai.exclude(enemy.getField().getDeck());
        //add finish off the ship method if hit
        return gameStats;

    }

}
