package homeworks.seabattle.field;

import homeworks.homework3.allInOne.Colors;

import java.util.Comparator;
import java.util.List;

public class CellsToPrint {

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
                cells[i] = Colors.colors[2] + "□" + Colors.colors[0];
                d++;
                h++;
                s++;
            } else if (hitPositions.size() != 0 && h < hitPositions.size() && i == hitPositions.get(h)) {
                cells[i] = Colors.colors[2] + "¤" + Colors.colors[0];
                h++;
                s++;
            } else if (shipPositions.size() != 0 && s < shipPositions.size() && i == shipPositions.get(s)
                    && shipVisibility) {
                cells[i] = Colors.colors[6] + "■" + Colors.colors[0];
                s++;
            } else if (missPositions.size() != 0 && m < missPositions.size() && i == missPositions.get(m)) {
                cells[i] = Colors.colors[7] + "x" + Colors.colors[0];
                m++;
            } else {
                cells[i] = " ";
            }
        }
        return cells;
    }
}
