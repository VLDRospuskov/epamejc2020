package homeworks.java.seabattle.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class FieldTest {

    @Test
    public void testArrangeShipsRandom() {

        Player player = new BotPlayer(new AI());
        player.arrangeShips();
        long actual = player.getField().getShips().stream()
                .filter(s -> s.getStartPoint() != null)
                .count();

        Assert.assertEquals(10, actual);

    }

}
