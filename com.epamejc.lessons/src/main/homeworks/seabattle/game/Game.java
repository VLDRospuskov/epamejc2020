package main.homeworks.seabattle.game;

import main.homeworks.seabattle.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum GameState{
    PVP,
    PvsAI
}

public class Game {

    private final int fieldSize = 10;

    public GameState gameState;

    public Game() {
        //TODO player vs ai mode

        Player player1 = new Player("Player 1");
        player1.addShips();
        clearScreen();

        Player player2 = new Player("Player 2");
        player2.addShips();
        clearScreen();

        player1.setOppositeField(player2.getField());
        player2.setOppositeField(player1.getField());

        while (true) {
            System.out.println(player1.name + "'s turn");
            player1.move();
            System.out.println(player2.name + "'s turn");
            player2.move();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void endGame(Player loser) {
        System.out.println("Game over, " + loser.name);
        System.out.println("Want to play again? Type 'yes' or 'no': ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (s.equals("yes")) {
            new Game();
        } else {
            System.exit(1);
        }
    }

}
