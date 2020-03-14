package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.data.Player;
import lombok.Data;

@Data
public class Game {

    private Player playerOne;
    private Player playerTwo;
    private ShipsSetterCommands playerOneShipSetter;
    private ShipsSetterCommands playerTwoShipSetter;
    private Player turnOrder;
    private Player opponent;


    public Game(Player playerOne,
                Player playerTwo,
                ShipsSetterCommands playerOneShipSetter,
                ShipsSetterCommands playerTwoShipSetter) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneShipSetter = playerOneShipSetter;
        this.playerTwoShipSetter = playerTwoShipSetter;
        this.turnOrder = playerOne;
        this.opponent = playerTwo;
    }

    public void run() {
        playerOneShipSetter.setShips(playerOne);
        playerTwoShipSetter.setShips(playerTwo);
        clearConsole();

        while (true) {
            if (!(turnOrder.getShootingCommands().shot(turnOrder, opponent))) {
                Player temp = turnOrder;
                turnOrder = opponent;
                opponent = temp;
            }

            if (turnOrder.isWin()) {
                PrintFieldCommand.printField(turnOrder.getPlayerField().getField());
                System.out.println("<<<< !!! " + turnOrder.getName() + " win !!! >>>");
                break;
            }
        }
    }

    private void clearConsole() {
        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }
}
