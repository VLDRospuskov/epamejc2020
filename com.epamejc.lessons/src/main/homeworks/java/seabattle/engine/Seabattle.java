package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.*;
import homeworks.java.seabattle.enums.GameStats;
import homeworks.java.utils.UserInputReader;

public class Seabattle {

    private Player firstPlayer;
    private Player secondPlayer;

    public void run() {

        firstPlayer = new HumanPlayer("Vovan");
        firstPlayer.arrangeShips();
        secondPlayer = new BotPlayer();
        secondPlayer.arrangeShips();
        GameStats gameStats;

        Player currentPlayer = firstPlayer;

        do {
            printGame();
            Cell shot = firstPlayer.shoot();
            gameStats = secondPlayer.getField().hit(shot);
        } while (gameStats != GameStats.GAME_OVER);

    }

    private String getName() {

        return UserInputReader.readInput();

    }

    private void printGame() {

        System.out.println(firstPlayer.getField().printPlayerName(firstPlayer.getName()) +
                "\t" + secondPlayer.getField().printPlayerName(secondPlayer.getName()));
        System.out.println(firstPlayer.getField().printHead() + "\t" +
                secondPlayer.getField().printHead());
        for (int i = 0; i < Field.deckSize; i++) {
            System.out.println((char) (65 + i) + "  " +
                    firstPlayer.getField().printLine(i, firstPlayer.isVisible()) + "\t" +
                    (char) (65 + i) + "  " +
                    secondPlayer.getField().printLine(i, secondPlayer.isVisible()));
        }

    }

}
