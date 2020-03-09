package homeworks.seabattle.controllers;


import homeworks.seabattle.util.Positions;
import homeworks.seabattle.util.Ship;
import homeworks.seabattle.battlefield.FieldPrinter;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {

    protected List<Integer> hitPositions = new ArrayList<>();
    protected List<Integer> missPositions = new ArrayList<>();
    protected List<Integer> deadShipPositions = new ArrayList<>();

    protected int moveCount = 0;

    protected FieldPrinter fieldPrinter = new FieldPrinter();

    public abstract void makeMove ();

    protected List<Integer> getDeadShipPosition(List<Integer> hitPositions) {

        return Positions.opponentShips.stream()
                .map(Ship::getCoordinates)
                .filter(hitPositions::containsAll)
                .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);

    }

    protected boolean decideHitOrMiss(int shotPosition) {

        if (Positions.opponentShipPositions.contains(shotPosition)) {

            hitPositions.add(shotPosition);
            deadShipPositions = getDeadShipPosition(hitPositions);
            Positions.opponentDeadShipPositions = deadShipPositions;

            return Positions.opponentShipPositions.size() == Positions.opponentDeadShipPositions.size();

        } else {
            System.out.println("Moves amount: " + moveCount);
            missPositions.add(shotPosition);
            return true;
        }
    }
}
