package homeworks.seabattle.controllers;

import homeworks.seabattle.Positions;
import homeworks.seabattle.battlefield.FieldPrinter;

public class BotController implements Controller {

    public void makeMove() {

        FieldPrinter printer = new FieldPrinter();
        printer.print();

        Positions.opponentShipPositions.clear();
        Positions.opponentDeadShipPositions.clear();

    }
}
