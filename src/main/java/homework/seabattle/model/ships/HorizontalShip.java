package homework.seabattle.model.ships;

import homework.seabattle.model.Coordinate;

import java.util.HashSet;
import java.util.Set;

import static homework.seabattle.config.Config.MAX_LETTER;

public class HorizontalShip extends Ship {

    public HorizontalShip(Coordinate startCoordinate, int length) {
        super(startCoordinate, length);
    }

    @Override
    protected void calculateAllCoordinates(Coordinate startCoordinate) {
        char startChar = startCoordinate.getLetter();
        char endChar = (char) (startChar + length - 1);
        if (endChar <= MAX_LETTER) {
            for (char ch = startChar; ch <= endChar; ch++) {
                Coordinate coordinate = new Coordinate(ch, startCoordinate.getNumber());
                addCoordinate(coordinate);
            }
        }
    }

    @Override
    protected Set<Coordinate> calculateArea() {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        int shipNumber = getFirstCoordinate().getNumber();

        areaCoordinates.addAll(calculateUpDownArea(shipNumber));
        areaCoordinates.addAll(calculateLeftArea(shipNumber));
        areaCoordinates.addAll(calculateRightArea(shipNumber));
        return areaCoordinates;
    }

    private Set<Coordinate> calculateUpDownArea(int shipNumber) {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        for (Coordinate coordinate : getCoordinates()) {
            Character letter = coordinate.getLetter();

            try {
                Coordinate upperCoordinate = new Coordinate(letter, shipNumber + 1);
                areaCoordinates.add(upperCoordinate);
            } catch (IllegalArgumentException ignored) {
            }

            try {
                Coordinate lowerCoordinate = new Coordinate(letter, shipNumber - 1);
                areaCoordinates.add(lowerCoordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return areaCoordinates;
    }

    private Set<Coordinate> calculateLeftArea(int shipNumber) {
        char leftLetter = (char) (getFirstCoordinate().getLetter() - 1);
        return calculateVerticalArea(shipNumber, leftLetter);
    }

    private Set<Coordinate> calculateRightArea(int shipNumber) {
        char rightLetter = (char) (getLastCoordinate().getLetter() + 1);
        return calculateVerticalArea(shipNumber, rightLetter);
    }

    private Set<Coordinate> calculateVerticalArea(int shipNumber, char letter) {
        Set<Coordinate> areaCoordinates = new HashSet<>();
        for (int number = shipNumber - 1; number <= shipNumber + 1; number++) {
            try {
                Coordinate coordinate = new Coordinate(letter, number);
                areaCoordinates.add(coordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return areaCoordinates;
    }
}
