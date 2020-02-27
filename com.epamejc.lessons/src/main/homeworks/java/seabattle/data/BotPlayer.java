package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.engine.AI;
import homeworks.java.seabattle.utils.RandomNameGenerator;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class BotPlayer extends Player {

    private GameState lastState;

    private AI ai;

    public BotPlayer() {

        super();
        ai = new AI();
        this.setName(RandomNameGenerator.generateName());

    }

    @Override
    @SneakyThrows
    public GameState shoot(Player enemy) {

        TimeUnit.MILLISECONDS.sleep(500);
        moves++;
        if (lastState.equals(GameState.HIT)) {
            enemy.getField().hit(ai.finishOff());
        } else {
            lastState = enemy.getField().hit(ai.shoot());
        }
        ai.exclude(enemy.getField().getDeck());
        //add finish off the ship method if hit
        return lastState;

    }

}
