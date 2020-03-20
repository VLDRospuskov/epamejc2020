package homeworks.sea_battle;

import homeworks.sea_battle.data.GameSettings;
import homeworks.sea_battle.logic.IOOperations;

public class Application {

    public static void main(String[] args) {
        IOOperations ioOperations = new IOOperations();
        GameSettings gameSettings = new GameSettings(ioOperations);
        gameSettings.start();
        ioOperations.close();
    }

}
