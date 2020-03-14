package homework.seabattle.view;

import homework.seabattle.model.CellState;
import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ships.Ship;

import java.util.Set;

import static homework.seabattle.config.Config.*;
import static homework.seabattle.model.CellState.State.DAMAGED;

public class Printer {
    public static void printShipsOnMap(Set<Ship> ships, Set<Coordinate> emptyCoordinates) {
        String state;
        System.out.print("  ABCDEFGHIJ");
        for (int number = 1; number <= MAX_NUMBER; number++) {
            System.out.print("\n" + number + (number != MAX_NUMBER ? " " : ""));
            for (char letter = MIN_LETTER; letter <= MAX_LETTER; letter++) {
                state = "";
                Coordinate currentCoord = new Coordinate(letter, number);
                if (emptyCoordinates.contains(currentCoord)) {
                    state = "~";
                } else {
                    for (Ship ship : ships) {
                        if (ship.contains(currentCoord)) {
                            state = "S";
                            break;
                        }
                    }
                }
                System.out.print(state);
            }
        }
        System.out.print("\n");
    }

    public static void printShootsOnMap(CellState.State[][] opponentSituation) {
        String state;
        System.out.print("  ABCDEFGHIJ");
        for (int number = 0; number < MAX_NUMBER; number++) {
            System.out.print("\n" + (number + 1) + (number != MAX_NUMBER - 1 ? " " : ""));
            for (char letter = MIN_LETTER; letter <= MAX_LETTER; letter++) {
                if (opponentSituation[number][letter - A_CHAR_OFFSET].equals(DAMAGED)) {
                    state = "X";
                } else if (opponentSituation[number][letter - A_CHAR_OFFSET].equals(CellState.State.EMPTY)) {
                    state = "~";
                } else {
                    state = "?";
                }
                System.out.print(state);
            }
        }
        System.out.println("\n");
    }
}
