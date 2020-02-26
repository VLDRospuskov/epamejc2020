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
        System.out.println("  1 2 3 4 5 6 7 8 9 10       1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(chars[i]);
            System.out.print("|");
            char[] line = field[i];

            for (char c : line) {
                if (c == SHIP_CHAR) {
                    System.out.print("S|");
                } else {
                    System.out.print(c + "|");
                }
            }

            System.out.print("     " + chars[i]);
            System.out.print("|");

            for (char c : line) {
                if (c == SHIP_CHAR) {
                    System.out.print("S|");
                } else {
                    System.out.print(c + "|");
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
        updateShipAndField(p);
    }

    private void updateShipAndField(Point p) {
        Ship ship = getShipByLocation(p);
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
        char cell = field[p.y][p.x];
        if (cell != DESTROYED_SHIP_CHAR && cell != HIT_SHIP_CHAR) {
            field[p.y][p.x] = MISS_CHAR;
        }
    }

    private void fill(char[][] field) {
        for (char [] line: field) {
            Arrays.fill(line, ' ');
        }
    }

    private void create_A_Ship_XXXX(char[][] field) {
        new Ship(4);
    }

    private void create2Ships_XXX(char[][] field) {
        for (int i = 0; i < 2; i++) {
            new Ship(3);
        }
    }

    private void create3Ships_XX(char[][] field) {
        for (int i = 0; i < 3; i++) {
            new Ship(2);
        }
    }

    private void create4Ships_X(char[][] field) {
        for (int i = 0; i < 4; i++) {
            new Ship(1);
        }
    }

}
