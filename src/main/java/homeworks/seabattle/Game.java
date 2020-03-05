package homeworks.seabattle;

import homeworks.homework3.allInAll.Colors;
import homeworks.seabattle.battlefield.FieldInitiator;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    Controller player;
    Controller opponent;

    @SneakyThrows
    public void run () {

        player = new PlayerController();

        OpponentSelector selector = new OpponentSelector();
        opponent = selector.select();

        FieldInitiator initiator1 = new FieldInitiator();
        Positions.opponentShipPositions = initiator1.init();
        Positions.opponentShips = initiator1.ships;

        FieldInitiator initiator2 = new FieldInitiator();
        Positions.playerShipPositions = initiator2.init();
        Positions.playerShips = initiator2.ships;

        while (true) {

            player.makeMove();

            swapPlayers();

            if (Positions.opponentDeadShipPositions.size() == Positions.opponentShipPositions.size()) {
                System.out.println("Congratulations, you just won the game!!!");
                break;
            }
        }

        for (int i = 15; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)]
                        + " ■ " + Colors.colors[0]);
            }
            System.out.println();
        }

        ConsoleReader.reader.close();
    }

    private void swapPlayers () {
        Controller x;
        x = player;
        player = opponent;
        opponent = x;
    }
}
