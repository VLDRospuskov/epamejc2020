package homeworks.seabattle_2_players;

import java.awt.*;
import java.util.ArrayList;

public class Ship {

    public ArrayList<Point> cells;
    public ArrayList<Point> hitCells = new ArrayList<>();
    public String name;

    public Ship(String name, ArrayList<Point> cells) {
        this.name = name;
        this.cells = cells;
    }

    public void destroy() {
    }

}
