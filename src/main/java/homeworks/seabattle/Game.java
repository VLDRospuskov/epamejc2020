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
    public void run() {

        player = new PlayerController();

        OpponentSelector selector = new OpponentSelector();
        opponent = selector.select();

        FieldInitiator initiator1 = new FieldInitiator();
        initiator1.init();

        FieldInitiator initiator2 = new FieldInitiator();
        initiator2.init();

        while (Positions.opponentDeadShipPositions.size() != Positions.opponentShipPositions.size()) {
            player.makeMove();
            swapPlayers();
        }

        if (Positions.opponentDeadShipPositions.size() != 0) {

            System.out.println("Congratulations, you just won the game!!!");

            for (int i = 15; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)]
                            + " ■ " + Colors.colors[0]);
                }
                System.out.println();
            }
        } else {
            System.out.println("You ended the game!");
        }

        ConsoleReader.reader.close();
    }

    private void swapPlayers() {
        Controller x;
        x = player;
        player = opponent;
        opponent = x;
    }
}
