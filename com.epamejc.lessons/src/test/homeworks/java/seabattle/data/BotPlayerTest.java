package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import org.junit.Assert;
import org.junit.Test;

public class BotPlayerTest {

    @Test
    public void testShoot() {

        Player player1 = new BotPlayer(new AI());
        Player player2 = new BotPlayer(new AI());
        player2.arrangeShips();
        GameState actual;

        do {
            actual = player1.shoot(player2);
        } while (!actual.equals(GameState.GAME_OVER));

        Assert.assertEquals(0, player2.getField().getShips().size());

    }

}
