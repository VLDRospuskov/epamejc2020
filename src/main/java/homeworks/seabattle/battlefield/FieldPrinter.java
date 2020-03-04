package homeworks.seabattle.battlefield;

import homeworks.seabattle.Positions;

public class FieldPrinter {



    public void print () {

        Cell cellsToPrint = new Cell();
        String[] playerCells = cellsToPrint.initCells(Positions.playerShipPositions, Positions.opponentHitPositions,
                Positions.opponentMissPositions, true);
        String[] opponentCells = cellsToPrint.initCells(Positions.opponentShipPositions, Positions.playerHitPositions,
                Positions.playerMissPositions, true);

        System.out.println("      " + "A   B   C   D   E   F   G   H   Y   J"
                + "          " + "A   B   C   D   E   F   G   H   Y   J");
        System.out.println("  " + "  .   .   .   .   .   .   .   .   .   .   ."
                + "    " + "  .   .   .   .   .   .   .   .   .   .   .");

        for (int i=0; i<10; i++) {
            int row = i + 1;
            if (i == 9) {
                System.out.printf(row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s ."
                        + "  " + row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s .\n",
                        playerCells[90], playerCells[91], playerCells[92], playerCells[93], playerCells[94],
                        playerCells[95], playerCells[96], playerCells[97], playerCells[98], playerCells[99],
                        opponentCells[90], opponentCells[91], opponentCells[92], opponentCells[93], opponentCells[94],
                        opponentCells[95], opponentCells[96], opponentCells[97], opponentCells[98], opponentCells[99]);
                continue;
            }
            System.out.printf(" " + row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s ."
                    + "   " + row + "  . %s . %s . %s . %s . %s . %s . %s . %s . %s . %s .\n",
                    playerCells[i*10], playerCells[i*10+1], playerCells[i*10+2], playerCells[i*10+3], playerCells[i*10+4],
                    playerCells[i*10+5], playerCells[i*10+6], playerCells[i*10+7], playerCells[i*10+8], playerCells[i*10+9],
                    opponentCells[i*10], opponentCells[i*10+1], opponentCells[i*10+2], opponentCells[i*10+3], opponentCells[i*10+4],
                    opponentCells[i*10+5], opponentCells[i*10+6], opponentCells[i*10+7], opponentCells[i*10+8], opponentCells[i*10+9]);
        }
    }

}
