package homework.seabattle.battlefield;

import java.util.Comparator;
import java.util.List;

public class Cell {

    public CellState state;

    public String[] initCells(List<Integer> shipPositions) {

        shipPositions.sort(Comparator.comparingInt(a -> a));
        String[] cells = new String[100];

        int k = 0;
        for (int i=0; i<cells.length; i++) {
            if (shipPositions.size() != 0 && k < shipPositions.size() && i == shipPositions.get(k)) {
                cells[i] = "■";
                k++;
            } else {
                cells[i] = " ";
            }
        }
        return cells;
    }
}
