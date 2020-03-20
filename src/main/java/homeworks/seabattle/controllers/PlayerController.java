package homeworks.seabattle.controllers;

import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.util.Positions;
import lombok.SneakyThrows;

public class PlayerController extends Controller {

    @SneakyThrows
    public void makeMove() {

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

            if (getShotStatus(shotPosition)) {
                break;
            }
        }
    }

    private boolean getShotStatus(int shotPosition) {

        if (shotPosition != -1) {

            if (!Positions.playerHitPositions.contains(shotPosition)
                    && !Positions.playerMissPositions.contains(shotPosition)) {

                return decideHitOrMiss(shotPosition);

            } else {
                System.out.println("Cell is already shot!");
            }
        } else {
            System.out.println("Invalid input");
        }
        return false;
    }
}
