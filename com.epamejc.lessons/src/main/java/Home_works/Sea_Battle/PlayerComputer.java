package Home_works.Sea_Battle;

import Home_works.Sea_Battle.field.FieldCreator;
import Home_works.Sea_Battle.ships.Coordinates;
import Home_works.Sea_Battle.ships.CoordinatesList;

import java.util.Random;

public class PlayerComputer {

    private String move = "x";
    private String blow = "✱";
    private String ship = "0";
    private String dot = ".";
    Random random = new Random();

    public void makeMove(FieldCreator field, CoordinatesList coordinatesList, FieldCreator movedField, int edge) {
        int x = random(edge);
        int y = random(edge);

        for (Coordinates coordinates : coordinatesList.getList()) {
            if (coordinates.isTarget()) {
                x = coordinates.getX();
                y = coordinates.getY();
                coordinates.setTarget(false);
            }
        }

        if (!coordinatesList.getList().get(coordinatesList.getElement(x, y)).isFlag()) {
            makeMove(field, coordinatesList, movedField, edge);
        } else {

            if (field.getCell(x, y).equals(dot)) {
                field.changeCell(x, y, move);
                movedField.changeCell(x, y, move);
                System.out.println("Computer missed");
                coordinatesList.getList().get(coordinatesList.getElement(x, y)).setValue(move);
            } else if (field.getCell(x, y).equals(move)) {
                makeMove(field, coordinatesList, movedField, edge);
            } else if (field.getCell(x, y).equals(ship)) {
                field.changeCell(x, y, blow);
                System.out.println("Computer hit the target");
                coordinatesList.getList().get(coordinatesList.getElement(x, y)).setValue(blow);
                checkArea(x, y, field, coordinatesList);
            } else if (field.getCell(x, y).equals(blow)) {
                makeMove(field, coordinatesList, movedField, edge);
            }
        }
    }

    private int random(int edge) {
        return random.nextInt(edge);
    }

    private void checkArea(int first, int second, FieldCreator field, CoordinatesList coordinatesList) {
        int firstIncreas = first + 1;
        int secondIncreas = second + 1;
        int firstDecrease = first - 1;
        int secondDecrease = second - 1;

        checkNextCell(first, secondIncreas, field, coordinatesList);
        checkNextCell(first, secondDecrease, field, coordinatesList);
        checkNextCell(firstIncreas, second, field, coordinatesList);
        checkNextCell(firstDecrease, second, field, coordinatesList);
    }

    private void checkNextCell(int first, int second, FieldCreator field, CoordinatesList coordinatesList) {
        if (coordinatesList.getElement(first, second) > 0) {
            if (!field.getCell(first, second).equals(ship)) {
                if (!coordinatesList.getList().get(coordinatesList.getElement(first, second)).getValue().equals(dot)) {
                    coordinatesList.getList().get(coordinatesList.getElement(first, second)).setFlag(false);
                }
            } else {
                coordinatesList.getList().get(coordinatesList.getElement(first, second)).setTarget(true);
            }
        }
    }
}
