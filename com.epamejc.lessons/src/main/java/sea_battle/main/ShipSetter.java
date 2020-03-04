package sea_battle.main;

import sea_battle.utils.RandomGenerator;
import sea_battle.enums.ShipTypes;

import java.util.ArrayList;

public class ShipSetter {

    public void setShips(Player player) {
        ArrayList<Ship> ships = player.getShips();
        ships.addAll(createShips(player.getField(), ShipTypes.QUADRUPLE_DECK, 1));
        ships.addAll(createShips(player.getField(), ShipTypes.TRIPLE_DECK, 2));
        ships.addAll(createShips(player.getField(), ShipTypes.DOUBLE_DECK, 3));
        ships.addAll(createShips(player.getField(), ShipTypes.SINGLE_DECK, 4));
    }

    private ArrayList<Ship> createShips(Field field, ShipTypes decksQty, int shipsQty) {
        ArrayList<Ship> ships = new ArrayList<>();

        for (int i = 0; i < shipsQty; i++) {
            ArrayList<Coordinates> coords = createDecks(field, decksQty.getValue());
            ships.add(new Ship(decksQty, coords));
        }

        return ships;
    }

    private ArrayList<Coordinates> createDecks(Field field, int decksQty) {
        ArrayList<Coordinates> decks = new ArrayList<>();

        while (true) {
            int[] coords = RandomGenerator.generateCoordinates();
            boolean direction = RandomGenerator.generateDirection();

            int[][] checkedDecks = createDecks(decksQty, direction, coords[1], coords[0]);

            if (checkDecks(field.getField(), checkedDecks)) {
                for (int[] checkedDeck : checkedDecks) {
                    int X = checkedDeck[1];
                    int Y = checkedDeck[0];

                    decks.add(new Coordinates(X, Y));
                    field.getField()[Y][X] = 1;
                }
                break;
            }
        }
        return decks;
    }

    private int[][] createDecks(int decksQty, boolean direction, int x, int y) {
        int[][] decks = new int[decksQty][];

        while (x + decksQty > 9 || y + decksQty > 9) {
            int[] coord = RandomGenerator.generateCoordinates();
            x = coord[1];
            y = coord[0];
        }

        if (direction) {
            for (int i = 0; i < decksQty; i++) {
                x = x + 1;
                decks[i] = new int[] {y, x};
            }

        } else {
            for (int i = 0; i < decksQty; i++) {
                y = y + 1;
                decks[i] = new int[] {y, x};
            }

        }
        return decks;
    }

    private boolean checkDecks (int[][] field, int[][] decks) {
        for (int[] deck : decks) {
            int x = deck[1];
            int y = deck[0];

            if (!(checkCell(field, x, y))) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCell(int[][] field, int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            if (i < 0 || i > field.length - 1) {
                continue;
            }

            for (int j = x - 1; j <= x + 1; j++) {
                if (j < 0 || j > field.length - 1) {
                    continue;
                }

                if (field[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
