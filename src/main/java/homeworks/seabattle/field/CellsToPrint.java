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

        return getCellsShape(shipPositions, hitPositions, missPositions, deadShipPositions, shipVisibility);
    }

    private String[] getCellsShape(List<Integer> shipPositions, List<Integer> hitPositions,
                               List<Integer> missPositions, List<Integer> deadShipPositions, boolean shipVisibility) {

        int d = 0;
        int s = 0;
        int h = 0;
        int m = 0;

        String[] cells = new String[100];

        for (int i = 0; i < cells.length; i++) {

            if (isRightPosition(deadShipPositions, d, i)) {
                cells[i] = Colors.colors[2] + "□" + Colors.colors[0];
                d++;
                h++;
                s++;
            } else if (isRightPosition(hitPositions, h, i)) {
                cells[i] = Colors.colors[2] + "¤" + Colors.colors[0];
                h++;
                s++;
            } else if (isRightPosition(shipPositions, s, i) && shipVisibility) {
                cells[i] = Colors.colors[6] + "■" + Colors.colors[0];
                s++;
            } else if (isRightPosition(missPositions, m, i)) {
                cells[i] = Colors.colors[7] + "x" + Colors.colors[0];
                m++;
            } else {
                cells[i] = " ";
            }
        }
        return cells;
    }

    private boolean isRightPosition(List<Integer> positions, int positionIndex, int index) {
        return positions.size() != 0 && positionIndex < positions.size() && index == positions.get(positionIndex);
    }
}
