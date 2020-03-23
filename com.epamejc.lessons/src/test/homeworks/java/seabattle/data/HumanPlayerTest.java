package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;
import homeworks.java.seabattle.engine.GameIO;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

public class HumanPlayerTest {

    @Test
    public void testCreatePlayerWithRandomName() {

        GameIO io = Mockito.mock(GameIO.class);
        Mockito.when(io.nameInput()).thenReturn("");
        Player player = new HumanPlayer(io);

        Assert.assertTrue(player.getName().length() > 7);

    }

    @Test
    public void testCreatePlayerWithCustomName() {

        GameIO io = Mockito.mock(GameIO.class);
        Mockito.when(io.nameInput()).thenReturn("d");
        Player player = new HumanPlayer(io);

        Assert.assertTrue(player.getName().length() > 7);

    }

    @Test
    public void testShootHit() {

        GameState expected = GameState.HIT;

        GameIO io = Mockito.mock(GameIO.class);
        Mockito.when(io.getParsedInput()).thenReturn("A1");
        Mockito.when(io.nameInput()).thenReturn("d");
        Field field = new Field();
        placeShipManually(field, new Ship(Ships.CRUISER, 4), new Cell(1, 1),
                new Cell(1, 0));
        Player player1 = new HumanPlayer(io);
        Player player2 = new HumanPlayer(io);
        player2.setField(field);
        GameState actual = player1.shoot(player2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testShootMiss() {

        GameState expected = GameState.MISS;

        GameIO io = Mockito.mock(GameIO.class);
        Mockito.when(io.getParsedInput()).thenReturn("A2");
        Mockito.when(io.nameInput()).thenReturn("d");
        Field field = new Field();
        placeShipManually(field, new Ship(Ships.CRUISER, 4), new Cell(1, 1),
                new Cell(1, 0));
        Player player1 = new HumanPlayer(io);
        Player player2 = new HumanPlayer(io);
        player2.setField(field);
        GameState actual = player1.shoot(player2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testShootDestroyed() {

        GameState expected = GameState.DESTROYED;

        GameIO io = Mockito.mock(GameIO.class);
        Mockito.when(io.getParsedInput()).thenReturn("A1");
        Mockito.when(io.nameInput()).thenReturn("d");
        Field field = new Field();
        placeShipManually(field, new Ship(Ships.BOAT, 1), new Cell(1, 1),
                new Cell(1, 0));
        Player player1 = new HumanPlayer(io);
        Player player2 = new HumanPlayer(io);
        player2.setField(field);
        GameState actual = player1.shoot(player2);

        Assert.assertEquals(expected, actual);

    }

    @SneakyThrows
    private void placeShipManually(Field field, Ship ship, Cell startPoint, Cell alignment) {

        ship.setAlignment(alignment);
        ship.setStartPoint(startPoint);
        Method method = field.getClass().getDeclaredMethod("arrangeShip", Ship.class, Cell.class, Cell.class);
        method.setAccessible(true);
        method.invoke(field, ship, startPoint, alignment);

    }

}
