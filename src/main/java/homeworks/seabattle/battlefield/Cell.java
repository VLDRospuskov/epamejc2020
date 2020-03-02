package homeworks.seabattle.battlefield;

import java.util.Comparator;
import java.util.List;

public class Cell {

    public String[] initCells(List<Integer> shipPositions, List<Integer> hitPositions,
                              List<Integer> missPositions, boolean shipVisibility) {

        shipPositions.sort(Comparator.comparingInt(a -> a));
        hitPositions.sort(Comparator.comparingInt(a -> a));
        missPositions.sort(Comparator.comparingInt(a -> a));
        String[] cells = new String[100];

        int s = 0;
        int h = 0;
        int m = 0;
        for (int i=0; i<cells.length; i++) {
            if (hitPositions.size() != 0 && h < hitPositions.size() && i == hitPositions.get(h)) {
                cells[i] = "◻";
                h++;
            } else if (shipPositions.size() != 0 && s < shipPositions.size() && i == shipPositions.get(s)) { //&& shipVisibility) {
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
