package sea_battle.controllers;


import java.util.ArrayList;

public abstract class Player {

    private String title;
    private Field field;
    private Field opponentField;
    private ArrayList<Ship> ships;
    private boolean isWin;

    public Player(String title) {
        this.title = title;
        this.field = new Field();
        this.opponentField = new Field();
        ships = new ArrayList<>();
        this.isWin = false;
    }

    public String getTitle() {
        return title;
    }

    public Field getField() {
        return field;
    }

    public Field getOpponentField() {
        return opponentField;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public boolean isWin() {
        return isWin;
    }

    public abstract boolean shot(Player opponent);

    public boolean makeShot(Player opponent, int x, int y) {
        int[][] field = opponent.getField().getField();
        int[][] opponentField = this.opponentField.getField();
        ArrayList<Ship> opponentShips = opponent.getShips();

        if (field[y][x] == 1) {
            field[y][x] = -1;
            opponentField[y][x] = -1;
            Ship ship = findShip(opponentShips, x, y);

            if (!(ship.isAfloat())) {
                markTerritory(opponentField, ship.getCoords());
                opponentShips.remove(ship);
            }

            if (opponentShips.size() <= 0) {
                this.isWin = true;
            }
            System.out.println(this.title + " hit!");
            return true;
        } else {
            field[y][x] = 2;
            opponentField[y][x] = 2;
            System.out.println(this.title + " miss!");
            return false;
        }
    }

    private void markTerritory(int[][] opponentField, ArrayList<Coordinates> coords) {
        for (Coordinates coord : coords) {
            int x = coord.getX();
            int y = coord.getY();

            markCell(opponentField, x, y);
        }
    }

    private void markCell(int[][] field, int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            if (i < 0 || i > field.length - 1) {
                continue;
            }

            for (int j = x - 1; j <= x + 1; j++) {
                if (j < 0 || j > field.length - 1) {
                    continue;
                }

                field[i][j] = -1;
            }
        }
    }

    private Ship findShip(ArrayList<Ship> ships, int x, int y) {
        Ship foundShip = null;
        for (Ship ship : ships) {
            ArrayList<Coordinates> coords = ship.getCoords();
            for (Coordinates coord : coords) {
                int coordX = coord.getX();
                int coordY = coord.getY();

                if (coordX == x && coordY == y) {
                    coord.setHit(true);
                    ship.setDecksNotHited();
                    foundShip = ship;
                    break;
                }
            }
        }

        return foundShip;
    }

}
