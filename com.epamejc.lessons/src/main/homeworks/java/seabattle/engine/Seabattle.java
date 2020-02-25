package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Player;
import homeworks.java.seabattle.enums.Actor;
import homeworks.java.seabattle.enums.GameStats;
import homeworks.java.utils.UserInputReader;

public class Seabattle {

    private Player firstPlayer;
    private Player secondPlayer;

    public void run() {

        firstPlayer = new Player(Actor.HUMAN);
//        firstPlayer.setName(getName());
        firstPlayer.arrangeShips();
        secondPlayer = new Player(Actor.HUMAN);
//        secondPlayer.setName(getName());
        secondPlayer.arrangeShips();
        UserInterface userInterface = new UserInterface();
        GameStats gameStats;

        do {
            userInterface.printGame(firstPlayer, secondPlayer);
            gameStats = secondPlayer.shoot(userInterface.userInput());
        } while (gameStats != GameStats.GAME_OVER);

    }

    private String getName() {

        return UserInputReader.readInput();

    }


}
