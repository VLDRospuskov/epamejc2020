package homeworks.sea_battle.commands;

import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Field;
import homeworks.sea_battle.data.Player;
import homeworks.sea_battle.data.Ship;
import homeworks.sea_battle.enums.ShipTypes;

import java.util.ArrayList;

public interface ShipsSetterCommands {

    default void setShips(Player player) {
        ArrayList<Ship> ships = player.getPlayerShips();
        ships.addAll(createShips(player.getPlayerField(), ShipTypes.QUADRUPLE_DECK, 1));
        ships.addAll(createShips(player.getPlayerField(), ShipTypes.TRIPLE_DECK, 2));
        ships.addAll(createShips(player.getPlayerField(), ShipTypes.DOUBLE_DECK, 3));
        ships.addAll(createShips(player.getPlayerField(), ShipTypes.SINGLE_DECK, 4));
    }

    ArrayList<Ship> createShips(Field field, ShipTypes shipType, int shipQty);

    default boolean createShip(Field field, ShipTypes shipType, ArrayList<Ship> ships, ArrayList<Coordinates> decks) {
        if (checkRange(field.getField(), decks)) {
            Ship ship = new Ship(shipType, decks);
            ships.add(ship);
            setShipOnField(field.getField(), ship);
            return true;
        } else {
            decks.clear();
        }
        return false;
    }

    default void setShipOnField(int[][] field, Ship ship) {
        ArrayList<Coordinates> coords = ship.getCoords();

        coords.forEach(coordinate -> field[coordinate.getY()][coordinate.getX()] = 1);
    }

    default ArrayList<Coordinates> createDecks(int decksQty, boolean direction, int x, int y) {
        ArrayList<Coordinates> decks = new ArrayList<>();

        if (direction) {
            for (int i = 0; i < decksQty; i++) {
                decks.add(new Coordinates(x, y));
                x = x + 1;
            }

        } else {
            for (int i = 0; i < decksQty; i++) {
                decks.add(new Coordinates(x, y));
                y = y + 1;
            }

        }
        return decks;
    }

    default boolean checkRange(int[][] field, ArrayList<Coordinates> decks) {
        for (Coordinates deck : decks) {

            if (!(checkCell(field, deck.getX(), deck.getY()))) {
                return false;
            }
        }
        return true;
    }

    default boolean checkCell(int[][] field, int x, int y) {
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
