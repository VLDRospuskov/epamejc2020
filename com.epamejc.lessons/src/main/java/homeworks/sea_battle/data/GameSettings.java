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

    private Game setGameSettings() {
        int input = ioOperations.parseGameSettingsInput();

        if (input == 3) {
            ioOperations.close();
            System.exit(0);
        }

        Player playerOne = playerInit(input, true);
        ShipsSetterCommands playerOneShipSetter = ioOperations.chooseShipSetter(playerOne, ioOperations);
        Player playerTwo = playerInit(input, false);
        ShipsSetterCommands playerTwoShipSetter = ioOperations.chooseShipSetter(playerTwo, ioOperations);

        return new Game(playerOne, playerTwo, playerOneShipSetter, playerTwoShipSetter);
    }

    private Player playerInit(int input, boolean side) {
        Player player = null;
        if (side) {
            System.out.print("Player One ");
            player = new Player(ioOperations.enterPlayerName(), new HumanPlayerShootingCommands());
        } else {
            switch (input) {
                case 1 : {
                   player = new Player("Bot Player", new BotPlayerShootingCommands());
                   break;
                }
                case 2 : {
                    System.out.print("Player Two ");
                    player = new Player(ioOperations.enterPlayerName(), new HumanPlayerShootingCommands());
                    break;
                }
            }
        }

        return player;
    }

}
