package homeworks.seabattle_2_players;

import java.awt.*;
import java.util.ArrayList;

public class Field {

    private static final char SHIP = 'S';
    private static final char MISS = '·';
    private static final char HIT = '/';
    private static final char DESTROYED = 'X';
    private static final char EMPTY = ' ';
    private char[][] cells;
    private ArrayList<Ship> ships;

    public boolean shoot(Point p) {
        if (cells[p.y][p.x] == SHIP) {
            hit(p);
            return true;
        } else {
            miss(p);
            return false;
        }
    }

    private void hit(Point p) {
        updateShipAndField(p);
    }

    private void updateShipAndField(Point p) {
        Ship ship = getShipByLocation(p);
        ship.cells.remove(p);
        ship.hitCells.add(p);

        if (ship.cells.isEmpty()) {
            ships.remove(ship);
            updateSink(ship);
        } else {
            cells[p.y][p.x] = HIT;
        }
    }

    private void updateSink(Ship ship) {
        for (Point p : ship.hitCells) {
            cells[p.y][p.x] = DESTROYED;
            ArrayList<Point> nearCells = nearCells(p);
            for (Point point : nearCells) {
                if (cells[point.y][point.x] == ' ') {
                    cells[point.y][point.x] = MISS;
                }
            }
        }
    }

    private Ship getShipByLocation(Point givenP) {
        for (Ship ship : ships) {
            for (Point foundP: ship.cells) {
                if (givenP.equals(foundP)) {
                    return ship;
                }
            }
        }

        throw new RuntimeException("The ship is not found by location!");
    }

    private void miss(Point p) {
        char cell = cells[p.y][p.x];
        if (cell != DESTROYED && cell != HIT) {
            cells[p.y][p.x] = MISS;
        }
    }

    //CONSTRUCTOR//////////
    public Field(boolean isAutomaticCreation) {
        initializeField();
        putShips(isAutomaticCreation);
    }

    //GETTERS_SETTERS///////
    public char getCell(Point p) {
        return cells[p.y][p.x];
    }

    public char getCell(int x, int y) {
        return cells[y][x];
    }

    public char[][] getCells() {
        return cells;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    //INITIALIZATION//////////
    private void initializeField() {
        ships = new ArrayList<>();
        cells = new char[10][10];
        fillCellsWithEmptySpace();
    }

    private void fillCellsWithEmptySpace() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[j][i] = EMPTY;
            }
        }
    }

    //SHIPS_CREATION////////
    private void putShips(boolean isAutomaticCreation) {
        if (isAutomaticCreation) {
            putShipsAutomatically();
        } else {
            putShipsManually();
        }
    }

    private void putShipsAutomatically() {
        generateShips(1, 4);
        generateShips(2, 3);
        generateShips(3, 2);
        generateShips(4, 1);
    }

    private void generateShips(int amount, int size) {
        for (int i = 0; i < amount; i++) {
            generateAShip(size);
        }
    }

    private void generateAShip(int size) {
        boolean direction = generateDirection();

        ArrayList<Point> possibleCells = new ArrayList<>();

        Point p1 = generateRandomPos();
        if (isPossible(p1)) {
            possibleCells.add(p1);
        }
        Point tmp = p1;

        for (int i = 1; i < size; i++) {
            Point p = generateNextPos(tmp, direction);
            if (isPossible(p)) {
                possibleCells.add(p);
                tmp = p;
            }
        }

        if (possibleCells.size() == size) {
            for (Point p : possibleCells) {
                cells[p.y][p.x] = SHIP;
            }
            ships.add(new Ship("Random", possibleCells));
        } else {
            generateAShip(size);
        }
    }

    private void putShipsManually() {

    }

    private Point generateRandomPos() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    private boolean generateDirection() {
        return (int) (Math.random() * 2) == 0;
    }

    private boolean isPossible(Point p) {
        return isInField(p) && !isNearAShip(p);
    }

    private boolean isNearAShip(Point p) {
        ArrayList<Point> nearCells = nearCells(p);

        for (Point point : nearCells) {
            if (cells[point.y][point.x] == 'S') {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Point> nearCells(Point p) {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(p.x - 1, p.y + 1));
        list.add(new Point(p.x, p.y + 1));
        list.add(new Point(p.x + 1, p.y + 1));
        list.add(new Point(p.x - 1, p.y));
        list.add(new Point(p.x + 1, p.y));
        list.add(new Point(p.x - 1, p.y - 1));
        list.add(new Point(p.x, p.y - 1));
        list.add(new Point(p.x + 1, p.y - 1));

        list.removeIf(point -> (point.x < 0 || point.x > 9) || (point.y < 0 || point.y > 9));

        return list;
    }

    private boolean isInField(Point p) {
        return ((0 <= p.x && p.x <= 9) && (0 <= p.y && p.y <= 9));
    }

    private Point generateNextPos(Point p1, boolean direction) {
        Point p2;

        if (direction) {
            p2 = new Point(p1.x + 1, p1.y);
        } else {
            p2 = new Point(p1.x, p1.y + 1);
        }

        return p2;
    }

}
