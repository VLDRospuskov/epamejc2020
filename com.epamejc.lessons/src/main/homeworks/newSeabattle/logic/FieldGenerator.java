package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.Ship;
import homeworks.newSeabattle.data.enums.Chars;
import homeworks.newSeabattle.data.players.Computer;
import homeworks.newSeabattle.data.players.Player;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

public class FieldGenerator {

    private Player player;

    public void generateField(Player player) {
        this.player = player;
        fillGameFieldWithEmptySpaces(player);
        putShipsOnField();
    }

    private void putShipsOnField() {
        if (isAutomaticCreation()) {
            putShipsAutomatically();
        } else {
            putShipsManually();
        }
    }

    private void putShipsManually() {
        System.out.println("Not ready yet!");
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
            player.getShips().add(new Ship(cells));
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
            if (player.getField()[point.y][point.x] == 'S') {
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
            player.getField()[p.y][p.x] = Chars.SHIP.getChar();
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

    private void fillGameFieldWithEmptySpaces(Player player) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                player.getField()[j][i] = Chars.EMPTY.getChar();
            }
        }
    }

}
