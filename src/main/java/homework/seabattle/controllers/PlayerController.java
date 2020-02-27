package homework.seabattle.controllers;

import homework.seabattle.ConsoleReader;
import homework.seabattle.Positions;
import homework.seabattle.battlefield.FieldPrinter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PlayerController implements Controller {

    private List<Integer> hitPositions = new ArrayList<>();
    private List<Integer> missPositions = new ArrayList<>();

    private FieldPrinter fieldPrinter = new FieldPrinter();

    @SneakyThrows
    public void makeMove() {

        Positions.swapAndSet(hitPositions, missPositions);

        while (true) {

            fieldPrinter.print();
            System.out.println("Decide where to shoot: ");
            String shot = ConsoleReader.reader.readLine();
            int shotPosition = Positions.allCells.indexOf(shot.toUpperCase());

            if (shotPosition != -1) {

                if (Positions.opponentShipPositions.contains(shotPosition)) {
                    hitPositions.add(shotPosition);
                } else {
                    missPositions.add(shotPosition);
                    break;
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
