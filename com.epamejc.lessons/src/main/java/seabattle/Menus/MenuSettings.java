package seabattle.Menus;

import seabattle.Enums.DifficultyAI;
import seabattle.FieldDrawer;
import seabattle.Players.Player;
import seabattle.Players.PlayerAI;
import seabattle.Settings;

public class MenuSettings extends Menu {

    @Override
    public void printMenu() {
        System.out.println(
                "Current settings: Mode - " + getGameMode(game.player1, game.player2) +
                        //". Field - " + Settings.fieldRows + "x" + Settings.fieldColumns +
                "\n1. Change player - " + game.player1.getName() +
                "\n2. Change player - " + game.player2.getName() +
                "\n0. Exit");
    }

    @Override
    public void executeCommand(String command) {
        int commandKey = 0;
        try {
            commandKey = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Wrong command!");
        }

        switch (commandKey) {
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        String command;
        do {
            printMenu();
            System.out.print("Enter command: ");
            command = readCommand();
            executeCommand(command);
        } while (!command.equals("0") && !command.equals("exit"));
    }

    private void changePlayerMenu() {
        String command;
        do {

            System.out.print("Enter command: ");
            command = readCommand();
            executeCommand(command);
        } while (!command.equals("0") && !command.equals("exit"));
    }

    private String getGameMode(Player player1, Player player2) {
        String gameMode = "";
        if (player1.getClass().equals(Player.class)) {
            gameMode += "Player vs ";
        } else {
            gameMode += "AI(" + getPlayerDifficulty((PlayerAI) player1) + ") vs ";
        }
        if (player2.getClass().equals(Player.class)) {
            gameMode += "Player";
        } else {
            gameMode += "AI(" + getPlayerDifficulty((PlayerAI) player2) + ")";
        }
        return gameMode;
    }

    private String getPlayerDifficulty(PlayerAI playerAI) {
        return playerAI.difficultyAI.toString().toLowerCase();
    }

}
