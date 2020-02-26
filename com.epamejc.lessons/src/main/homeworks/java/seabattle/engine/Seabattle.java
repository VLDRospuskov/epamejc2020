package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.*;
import homeworks.java.seabattle.enums.GameStats;
import homeworks.java.seabattle.enums.Outputs;
import homeworks.java.utils.UserInputReader;

public class Seabattle {

    private Player firstPlayer;
    private Player secondPlayer;

    public void run() {

        System.out.println(Outputs.START.getMessage() + "\n");

        firstPlayer = new HumanPlayer("Vovan");
        firstPlayer.arrangeShips();
        secondPlayer = new BotPlayer();
        secondPlayer.arrangeShips();
        GameStats gameStats;

        do {
            GameIO.printGame(firstPlayer, secondPlayer);
            Cell shot = firstPlayer.shoot();
            gameStats = secondPlayer.getField().hit(shot);
        } while (gameStats != GameStats.GAME_OVER);
        System.out.println(Outputs.END +
                (firstPlayer.getField().getShips().size() == 0? secondPlayer.getName() : firstPlayer.getName()));

    }

    private String getName() {

        return UserInputReader.readInput();

    }


}
