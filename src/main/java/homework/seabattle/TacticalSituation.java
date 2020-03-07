package homework.seabattle;

import lombok.Data;

import java.util.Set;

import static homework.seabattle.Config.*;

@Data
public class TacticalSituation {

    enum CellState {
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

    public void setCoordinateState(Coordinate coordinate, CellState cellState) {
        opponentSituation[coordinate.getNumber()][coordinate.getLetter() - A_CHAR_OFFSET] = cellState;
    }

    public Ship searchKilledShip(Coordinate coordinate) {
        char letter = coordinate.getLetter();
        int number = coordinate.getNumber();
        int length = 1;

        char rightBorder = letter;
        while (rightBorder < MAX_LETTER && opponentSituation[number][++rightBorder].equals(CellState.DAMAGED)){
            length++;
        }

        char leftBorder = letter;
        while (leftBorder > MIN_LETTER && opponentSituation[number][++leftBorder].equals(CellState.DAMAGED)){
            length++;
        }

        if (length > 1) {
            return new HorizontalShip(new Coordinate(leftBorder, number), length);
        }

        int upBorder = number;
        while (upBorder < MAX_NUMBER && opponentSituation[++upBorder][letter].equals(CellState.DAMAGED)){
            length++;
        }

        int downBorder = number;
        while (downBorder > MIN_NUMBER && opponentSituation[++downBorder][letter].equals(CellState.DAMAGED)){
            length++;
        }

        return new VerticalShip(new Coordinate(letter, upBorder), length);
    }

    public void decrementOpponentShipsCount() {
        opponentActiveShipsCount--;
    }
}
