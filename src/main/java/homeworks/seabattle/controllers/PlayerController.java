package homeworks.seabattle.controllers;

import homeworks.seabattle.ConsoleReader;
import homeworks.seabattle.Positions;
import homeworks.seabattle.Ship;
import homeworks.seabattle.battlefield.FieldPrinter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PlayerController implements Controller {

    private List<Integer> hitPositions = new ArrayList<>();
    private List<Integer> missPositions = new ArrayList<>();
    private List<Integer> deadShipPositions = new ArrayList<>();

    private FieldPrinter fieldPrinter = new FieldPrinter();

    @SneakyThrows
    public void makeMove() {

        Positions.swapAndSet(hitPositions, missPositions, deadShipPositions);

        while (true) {

            fieldPrinter.print();

            System.out.println("Decide where to shoot: ");

            String shot = ConsoleReader.reader.readLine();

            if (shot.equalsIgnoreCase("exit")) {
                Positions.opponentShipPositions.clear();
                Positions.opponentDeadShipPositions.clear();
                break;
            }

            int shotPosition = Positions.allCells.indexOf(shot.toUpperCase());

            if (shotPosition != -1) {

                if (!hitPositions.contains(shotPosition) && !missPositions.contains(shotPosition)) {

                    if (Positions.opponentShipPositions.contains(shotPosition)) {

                        hitPositions.add(shotPosition);
                        deadShipPositions = getDeadShipPosition(hitPositions);
                        Positions.opponentDeadShipPositions = deadShipPositions;

                        if (Positions.opponentShipPositions.size() == Positions.opponentDeadShipPositions.size()) {
                            break;
                        }

                    } else {
                        missPositions.add(shotPosition);
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

    private List<Integer> getDeadShipPosition(List<Integer> hitPositions) {

        return Positions.opponentShips.stream()
                .map(Ship::getCoordinates)
                .filter(hitPositions::containsAll)
                .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);

    }
}
