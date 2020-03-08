package homeworks.seabattle.controllers;

import homeworks.seabattle.Positions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BotController extends Controller {

    List<Integer> hitCells = new ArrayList<>();
    boolean hit = false;

    public void makeMove() {

        Positions.swapAndSet(hitPositions, missPositions, deadShipPositions);

        int shotPosition = 0;
        int beforeHitSize = 0;
        int afterHitSize = 0;
        int beforeDeadSize = 0;
        int afterDeadSize = 0;

        while (true) {

            if (beforeDeadSize < afterDeadSize) {
                hit = false;
                hitCells.clear();
            } else if (beforeHitSize < afterHitSize) {
                hit = true;
                hitCells.add(shotPosition);
            }

            shotPosition = getRandomPosition();

            beforeHitSize = hitPositions.size();
            beforeDeadSize = deadShipPositions.size();

            if (!hitPositions.contains(shotPosition)
                    && !missPositions.contains(shotPosition)) {

//                if (decideHitOrMiss(shotPosition)) {
//                    break;
//                }
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
            }

            afterHitSize = hitPositions.size();
            afterDeadSize = deadShipPositions.size();
        }
        fieldPrinter.print();
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

        int maxIndex = hitCells.indexOf(hitCells.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElse(-1));

        int minIndex = hitCells.indexOf(hitCells.stream()
                .min(Comparator.comparingInt(a -> a))
                .orElse(-1));

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
}
