package homeworks.seabattle_2_players;

import lombok.SneakyThrows;

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
    private int sleepTimeMs = 1500;

    //SHOOTING////////////
    @SneakyThrows
    public boolean shoot(Point p) {
        if (cells[p.y][p.x] == SHIP) {
            hit(p);
            return true;
        } else {
            miss(p);
            System.out.println("Мимо!");
            Thread.sleep(sleepTimeMs);
            return false;
        }
    }

    private void hit(Point p) throws InterruptedException {
        Ship ship = getShipByHitCell(p);
        ship.hit(p);

        if (ship.isDead()) {
            sink(ship);
            System.out.println("Убит!");
            Thread.sleep(sleepTimeMs);
        } else {
            markHitOnField(p);
            System.out.println("Попал!");
            Thread.sleep(sleepTimeMs);
        }
    }

    private void miss(Point p) {
        char cell = cells[p.y][p.x];
        if (cell != DESTROYED && cell != HIT) {
            cells[p.y][p.x] = MISS;
        }
    }

    private Ship getShipByHitCell(Point givenP) {
        for (Ship ship : ships) {
            for (Point foundP: ship.getCells()) {
                if (givenP.equals(foundP)) {
                    return ship;
                }
            }
        }

        throw new RuntimeException("The ship is not found by location!");
    }

    private void sink(Ship ship) {
        ships.remove(ship);
        markDeadShip(ship);
        markNearCellsWithDots(ship);
    }

    private void markHitOnField(Point p) {
        cells[p.y][p.x] = HIT;
    }

    private void markDeadShip(Ship ship) {
        for (Point p : ship.getHitCells()) {
            cells[p.y][p.x] = DESTROYED;
        }
    }

    private void markNearCellsWithDots(Ship ship) {
        for (Point shipCell : ship.getHitCells()) {
            ArrayList<Point> nearCells = existingCellsNear(shipCell);
            for (Point p : nearCells) {
                if (cells[p.y][p.x] == ' ') {
                    cells[p.y][p.x] = MISS;
                }
            }
        }
    }

    private void putShipsManually() {
        

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

    @SneakyThrows
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
        ArrayList<Point> shipCells = generateCellsForShip(size);
        if (isPossible(shipCells)) {
            ships.add(new Ship(shipCells));
            putOnField(shipCells);
        } else {
            generateAShip(size);
        }
    }

    private ArrayList<Point> generateCellsForShip(int size) {
        Point p = generateRandomPos();
        boolean direction = generateDirection();
        ArrayList<Point> shipCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            p = generateNextPoint(p, direction);
            shipCells.add(p);
        }

        return shipCells;
    }

    private void putOnField(ArrayList<Point> shipCells) {
        for (Point p : shipCells) {
            cells[p.y][p.x] = SHIP;
        }
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

    private boolean isPossible(ArrayList<Point> shipCells) {
        for (Point p : shipCells) {
            if (!isPossible(p)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNearAShip(Point p) {
        for (Point point : existingCellsNear(p)) {
            if (cells[point.y][point.x] == 'S') {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Point> existingCellsNear(Point p) {
        ArrayList<Point> list = getCellsAround(p);
        list.removeIf(point -> !isInField(point));
        return list;
    }

    private ArrayList<Point> getCellsAround(Point p) {
        ArrayList<Point> list = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                list.add(new Point(p.x + i, p.y + j));
            }
        }

        list.remove(p);
        return list;
    }

    private boolean isInField(Point p) {
        return ((0 <= p.x && p.x <= 9) && (0 <= p.y && p.y <= 9));
    }

    private Point generateNextPoint(Point p, boolean direction) {
        return direction ? new Point(p.x + 1, p.y) : new Point(p.x, p.y + 1);
    }

}
