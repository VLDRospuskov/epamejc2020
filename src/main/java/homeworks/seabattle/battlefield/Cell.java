package homeworks.seabattle.battlefield;

import java.util.Comparator;
import java.util.List;

public class Cell {

    public String[] initCells(List<Integer> shipPositions, List<Integer> hitPositions,
                              List<Integer> missPositions, List<Integer> deadShipPositions, boolean shipVisibility) {

        deadShipPositions.sort(Comparator.comparingInt(a -> a));
        shipPositions.sort(Comparator.comparingInt(a -> a));
        hitPositions.sort(Comparator.comparingInt(a -> a));
        missPositions.sort(Comparator.comparingInt(a -> a));
        String[] cells = new String[100];

        int d = 0;
        int s = 0;
        int h = 0;
        int m = 0;
        for (int i = 0; i < cells.length; i++) {

            if (deadShipPositions.size() != 0 && d < deadShipPositions.size() && i == deadShipPositions.get(d)) {
                cells[i] = "□";
                d++;
                h++;
                s++;
            } else if (hitPositions.size() != 0 && h < hitPositions.size() && i == hitPositions.get(h)) {
                cells[i] = "¤";
                h++;
                s++;
            } else if (shipPositions.size() != 0 && s < shipPositions.size() && i == shipPositions.get(s)) {//&& shipVisibility) {
                cells[i] = "■";
                s++;
            } else if (missPositions.size() != 0 && m < missPositions.size() && i == missPositions.get(m)) {
                cells[i] = "x";
                m++;
            } else {
                cells[i] = " ";
            }
        }
        return cells;
    }
}
