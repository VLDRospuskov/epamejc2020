package homeworks.seabattle;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.seabattle.GameField.*;

public class Ship {

    public static String[] DIRECTIONS = {"left", "right", "up", "down"};
    public static ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Point> location = new ArrayList<>();
    ArrayList<Point> destroyedCells = new ArrayList<>();

    public void create_XXXX(char[][] field) {
        String direction = generateDirection();
        Point p1 = generateRandomPos();
        Point p2 = generateNextPos(p1, direction);
        Point p3 = generateNextPos(p2, direction);
        Point p4 = generateNextPos(p3, direction);

        if (isPossible(p1) && isPossible(p2) && isPossible(p3) && isPossible(p4)) {
            field[p1.y][p1.x] = SHIP_CHAR;
            field[p2.y][p2.x] = SHIP_CHAR;
            field[p3.y][p3.x] = SHIP_CHAR;
            field[p4.y][p4.x] = SHIP_CHAR;
            location.add(p1);
            location.add(p2);
            location.add(p3);
            location.add(p4);
            ships.add(this);
        } else {
            create_XXXX(field);
        }
    }

    public void create_XXX(char[][] field) {
        String direction = generateDirection();
        Point p1 = generateRandomPos();
        Point p2 = generateNextPos(p1, direction);
        Point p3 = generateNextPos(p2, direction);

        if (isPossible(p1) && isPossible(p2) && isPossible(p3)) {
            field[p1.y][p1.x] = SHIP_CHAR;
            field[p2.y][p2.x] = SHIP_CHAR;
            field[p3.y][p3.x] = SHIP_CHAR;
            location.add(p1);
            location.add(p2);
            location.add(p3);
            ships.add(this);
        } else {
            create_XXX(field);
        }
    }

    public void create_XX(char[][] field) {
        String direction = generateDirection();
        Point p1 = generateRandomPos();
        Point p2 = generateNextPos(p1, direction);

        if (isPossible(p1) && isPossible(p2)) {
            field[p1.y][p1.x] = SHIP_CHAR;
            field[p2.y][p2.x] = SHIP_CHAR;
            location.add(p1);
            location.add(p2);
            ships.add(this);
        } else {
            create_XX(field);
        }
    }

    public void create_X(char[][] field) {
        String direction = generateDirection();
        Point p1 = generateRandomPos();

        if (isPossible(p1)) {
            field[p1.y][p1.x] = SHIP_CHAR;
            location.add(p1);
            ships.add(this);
        } else {
            create_X(field);
        }
    }

    private Point generateRandomPos() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    private String generateDirection() {
        int n = (int) (Math.random() * 4);
        return DIRECTIONS[n];
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

    private Point generateNextPos(Point p1, String direction) {
        Point p2;

        switch (direction) {
            case "left": {
                p2 = new Point(p1.x - 1, p1.y);
                break;
            }
            case "right": {
                p2 = new Point(p1.x + 1, p1.y);
                break;
            }
            case "up": {
                p2 = new Point(p1.x, p1.y + 1);
                break;
            }
            case "down": {
                p2 = new Point(p1.x, p1.y - 1);
                break;
            }
            default: {
                p2 = p1;
                System.out.println("Something went wrong with generating next pos!");
            }
        }

        return p2;
    }

}
