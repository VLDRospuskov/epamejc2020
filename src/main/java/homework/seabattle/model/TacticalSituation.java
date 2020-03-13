package homework.seabattle.model;

import homework.seabattle.model.ships.HorizontalShip;
import homework.seabattle.model.ships.Ship;
import homework.seabattle.model.ships.VerticalShip;

import java.util.Arrays;

import static homework.seabattle.config.Config.*;
import static homework.seabattle.model.TacticalSituation.CellState.DAMAGED;

public class TacticalSituation {

    public enum CellState {
        UNCHECKED,
        EMPTY,
        DAMAGED
    }

    private int opponentActiveShipsCount = INITIAL_SHIPS_COUNT;

    private CellState[][] opponentSituation;

    {
        opponentSituation = new CellState[MAX_NUMBER][MAX_NUMBER];
        for (int i = 0; i < MAX_NUMBER; i++) {
            for (int j = 0; j < MAX_NUMBER; j++) {
                opponentSituation[i][j] = CellState.UNCHECKED;
            }
        }
    }

    public int getOpponentActiveShipsCount() {
        return opponentActiveShipsCount;
    }

    public CellState[][] getOpponentSituation() {
        CellState[][] states = new CellState[MAX_NUMBER][MAX_NUMBER];
        for (int i = 0; i < MAX_NUMBER; i++) {
            states[i] = Arrays.copyOf(opponentSituation[i], MAX_NUMBER);
        }
        return states;
    }

    public void setCellState(Coordinate coordinate, CellState cellState) {
        opponentSituation[coordinate.getNumber() - 1][coordinate.getLetter() - A_CHAR_OFFSET] = cellState;
    }

    public CellState getCellState(Coordinate coordinate) {
        return opponentSituation[coordinate.getNumber() - 1][coordinate.getLetter() - A_CHAR_OFFSET];
    }

    public Ship searchShip(Coordinate coordinate) {
        char letter = coordinate.getLetter();
        int number = coordinate.getNumber();
        int length = 1;

        char rightBorder = letter;
        while (rightBorder < MAX_LETTER && opponentSituation[number - 1][rightBorder + 1 - A_CHAR_OFFSET].equals(DAMAGED)) {
            rightBorder++;
            length++;
        }

        char leftBorder = letter;
        while (leftBorder > MIN_LETTER && opponentSituation[number - 1][leftBorder - 1 - A_CHAR_OFFSET].equals(DAMAGED)) {
            leftBorder--;
            length++;
        }

        if (length > 1) {
            return new HorizontalShip(new Coordinate(leftBorder, number), length);
        }

        int downBorder = number;
        while (downBorder < MAX_NUMBER && opponentSituation[downBorder][letter - A_CHAR_OFFSET].equals(DAMAGED)) {
            downBorder++;
            length++;
        }

        int upBorder = number;
        while (upBorder > MIN_NUMBER && opponentSituation[upBorder - 2][letter - A_CHAR_OFFSET].equals(DAMAGED)) {
            upBorder--;
            length++;
        }

        return new VerticalShip(new Coordinate(letter, upBorder), length);
    }

    public void decrementOpponentShipsCount() {
        opponentActiveShipsCount--;
    }
}