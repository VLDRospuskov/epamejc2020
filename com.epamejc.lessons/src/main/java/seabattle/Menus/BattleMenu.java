package seabattle.Menus;

import seabattle.FieldDrawer;
import seabattle.Players.Player;

public class BattleMenu extends Menu {

    @Override
    public void printMenu() {
        System.out.println("Shoot by typing coordinates, for example: \"c5\"\nOr enter \"exit\" to return to main menu.");
    }

    @Override
    public void executeCommand(String command) {
        int column = command.charAt(0) - 97;
        int row = Integer.parseInt(command.substring(1, 2)) - 1;
        Player currentPlayer = game.currentPlayerTurn;
        if (currentPlayer.isStrikeSuccessful(row, column)) {
            currentPlayer.shoot(row, column);
            if (currentPlayer.isStrikeLethal(row, column)) {
                System.out.print("You killed it! ");
                currentPlayer
                        .getEnemy()
                        .getShipsCounter()
                        .decreaseShipsLeftCounter();
                currentPlayer
                        .getEnemy()
                        .getMainField()
                        .surroundShipWithMisses(row, column);
                currentPlayer
                        .getSupportField()
                        .surroundShipWithMisses(row, column);
            }
            System.out.println("Great strike! Shoot again.");
        } else if (currentPlayer.isStrikeMissing(row, column)) {
            currentPlayer.shoot(row, column);
            game.currentPlayerTurn = currentPlayer.getEnemy();
            System.out.println("You missed.");
        } else {
            System.out.println("This cell is already stricken! Shoot again!");
        }
    }

    @Override
    public void run() {
        printMenu();

        String command = "";
        while (!game.gameOver() && !command.equals("exit")) {
            FieldDrawer.printFields(game.currentPlayerTurn.getMainField(), game.currentPlayerTurn.getSupportField());
            System.out.print("Shoot, " + game.currentPlayerTurn.getName() + ": ");
            command = readCommand();
            if (!command.equals("exit")) {
                executeCommand(command);
            }
        }
        if (game.gameOver()) {
            System.out.println(game.currentPlayerTurn.getName() + " wins!");
        }
    }

}
