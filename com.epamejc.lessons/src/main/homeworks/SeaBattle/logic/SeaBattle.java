package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.enums.Messages;
import homeworks.SeaBattle.data.players.Player;
import homeworks.utility.helper.Helper;

import java.util.ArrayList;

import static homeworks.SeaBattle.data.StaticVariables.TOTAL_SCORE;
import static homeworks.SeaBattle.logic.Util.generateComputer;
import static homeworks.SeaBattle.logic.Util.generateUser;

public class SeaBattle {
    private Player player1;
    private Player player2;
    private ArrayList<Player> players;

    public void run() {
        initializeGame();
        play();
        endGame();
    }

    private void endGame() {
        Player winner = null;

        for (Player player : players) {
            if (player.getScore() == TOTAL_SCORE) {
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println(winner.getName() + " is a winner!");
            System.out.println("Thank you for the game!");
        }

        Helper.closeReaderSilently();
    }

    private void play() {
        while (!winningCondition()) {
            Shooter shooter = new Shooter(players);
            shooter.keepShooting();
            changeTurns(players);
        }
    }

    private void changeTurns(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.isActive()) {
                player.setActive(false);
            } else {
                player.setActive(true);
            }
        }
    }

    private boolean winningCondition() {
        return player1.getScore() == TOTAL_SCORE || player2.getScore() == TOTAL_SCORE;
    }

    private void initializeGame() {
        System.out.println(Messages.GREETING);
        generatePlayers();
        generateFields();
    }

    private void generatePlayers() {
        player1 = generateUser();
        player1.setActive(true);

        int gameType = IO.getGameType();
        switch (gameType) {
            case 1: {
                player2 = generateComputer();
                break;
            }
            case 2: {
                player2 = generateUser();
                break;
            }
        }

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    private void generateFields() {
        new FieldGenerator(player1).generateField();
        new FieldGenerator(player2).generateField();
    }

}
