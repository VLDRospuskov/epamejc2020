package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.Ship;
import homeworks.SeaBattle.data.enums.Chars;
import homeworks.SeaBattle.data.players.Computer;
import homeworks.SeaBattle.data.players.Player;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.SeaBattle.logic.IO.*;

public class FieldGenerator {

    private Player player;

    public FieldGenerator(Player player) {
        this.player = player;
    }

    public void generateField() {
        fillGameFieldWithEmptySpaces();
        putShips();
    }

    @SneakyThrows
    private void putShips() {
        generateShips(1, 4);
        generateShips(2, 3);
        generateShips(3, 2);
        generateShips(4, 1);
    }

    private void generateShips(int amount, int size) {
        for (int i = 0; i < amount; i++) {
            if (isAutomaticCreation()) {
                generateAShip(size);
            } else {
                inputAShip(size);
            }

        }
    }

    private void inputAShip(int size) {
        printField(player);
        ArrayList<Point> cells = inputCellsForShip(size);

        if (isPossible(cells)) {
            player.getShips().add(new Ship(cells));
            putOnField(cells);
        } else {
            System.out.println("Так корабль поставить нельзя! Еще раз.");
            inputAShip(size);
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

    private ArrayList<Point> inputCellsForShip(int size) {
        Point p = getUserShoot();
        boolean direction = getUserDirection();
        ArrayList<Point> cells = new ArrayList<>();
        cells.add(p);

        for (int i = 0; i < size - 1; i++) {
            p = generateNextPoint(p, direction);
            cells.add(p);
        }

        return cells;
    }

    @SneakyThrows
    private boolean getUserDirection() {
        String str = Helper.getString("Введите направление: ");
        switch (str) {
            case "right": {
                return true;
            }
            case "down": {
                return false;
            }
            default: {
                System.out.println("Введите right или down");
                return getUserDirection();
            }
        }
    }

    private ArrayList<Point> generateCellsForShip(int size) {
        Point p = generateRandomPos();
        boolean direction = generateDirection();
        ArrayList<Point> cells = new ArrayList<>();
        cells.add(p);

        for (int i = 0; i < size - 1; i++) {
            p = generateNextPoint(p, direction);
            cells.add(p);
        }

        return cells;
    }

    private boolean isPossible(ArrayList<Point> shipCells) {
        for (Point p : shipCells) {
            if (!Util.isPossible(p, player)) {
                return false;
            }
        }

        return true;
    }

    ////Util methods
    private boolean isAutomaticCreation() {
        return player instanceof Computer || !player.isManualShipGeneration();
    }

    private void putOnField(ArrayList<Point> cells) {
        for (Point p : cells) {
            player.getField()[p.y][p.x] = Chars.SHIP.getChar();
        }
    }

    private boolean generateDirection() {
        return (int) (Math.random() * 2) == 0;
    }

    private Point generateNextPoint(Point p, boolean direction) {
        return direction ? new Point(p.x + 1, p.y) : new Point(p.x, p.y + 1);
    }

    private Point generateRandomPos() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    private void fillGameFieldWithEmptySpaces() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                player.getField()[j][i] = Chars.EMPTY.getChar();
            }
        }
    }

}
