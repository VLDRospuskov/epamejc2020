package homeworks.sea_battle.data;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.enums.SystemMessages;
import homeworks.sea_battle.logic.*;

public class GameSettings {

    private IOOperations ioOperations;

    public GameSettings(IOOperations ioOperations) {
        this.ioOperations = ioOperations;
    }

    public void start() {
        System.out.println(SystemMessages.GREETINGS.message);
        Game game = setGameSettings();
        game.run();
    }

    public Game setGameSettings() {
        int input = ioOperations.parseGameSettingsInput();

        if (input == 3) {
            ioOperations.close();
            System.exit(0);
        }

        System.out.print("Player One ");
        Player playerOne = new Player(ioOperations.enterPlayerName(), new HumanPlayerShootingCommands());
        ShipsSetterCommands playerOneShipSetter = ioOperations.chooseShipSetter(playerOne);

        Player playerTwo = null;
        ShipsSetterCommands playerTwoShipSetter = null;

        if (input == 1) {
            playerTwo = new Player("Bot Player", new BotPlayerShootingCommands());
            playerTwoShipSetter = new AutomaticShipSetter();

        } else if (input == 2) {
            System.out.print("Player Two ");
            playerTwo = new Player(ioOperations.enterPlayerName(), new HumanPlayerShootingCommands());
            playerTwoShipSetter = ioOperations.chooseShipSetter(playerTwo);

        }

        return new Game(playerOne, playerTwo, playerOneShipSetter, playerTwoShipSetter);
    }

}
