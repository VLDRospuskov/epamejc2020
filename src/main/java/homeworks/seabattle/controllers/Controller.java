package homeworks.seabattle.controllers;


import homeworks.seabattle.util.Positions;
import homeworks.seabattle.util.Ship;
import homeworks.seabattle.battlefield.FieldPrinter;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {

    public int moveCount = 0;

    protected FieldPrinter fieldPrinter = new FieldPrinter();

    public abstract void makeMove();

    protected List<Integer> getDeadShipPosition(List<Integer> hitPositions) {

        return Positions.opponentShips.stream()
                .map(Ship::getCoordinates)
                .filter(hitPositions::containsAll)
                .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);

    }

    protected boolean decideHitOrMiss(int shotPosition) {

        moveCount++;

        if (Positions.opponentShipPositions.contains(shotPosition)) {

            Positions.playerHitPositions.add(shotPosition);
            Positions.opponentDeadShipPositions = getDeadShipPosition(Positions.playerHitPositions);

            return Positions.opponentShipPositions.size() == Positions.opponentDeadShipPositions.size();

        } else {
            Positions.playerMissPositions.add(shotPosition);
            return true;
        }
    }
}
