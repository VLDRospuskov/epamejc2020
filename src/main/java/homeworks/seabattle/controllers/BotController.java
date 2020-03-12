package homeworks.seabattle.controllers;

import homeworks.seabattle.util.Area;
import homeworks.seabattle.util.Positions;

import java.util.*;

public class BotController extends Controller implements Area<Integer> {

    private List<Integer> hitCells = new ArrayList<>();
    private boolean hit = false;

    public void makeMove() {

        Positions.swapAndSet();

        int shotPosition = 0;
        int beforeHitSize = 0;
        int afterHitSize = 0;
        int beforeDeadSize = 0;
        int afterDeadSize = 0;

        while (true) {

            decideHitOrKill(shotPosition, beforeHitSize, afterHitSize, beforeDeadSize, afterDeadSize);

            shotPosition = getRandomPosition();

            beforeHitSize = Positions.playerHitPositions.size();
            beforeDeadSize = Positions.opponentDeadShipPositions.size();

            if (!Positions.playerHitPositions.contains(shotPosition)
                    && !Positions.playerMissPositions.contains(shotPosition)
                    && isNoOverlapping(shotPosition)) {

                if (decideHitOrMiss(shotPosition)) {
                    break;
                }
            }

            afterHitSize = Positions.playerHitPositions.size();
            afterDeadSize = Positions.opponentDeadShipPositions.size();
        }
        fieldPrinter.print();
    }

    private void decideHitOrKill(int shotPosition, int beforeHitSize, int afterHitSize,
                                 int beforeDeadSize, int afterDeadSize) {

        if (beforeDeadSize < afterDeadSize) {
            hit = false;
            hitCells.clear();
        } else if (beforeHitSize < afterHitSize) {
            hit = true;
            hitCells.add(shotPosition);
        }
    }

    private int getRandomPosition() {

        if (hit) {
            return getNearHitPosition();
        } else {
            return new Random(System.currentTimeMillis()).nextInt(100);
        }
    }

    private int getNearHitPosition() {

        if (hitCells.size() == 1) {
            return getRandomDirection();
        } else {
            return getRandomEdge();
        }
    }

    private int getRandomEdge() {

        int maxIndex = getMaxIndex();

        int minIndex = getMinIndex();

        int difference = hitCells.get(maxIndex) - hitCells.get(minIndex);

        if (difference % 10 == 0) {
            if (Math.random() > 0.5) {
                return verticalDown(minIndex, maxIndex);
            } else {
                return verticalUp(maxIndex, minIndex);
            }
        } else {
            if (Math.random() > 0.5) {
                return horizontalLeft(minIndex, maxIndex);
            } else {
                return horizontalRight(maxIndex,minIndex);
            }
        }
    }

    private int getRandomDirection() {

        int result;

        if (Math.random() > 0.5) {
            if (Math.random() > 0.5) {
                result = verticalDown(0, 0);
            } else {
                result = verticalUp(0, 0);
            }
        } else {
            if (Math.random() > 0.5) {
                result = horizontalRight(0,0);
            } else {
                result = horizontalLeft(0, 0);
            }
        }
        return result;
    }

    private int getMinIndex() {
        return hitCells.indexOf(hitCells.stream()
                .min(Comparator.comparingInt(a -> a))
                .orElse(-1));
    }

    private int getMaxIndex() {
        return hitCells.indexOf(hitCells.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElse(-1));
    }

    private int verticalUp(int i, int i2) {
        return hitCells.get(i) + 10 < 100 ? hitCells.get(i) + 10 : hitCells.get(i2) - 10;
    }

    private int verticalDown(int i, int i2) {
        return hitCells.get(i) - 10 >= 0
                ? hitCells.get(i) - 10 : hitCells.get(i2) + 10;
    }

    private int horizontalLeft(int i, int i2) {
        return hitCells.get(i) - 1 >= 0
                && hitCells.get(i) % 10 != 0 ? hitCells.get(i) - 1 : hitCells.get(i2) + 1;
    }

    private int horizontalRight(int i, int i2) {
        return hitCells.get(i) + 1 < 100
                && hitCells.get(i) % 10 != 9 ? hitCells.get(i) + 1 : hitCells.get(i2) - 1;
    }

    @Override
    public boolean isNoOverlapping(Integer shotPosition) {
        List<Integer> busyCells = new ArrayList<>();
        Positions.opponentDeadShipPositions.forEach(x -> busyCells.addAll(getArea(busyCells, x)));

        return !busyCells.contains(shotPosition);
    }
}
