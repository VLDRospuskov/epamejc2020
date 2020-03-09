package Homeworks.HW6.SeaBattle.Game;


import Homeworks.HW6.SeaBattle.Input.Input;
import Homeworks.HW6.SeaBattle.Player.Player;

public class Game {
    boolean gameModeSelected;
    GameMode gameMode;

    Player player1;
    Player player2;

    public Game() {
        System.out.println("Welcome to the Sea Battle!");
        // game mode
        setGameMode();
        // create players
        setPlayers();
        // place ships
    }

    public void start() {

    }

    private void setGameMode() {
        while (! gameModeSelected) {
            System.out.println("Please select game mode:");
            for(GameMode game : GameMode.values()) {
                System.out.println(game.ordinal() + " - " + game.getDescription() + " (" + game.name() + ")");
            }
            String inputString = Input.readLine();
            try {
                int input = Integer.parseInt(inputString);
                gameMode = GameMode.values()[input];
                System.out.println("You selected: " + gameMode.getDescription() + ".");
                gameModeSelected = true;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }

    private void setPlayers() {
        player1 = new Player();
        switch (gameMode.ordinal()) {
            case 0:
                System.out.println("Player 1 vs Bot");
                player2 = new Player();
                break;
            case 1:
                System.out.println("Player vs Player");
                player2 = new Player();
                break;
            default:
                System.out.println("Error! Incorrect game mode selected.");
        }
    }

}
