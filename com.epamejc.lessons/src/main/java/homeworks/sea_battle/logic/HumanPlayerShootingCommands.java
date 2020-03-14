package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.PlayerShootingCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Player;

public class HumanPlayerShootingCommands implements PlayerShootingCommands {

    private IOOperations ioOperations;

    public HumanPlayerShootingCommands() {
        this.ioOperations = new IOOperations();
    }

    @Override
    public boolean shot(Player player, Player opponent) {
        System.out.println(opponent.getName() + " field");
        PrintFieldCommand.printField(player.getOpponentField().getField());

        System.out.print(player.getName() + " turn: ");

        Coordinates coordinates = ioOperations.parseCoordinates();

        return makeShot(player, opponent, coordinates.getX(), coordinates.getY());
    }
}
