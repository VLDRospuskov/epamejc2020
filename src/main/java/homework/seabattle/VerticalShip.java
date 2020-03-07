package homework.seabattle;

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
                coordinates.add(coordinate);
            }
        }
    }

    @Override
    protected void calculateArea() {
        char shipLetter = coordinates.get(0).getLetter();
        calculateLeftRightArea(shipLetter);
        calculateUpArea(shipLetter);
        calculateDownArea(shipLetter);
    }

    private void calculateLeftRightArea(char shipLetter) {
        for(Coordinate coordinate : coordinates){
            int number = coordinate.getNumber();
            try {
                Coordinate leftCoordinate = new Coordinate((char)(shipLetter - 1), number);
                areaCoordinates.add(leftCoordinate);
            } catch (IllegalArgumentException ignored) {
            }

            try {
                Coordinate rightCoordinate = new Coordinate((char)(shipLetter + 1), number);
                areaCoordinates.add(rightCoordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void calculateUpArea(char shipLetter) {
        int upNumber = coordinates.get(0).getNumber() - 1;
        calculateHorizontalArea(shipLetter, upNumber);
    }

    private void calculateDownArea(char shipLetter) {
        int downNumber = coordinates.get(coordinates.size() - 1).getNumber() + 1;
        calculateHorizontalArea(shipLetter, downNumber);
    }

    private void calculateHorizontalArea(char shipLetter, int number) {
        for (char letter = (char) (shipLetter - 1); letter <= shipLetter + 1; letter++) {
            try {
                Coordinate coordinate = new Coordinate(letter, number);
                areaCoordinates.add(coordinate);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

}
