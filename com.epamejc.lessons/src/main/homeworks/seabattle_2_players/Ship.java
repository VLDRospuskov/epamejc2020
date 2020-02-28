package homeworks.seabattle_2_players;

import java.awt.*;
import java.util.ArrayList;

public class Ship {

    private ArrayList<Point> cells;
    private ArrayList<Point> hitCells = new ArrayList<>();

    public Ship(ArrayList<Point> cells) {
        this.cells = cells;
    }

    public ArrayList<Point> getCells() {
        return cells;
    }

    public ArrayList<Point> getHitCells() {
        return hitCells;
    }

    public void hit(Point p) {
        cells.remove(p);
        hitCells.add(p);
    }

    public boolean isDead() {
        return cells.isEmpty();
    }
}
