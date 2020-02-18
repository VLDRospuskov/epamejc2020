package homework.seabattle.battlefield;

import java.util.List;

public class Field {

    public void printField (List<Integer> shipPositions) {

        Cell cell = new Cell();
        String[] cells = cell.initCells(shipPositions);

        System.out.println("      " + "A   B   C   D   E   F   G   H   Y   J"
                + "          " + "A   B   C   D   E   F   G   H   Y   J");
        System.out.println("  " + "  .   .   .   .   .   .   .   .   .   .   ."
                + "    " + "  .   .   .   .   .   .   .   .   .   .   .");

        for (int i=0; i<10; i++) {
            int row = i + 1;
            if (i == 9) {
                System.out.printf(row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s ."
                        + "  " + row + "  .   .   .   .   .   .   .   .   .   .   .\n",
                        cells[90], cells[91], cells[92], cells[93], cells[94],
                        cells[95], cells[96], cells[97], cells[98], cells[99]);
                continue;
            }
            System.out.printf(" " + row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s ."
                    + "   " + row + "  .   .   .   .   .   .   .   .   .   .   .\n",
                    cells[i*10+0], cells[i*10+1], cells[i*10+2], cells[i*10+3], cells[i*10+4],
                    cells[i*10+5], cells[i*10+6], cells[i*10+7], cells[i*10+8], cells[i*10+9]);
        }
    }

}
