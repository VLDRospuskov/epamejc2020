package homeworks.sea_battle.commands;

import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Player;
import homeworks.sea_battle.data.Ship;

import java.util.ArrayList;
import java.util.Set;

public interface PlayerShootingCommands {

    boolean shot(Player player, Player opponent);

    default boolean makeShot(Player player, Player opponent, int x, int y) {
        int[][] field = opponent.getPlayerField().getField();
        int[][] closedField = player.getOpponentField().getField();

        if (field[y][x] == 1) {
            field[y][x] = -1;
            closedField[y][x] = -1;

            System.out.println("Ship was hit!");

            player.setLastHitShip(findShip(opponent.getPlayerShips(), x, y));
            player.getLastHitShip().reduceDecksAlive();

            checkShipIsAfloat(player, opponent, closedField);
            setPlayerIsWinIfNeeded(player, opponent);

            return true;
        } else {
            field[y][x] = 2;
            closedField[y][x] = 2;

            System.out.println(player.getName() + " missed!");

            return false;
        }
    }

    default void setPlayerIsWinIfNeeded(Player player, Player opponent) {
        if (opponent.getPlayerShips().size() == 0) {
            player.setWin(true);
        }
    }

    default void checkShipIsAfloat(Player player, Player opponent, int[][] closedField) {
        if (!(player.getLastHitShip().isAfloat())) {
            markTerritory(player, closedField, player.getLastHitShip().getCoords());
            opponent.getPlayerShips().remove(player.getLastHitShip());
            System.out.println("Ship was destroyed!");
        }
    }

    default void markTerritory(Player player, int[][] closedField, ArrayList<Coordinates> coords) {
        for (Coordinates coord : coords) {
            markCell(player.getMadeShots(), closedField, coord.getX(), coord.getY());
        }

        for (Coordinates coord : coords) {
            closedField[coord.getY()][coord.getX()] = -1;
        }
    }

    default void markCell(Set<Coordinates> madeShots, int[][] field, int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            if (i < 0 || i > field.length - 1) {
                continue;
            }

            for (int j = x - 1; j <= x + 1; j++) {
                if (j < 0 || j > field.length - 1) {
                    continue;
                }

                field[i][j] = 2;
                madeShots.add(new Coordinates(j, i));
            }
        }
    }

    default Ship findShip(ArrayList<Ship> ships, int x, int y) {
        Ship foundShip = null;
        for (Ship ship : ships) {
            ArrayList<Coordinates> coords = ship.getCoords();
            if (foundShip != null) {
                break;
            }
            for (Coordinates coord : coords) {
                if (coord.getX() == x && coord.getY() == y) {
                    foundShip = ship;
                    break;
                }
            }
        }
        return foundShip;
    }
}
