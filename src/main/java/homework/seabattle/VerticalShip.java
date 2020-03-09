package homework.seabattle;

import java.util.HashSet;
import java.util.Set;

import static homework.seabattle.Config.MAX_NUMBER;

public class VerticalShip extends Ship {

    VerticalShip(Coordinate startCoordinate, int length) {
        super(startCoordinate, length);
    }

    @Override
    protected void calculateAllCoordinates(Coordinate startCoordinate) {
        int startNumber = startCoordinate.getNumber();
        int endNumber = startNumber + length - 1;
        if (endNumber <= MAX_NUMBER) {
            for (int number = startNumber; number <= endNumber; number++) {
                Coordinate coordinate = new Coordinate(startCoordinate.getLetter(), number);
                addCoordinate(coordinate);
            }
        }
    }

    @Override
    protected Set<Coordinate> calculateArea() {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        char shipLetter = getFirstCoordinate().getLetter();

        areaCoordinates.addAll(calculateLeftRightArea(shipLetter));
        areaCoordinates.addAll(calculateUpArea(shipLetter));
        areaCoordinates.addAll(calculateDownArea(shipLetter));
        return areaCoordinates;
    }

    private Set<Coordinate> calculateLeftRightArea(char shipLetter) {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        for (Coordinate coordinate : getCoordinates()) {
            int number = coordinate.getNumber();
            try {
                Coordinate leftCoordinate = new Coordinate((char) (shipLetter - 1), number);
                areaCoordinates.add(leftCoordinate);
            } catch (IllegalArgumentException ignored) {
            }

            try {
                Coordinate rightCoordinate = new Coordinate((char) (shipLetter + 1), number);
                areaCoordinates.add(rightCoordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return areaCoordinates;
    }

    private Set<Coordinate> calculateUpArea(char shipLetter) {
        int upNumber = getFirstCoordinate().getNumber() - 1;
        return calculateHorizontalArea(shipLetter, upNumber);
    }

    private Set<Coordinate> calculateDownArea(char shipLetter) {
        int downNumber = getLastCoordinate().getNumber() + 1;
        return calculateHorizontalArea(shipLetter, downNumber);
    }

    private Set<Coordinate> calculateHorizontalArea(char shipLetter, int number) {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        for (char letter = (char) (shipLetter - 1); letter <= shipLetter + 1; letter++) {
            try {
                Coordinate coordinate = new Coordinate(letter, number);
                areaCoordinates.add(coordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return areaCoordinates;
    }
}
