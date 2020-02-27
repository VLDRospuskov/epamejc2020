package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.*;
import homeworks.java.seabattle.data.enums.GameState;

import java.util.Arrays;
import java.util.List;

public class SeaBattle {

    private List<Player> players;
    private Player currentPlayer;

    public void run() {

        GameState gameState;
        GameIO.print("Welcome to a Sea Battle game!");
        chooseGameMode();
        players.forEach(Player::arrangeShips);
        currentPlayer = players.get(0);

        do {
            GameIO.printGame(players);
            GameIO.print("It's " + currentPlayer.getName() + " turn");
            gameState = currentPlayer.shoot(getEnemy());
            if (gameState.equals(GameState.MISS)) {
                currentPlayer = getEnemy();
            }
        } while (!gameState.equals(GameState.GAME_OVER));

        setAllVisibility(true);
        GameIO.printGame(players);
        GameIO.print("The game is over, " + currentPlayer.getName() +
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
        GameIO.print("choose a game mode:\n " +
                "enter:\n" +
                "1 to play with bot \n" +
                "2 to play with a friend \n" +
                "3 to look at two bots battle");
        do {
            String input = GameIO.getInput();
            done = setUpPlayers(input);
        } while (!done);

    }

    private boolean setUpPlayers(String input) {

        boolean done = true;
        switch (input) {
            case "1":
                players = Arrays.asList(new HumanPlayer(GameIO.nameInput()), new BotPlayer());
                break;
            case "2":
                players = Arrays.asList(new HumanPlayer(GameIO.nameInput()),
                        new HumanPlayer(GameIO.nameInput()));
                setAllVisibility(false);
                break;
            case "3":
                players = Arrays.asList(new BotPlayer(), new BotPlayer());
                break;
            default:
                GameIO.print("Wrong input! ");
                done = false;
                break;
        }
        return done;

    }

}