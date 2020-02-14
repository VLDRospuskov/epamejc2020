package homework.homework7.battlefield;

public class Cell {

    public CellState state;
//    public String[] cells;

    public String[] initCells() {

        String[] cells = new String[100];
        for (int i=0; i<cells.length; i++) {
                cells[i] = "*";
        }
        return cells;
    }
}
