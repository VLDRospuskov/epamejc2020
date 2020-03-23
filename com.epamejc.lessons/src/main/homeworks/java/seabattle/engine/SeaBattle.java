package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.*;
import homeworks.java.seabattle.data.enums.GameState;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeaBattle {

    private List<Player> players;
    private Player currentPlayer;
    private GameIO io = new GameIO();

    @SneakyThrows
    public void run() {

        GameState gameState;
        io.print("Welcome to a Sea Battle game!");
        chooseGameMode();
        players.forEach(Player::arrangeShips);
        currentPlayer = players.get(0);

        do {
            io.printGame(players);
            io.print("It's " + currentPlayer.getName() + " turn");
            gameState = currentPlayer.shoot(getEnemy());
            if (currentPlayer instanceof BotPlayer) {
                TimeUnit.MILLISECONDS.sleep(400);
            }
            if (gameState.equals(GameState.MISS)) {
                currentPlayer = getEnemy();
            }
        } while (!gameState.equals(GameState.GAME_OVER));

        setAllVisibility(true);
        io.printGame(players);
        io.print("The game is over, " + currentPlayer.getName() +
                " won the game in " + currentPlayer.getMoves() + " moves");

    }

    private void setAllVisibility(boolean condition) {

        players.forEach(player -> player.setVisible(condition));

    }

    private Player getEnemy() {

        return players.get(1 - players.indexOf(currentPlayer));

    }

    private void chooseGameMode() {

        boolean done;
        io.print("choose a game mode:\n " +
                "enter:\n" +
                "1 to play with bot \n" +
                "2 to play with a friend \n" +
                "3 to look at two bots battle");
        do {
            String input = io.getInput();
            done = setUpPlayers(input);
        } while (!done);

    }

    /**
     * The game initialisation method. The instances of {@link HumanPlayer} and
     * {@link BotPlayer} are created here. The initialisation of of common fields for
     * both happens in the abstract super class {@link Player#Player()} constructor.
     * The game can be played between two human players, between human player and the
     * bot player, also between two bot players.
     *
     * @param choice is a {@code String} input for game mode selection
     * @return boolean {@code true} if input was correct and game setup succeeded,
     * and {@code false} otherwise.
     */
    private boolean setUpPlayers(String choice) {

        boolean done = true;
        switch (choice) {
            case "1":
                players = Arrays.asList(new HumanPlayer(io), new BotPlayer(new AI()));
                break;
            case "2":
                players = Arrays.asList(new HumanPlayer(io),
                        new HumanPlayer(io));
                setAllVisibility(false);
                break;
            case "3":
                players = Arrays.asList(new BotPlayer(new AI()), new BotPlayer(new AI()));
                break;
            default:
                io.print("Wrong input! ");
                done = false;
                break;
        }
        return done;

    }

}