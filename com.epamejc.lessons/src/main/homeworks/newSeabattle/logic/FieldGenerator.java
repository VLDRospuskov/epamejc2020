package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.Ship;
import homeworks.newSeabattle.data.enums.Chars;
import homeworks.newSeabattle.data.players.Computer;
import homeworks.newSeabattle.data.players.Player;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.newSeabattle.logic.Util.*;

public class FieldGenerator {

    private Player player;
    private ArrayList<Ship> ships;
    private char[][] field;

    public void generateField(Player player) {
        this.player = player;
        this.field = generateFieldWithEmptySpaces();

        putShipsOnField();

        player.setShips(ships);
        player.setField(field);
    }

    private void putShipsOnField() {
        if (isAutomaticCreation()) {
            putShipsAutomatically();
        } else {
            putShipsManually();
        }
    }

    private char[][] generateFieldWithEmptySpaces() {
        char[][] field = new char[10][10];
        fillWithEmptySpaces(field);
        return field;
    }

    private ArrayList<Ship> generateArrayListWithShips() {
        ArrayList<Ship> ships = new ArrayList<>();

        addShips(1, 4);
        addShips(2, 3);
        addShips(3, 2);
        addShips(4, 1);

        return ships;
    }

    private void addShips(int amount, int size) {
        for (int i = 0; i < amount; i++) {
            ships.add(generateShip(size));
        }
    }

    private Ship generateShip(int size) {
        ArrayList<Point> cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cells.add(new Point(0, 0));
        }

        return new Ship(cells);
    }

    private void putShipsManually() {

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
        ArrayList<Point> cells = generateCellsForShip(size);
        if (isPossible(cells)) {
//            ships.add(cells);
            putOnField(cells);
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
            if (field[point.y][point.x] == 'S') {
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

    ////Util methods

    private boolean isAutomaticCreation() {
        return player instanceof Computer || !IO.getManualFieldCreationFromUser();
    }

    private void putOnField(ArrayList<Point> cells) {
        for (Point p : cells) {
            field[p.y][p.x] = Chars.SHIP.getChar();
        }
    }

    private boolean generateDirection() {
        return (int) (Math.random() * 2) == 0;
    }

    private boolean isPossible(Point p) {
        return isInField(p) && !isNearAShip(p);
    }

    private boolean isInField(Point p) {
        return ((0 <= p.x && p.x <= 9) && (0 <= p.y && p.y <= 9));
    }

    private Point generateNextPoint(Point p, boolean direction) {
        return direction ? new Point(p.x + 1, p.y) : new Point(p.x, p.y + 1);
    }

    private Point generateRandomPos() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    private void fillWithEmptySpaces(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[j][i] = Chars.EMPTY.getChar();
            }
        }
    }

}
