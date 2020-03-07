package homeworks.seabattle.battlefield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BotFieldInitiator extends FieldInitiator {

    @Override
    public void init() {

        swapShipPositions();

        int length = 4;
        int beforeSize = 0;
        int afterSize = 0;
        int count = 1;

        while (ships.size() != 10) {

            int randomPosition = getRandomPosition();

            if (beforeSize == afterSize - 1) {
                count--;
                if (count == 0) {
                    length--;
                    count = 5 - length;
                }
            }

            boolean randomDirection = getRandomDirection();

            beforeSize = ships.size();

            List<Integer> userShip = getCellPositions(randomPosition, length, randomDirection);

            filterAndSet(userShip);

            afterSize = ships.size();
        }
    }

    private int getRandomPosition() {
        return new Random(System.currentTimeMillis()).nextInt(100);
    }

    private boolean getRandomDirection() {
        return new Random(System.currentTimeMillis()).nextInt() > 0;
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
