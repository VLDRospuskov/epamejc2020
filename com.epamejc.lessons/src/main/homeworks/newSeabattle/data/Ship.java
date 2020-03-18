package homeworks.newSeabattle.data;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;

@Data
public class Ship {

    private ArrayList<Point> cells;
    private ArrayList<Point> hitCells;

    public Ship(ArrayList<Point> cells) {
        this.cells = cells;
        this.hitCells = new ArrayList<>();
    }

    public void hit(Point p) {
        cells.remove(p);
        hitCells.add(p);
    }

    public boolean isDead() {
        return cells.isEmpty();
    }

}
