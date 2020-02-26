package homeworks.seabattle;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.seabattle.GameField.*;

public class Ship {

    public static ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Point> location = new ArrayList<>();
    ArrayList<Point> destroyedCells = new ArrayList<>();

    public Ship(int size) {
        boolean direction = generateDirection();
        ArrayList<Point> cells = new ArrayList<>();
        ArrayList<Boolean> possibles = new ArrayList<>();
        Point p1 = generateRandomPos();
        cells.add(p1);
        possibles.add(isPossible(p1));
        Point tmp = p1;

        for (int i = 1; i < size; i++) {
            Point p = generateNextPos(tmp, direction);
            cells.add(p);
            possibles.add(isPossible(p));
            tmp = p;
        }

        possibles.removeIf(bool -> bool);

        if (possibles.isEmpty()) {
            for (Point p: cells) {
                field[p.y][p.x] = SHIP_CHAR;
                location.add(p);
                ships.add(this);
            }
        } else {
            new Ship(size);
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

    public boolean isPossible(Point p) {
        return isInField(p) && !isNearAShip(p);
    }

    public boolean isNearAShip(Point p) {
        ArrayList<Point> nearCells = nearCells(p);

        for (Point point : nearCells) {
            if (field[point.y][point.x] == SHIP_CHAR) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Point> nearCells(Point p) {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(p.x-1, p.y+1));
        list.add(new Point(p.x, p.y+1));
        list.add(new Point(p.x+1, p.y+1));
        list.add(new Point(p.x-1, p.y));
        list.add(new Point(p.x+1, p.y));
        list.add(new Point(p.x-1, p.y-1));
        list.add(new Point(p.x, p.y-1));
        list.add(new Point(p.x+1, p.y-1));

        list.removeIf(point -> (point.x < 0 || point.x > 9) || (point.y < 0 || point.y > 9));

        return list;
    }

    public boolean isInField(Point p) {
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
