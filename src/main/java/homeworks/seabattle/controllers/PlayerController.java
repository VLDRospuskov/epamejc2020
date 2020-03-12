package homeworks.seabattle.controllers;

import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import lombok.SneakyThrows;

public class PlayerController extends Controller {

    @SneakyThrows
    public void makeMove() {

        Positions.swapAndSet();

        while (true) {

            fieldPrinter.print();

            System.out.print("\nDecide where to shoot: ");

            String shot = ConsoleReader.reader.readLine();

            if (shot.equalsIgnoreCase("exit")) {
                Positions.opponentShipPositions.clear();
                Positions.opponentDeadShipPositions.clear();
                break;
            }

            int shotPosition = Positions.allCells.indexOf(shot.toUpperCase());

            if (shotPosition != -1) {

                if (!Positions.playerHitPositions.contains(shotPosition)
                        && !Positions.playerMissPositions.contains(shotPosition)) {

                    if (decideHitOrMiss(shotPosition)) {
                        break;
                    }

                } else {
                    System.out.println("Cell is already shot!");
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
