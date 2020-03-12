package homeworks.seabattle.battlefield;

import homeworks.seabattle.util.Positions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BotFieldInitiator extends FieldInitiator {

    private int length;
    private int beforeSize;
    private int afterSize;
    private int count;

    @Override
    public void init() {

        System.out.println("Please wait...");

        Positions.swapAndSet();

        length = 4;
        beforeSize = 0;
        afterSize = 0;
        count = 1;

        while (Positions.playerShips.size() != 10) {

            int randomPosition = getRandomPosition();

            countShipsAndUpdate();

            boolean randomDirection = getRandomDirection();

            beforeSize = Positions.playerShips.size();

            List<Integer> cellPositions = getCellPositions(randomPosition, length, randomDirection);

            filterAndSet(cellPositions);

            afterSize = Positions.playerShips.size();
        }
    }

    private void countShipsAndUpdate() {
        if (beforeSize == afterSize - 1) {
            count--;
            if (count == 0) {
                length--;
                count = 5 - length;
            }
        }
    }

    private int getRandomPosition() {
        return new Random(System.currentTimeMillis()).nextInt(100);
    }

    private boolean getRandomDirection() {
        return Math.random() > 0.5;
    }

    private List<Integer> getCellPositions(int randomPosition, int randomLength, boolean randomDirection) {

        List<Integer> cellPositions = new ArrayList<>();

        if (randomDirection && randomPosition / 10 <= 10 - randomLength) {
            cellPositions = generateCells(randomLength, randomPosition, 10);
        } else if (randomPosition % 10 < 9 - randomLength) {
            cellPositions = generateCells(randomLength, randomPosition, 1);
        }
        return cellPositions;
    }

    private List<Integer> generateCells(int randomLength, int randomPosition, int seed) {
        return Stream.iterate(randomPosition, x -> x + seed)
                .limit(randomLength)
                .collect(Collectors.toList());
    }

}
