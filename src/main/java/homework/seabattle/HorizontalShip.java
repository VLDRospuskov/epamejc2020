package homework.seabattle;

import static homework.seabattle.Config.*;

public class HorizontalShip extends Ship {

    public HorizontalShip(Coordinate startCoordinate, int length){
        super(startCoordinate, length);
    }

    @Override
    protected void calculateAllCoordinates(Coordinate startCoordinate) {
        char startChar = startCoordinate.getLetter();
        char endChar = (char)(startChar + length - 1);
        if (endChar <= MAX_LETTER){
            for (char ch = startChar; ch <= endChar; ch++){
                Coordinate coordinate = new Coordinate(ch, startCoordinate.getNumber());
                coordinates.add(coordinate);
            }
        }
    }

    @Override
    protected void calculateArea() {
        int shipNumber = coordinates.get(0).getNumber();
        calculateUpDownArea(shipNumber);
        calculateLeftArea(shipNumber);
        calculateRightArea(shipNumber);
    }

    private void calculateUpDownArea(int shipNumber) {
        for(Coordinate coordinate : coordinates){
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
    }

    private void calculateLeftArea(int shipNumber) {
        char leftLetter = (char)(coordinates.get(0).getLetter() - 1);
        calculateVerticalArea(shipNumber, leftLetter);
    }

    private void calculateRightArea(int shipNumber) {
        char rightLetter = (char)(coordinates.get(coordinates.size() - 1).getLetter() + 1);
        calculateVerticalArea(shipNumber, rightLetter);
    }

    private void calculateVerticalArea(int shipNumber, char letter) {
        for (int number = shipNumber - 1; number <= shipNumber + 1; number++) {
            try {
                Coordinate coordinate = new Coordinate(letter, number);
                areaCoordinates.add(coordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
