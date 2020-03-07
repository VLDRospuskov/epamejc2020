package homeworks.seabattle;

import homeworks.homework3.allInAll.Colors;
import homeworks.seabattle.battlefield.FieldInitiator;
import homeworks.seabattle.battlefield.PlayerFieldInitiator;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    Controller player;
    Controller opponent;

    @SneakyThrows
    public void run() {

        OpponentSelector selector1 = new OpponentSelector();
        player = selector1.select();

        OpponentSelector selector2 = new OpponentSelector();
        opponent = selector2.select();

        while (Positions.opponentDeadShipPositions.size() != Positions.opponentShipPositions.size()) {
            player.makeMove();
            swapPlayers();
        }

        showEndGame();

        ConsoleReader.reader.close();
    }

    private void showEndGame() {
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
    }

    private void swapPlayers() {
        Controller x;
        x = player;
        player = opponent;
        opponent = x;
    }
}
