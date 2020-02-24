package homeworks.seabattle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static homeworks.seabattle.Ship.ships;
import static homeworks.seabattle.SeaBattle.score;

public class GameField {

    public static final char SHIP_CHAR = 'S';
    public static final char MISS_CHAR = '·';
    public static final char HIT_SHIP_CHAR = '/';
    public static final char DESTROYED_SHIP_CHAR = 'X';
    public static char[][] field = new char[10][10];

    public GameField() {
        fill(field);
        create_A_Ship_XXXX(field);
        create2Ships_XXX(field);
        create3Ships_XX(field);
        create4Ships_X(field);
    }

    public void show() {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int charCounter = 0;
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (char[] line: field) {
            System.out.print(chars[charCounter]);
            charCounter++;
            System.out.print("|");

            for (int i = 0; i < line.length; i++) {
                if (line[i] == SHIP_CHAR) {
                    System.out.print(" |");
                } else {
                    System.out.print(line[i] + "|");
                }
            }

            System.out.println("");
        }

        System.out.println("---------------------");
    }

    public void update(Point p) {
        if (field[p.y][p.x] == SHIP_CHAR) {
            hit(p);
        } else {
            miss(p);
        }
    }

    private void hit(Point p) {
        score++;
        Ship ship = getShipByLocation(p);
        updateShipAndField(p, ship);
    }

    private void updateShipAndField(Point p, Ship ship) {
        ship.location.remove(p);
        ship.destroyedCells.add(p);

        if (ship.location.isEmpty()) {
            ships.remove(ship);
            updateSink(ship);
        } else {
            field[p.y][p.x] = HIT_SHIP_CHAR;
        }
    }

    private void updateSink(Ship ship) {
        for (Point p : ship.destroyedCells) {
            field[p.y][p.x] = DESTROYED_SHIP_CHAR;
            ArrayList<Point> nearCells = ship.nearCells(p);
            for (Point point : nearCells) {
                if (field[point.y][point.x] == ' ') {
                    field[point.y][point.x] = MISS_CHAR;
                }
            }
        }
    }

    private Ship getShipByLocation(Point givenP) {
        for (Ship ship : ships) {
            for (Point foundP: ship.location) {
                if (givenP.equals(foundP)) {
                    return ship;
                }
            }
        }

        throw new RuntimeException("The ship is not found by location!");
    }

    private void miss(Point p) {
        field[p.y][p.x] = MISS_CHAR;
    }

    private void fill(char[][] field) {
        for (char [] line: field) {
            Arrays.fill(line, ' ');
        }
    }

    private void create_A_Ship_XXXX(char[][] field) {
        new Ship().create_XXXX(field);
    }

    private void create2Ships_XXX(char[][] field) {
        for (int i = 0; i < 2; i++) {
            new Ship().create_XXX(field);
        }
    }

    private void create3Ships_XX(char[][] field) {
        for (int i = 0; i < 3; i++) {
            new Ship().create_XX(field);
        }
    }

    private void create4Ships_X(char[][] field) {
        for (int i = 0; i < 4; i++) {
            new Ship().create_X(field);

        }
    }

}
