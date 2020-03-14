package homework.seabattle.model;

import homework.seabattle.model.ships.HorizontalShip;
import homework.seabattle.model.ships.Ship;
import homework.seabattle.model.ships.VerticalShip;

import java.util.Arrays;

import static homework.seabattle.config.Config.*;
import static homework.seabattle.model.CellState.State.DAMAGED;

public class TacticalSituation {

    private int opponentActiveShipsCount = INITIAL_SHIPS_COUNT;

    private CellState.State[][] opponentSituation;

    {
        opponentSituation = new CellState.State[MAX_NUMBER][MAX_NUMBER];
        for (int i = 0; i < MAX_NUMBER; i++) {
            for (int j = 0; j < MAX_NUMBER; j++) {
                opponentSituation[i][j] = CellState.State.UNCHECKED;
            }
        }
    }

    public int getOpponentActiveShipsCount() {
        return opponentActiveShipsCount;
    }

    public CellState.State[][] getOpponentSituation() {
        CellState.State[][] states = new CellState.State[MAX_NUMBER][MAX_NUMBER];
        for (int i = 0; i < MAX_NUMBER; i++) {
            states[i] = Arrays.copyOf(opponentSituation[i], MAX_NUMBER);
        }
        return states;
    }

    public void setCellState(Coordinate coordinate, CellState.State cellState) {
        opponentSituation[coordinate.getNumber() - 1][coordinate.getLetter() - A_CHAR_OFFSET] = cellState;
    }

    public CellState.State getCellState(Coordinate coordinate) {
        return opponentSituation[coordinate.getNumber() - 1][coordinate.getLetter() - A_CHAR_OFFSET];
    }

    public Ship searchShip(Coordinate coordinate) {
        char letter = coordinate.getLetter();
        int number = coordinate.getNumber();

        Ship ship = searchHorizontalShip(letter, number);

        if (ship != null)
            return ship;

        return searchVerticalShip(letter, number);
    }

    private Ship searchHorizontalShip(char coordinateLetter, int coordinateNumber) {
        int length = 1;

        char rightBorder = coordinateLetter;
        while (rightBorder < MAX_LETTER
                && opponentSituation[coordinateNumber - 1][rightBorder + 1 - A_CHAR_OFFSET].equals(DAMAGED)) {
            rightBorder++;
            length++;
        }

        char leftBorder = coordinateLetter;
        while (leftBorder > MIN_LETTER
                && opponentSituation[coordinateNumber - 1][leftBorder - 1 - A_CHAR_OFFSET].equals(DAMAGED)) {
            leftBorder--;
            length++;
        }

        if (length > 1) {
            return new HorizontalShip(new Coordinate(leftBorder, coordinateNumber), length);
        }
        return null;
    }

    private Ship searchVerticalShip(char coordinateLetter, int coordinateNumber) {
        int length = 1;

        int downBorder = coordinateNumber;
        while (downBorder < MAX_NUMBER
                && opponentSituation[downBorder][coordinateLetter - A_CHAR_OFFSET].equals(DAMAGED)) {
            downBorder++;
            length++;
        }

        int upBorder = coordinateNumber;
        while (upBorder > MIN_NUMBER
                && opponentSituation[upBorder - 2][coordinateLetter - A_CHAR_OFFSET].equals(DAMAGED)) {
            upBorder--;
            length++;
        }

        return new VerticalShip(new Coordinate(coordinateLetter, upBorder), length);
    }

    public void decrementOpponentShipsCount() {
        opponentActiveShipsCount--;
    }
}