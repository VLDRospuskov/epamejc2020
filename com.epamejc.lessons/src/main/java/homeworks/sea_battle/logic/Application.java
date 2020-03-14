package homeworks.sea_battle.logic;

import homeworks.sea_battle.data.GameSettings;

public class Application {

    public static void main(String[] args) {
        IOOperations ioOperations = new IOOperations();
        GameSettings gameSettings = new GameSettings(ioOperations);
        gameSettings.start();
        ioOperations.close();
    }

}
