package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.*;
import homeworks.java.seabattle.data.enums.GameStats;
import homeworks.java.seabattle.data.enums.Outputs;
import homeworks.java.utils.UserInputReader;

import java.util.Arrays;
import java.util.List;

public class Seabattle {

    private List<Player> players;
    private Player currentPlayer;

    public void run() {

        GameStats gameState;
        System.out.println(Outputs.START.getMessage() + "\n");

        chooseGameMode();
        players.forEach(Player::arrangeShips);
        currentPlayer = players.get(0);

        do {
            GameIO.printGame(players);
            System.out.println("It's " + currentPlayer.getName() + " turn");
            gameState = currentPlayer.shoot(getEnemy());
            if (gameState.equals(GameStats.MISS)) {
                currentPlayer = getEnemy();
            }
        } while (!gameState.equals(GameStats.GAME_OVER));

        setAllVisibility(true);
        GameIO.printGame(players);
        System.out.println(Outputs.END.getMessage() + currentPlayer.getName() +
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
        System.out.println("choose a game mode: ");
        System.out.println("enter:\n1 to play with bot \n2 to play with a friend \n3 to look at two bots battle");
        do {
            String input = UserInputReader.readInput();
            done = setUpPlayers(input);
        } while (!done);

    }

    private boolean setUpPlayers(String input) {

        boolean done = true;
        String message = "enter Your name, or press \"Enter\" to generate it randomly: ";

        switch (input) {
            case "1":
                System.out.println(message);
                players = Arrays.asList(new HumanPlayer(UserInputReader.readInput()), new BotPlayer());
                break;
            case "2":
                System.out.println("First player, " + message);
                String firstName = UserInputReader.readInput();
                System.out.println("Second player, " + message);
                String secondName = UserInputReader.readInput();
                players = Arrays.asList(new HumanPlayer(firstName), new HumanPlayer(secondName));
                setAllVisibility(false);
                break;
            case "3":
                players = Arrays.asList(new BotPlayer(), new BotPlayer());
                break;
            default:
                System.out.println("Wrong input! ");
                done = false;
                break;
        }
        return done;

    }

}