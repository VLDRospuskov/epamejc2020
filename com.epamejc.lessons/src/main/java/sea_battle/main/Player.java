package sea_battle.main;


import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public abstract class Player {

    private String title;
    private Field field;
    private Field opponentField;
    private Ship opponentHitShip;
    private ArrayList<Ship> ships;
    private Coordinates prevHit;
    private Set<Coordinates> madeShots;
    private boolean isWin;

    public Player(String title) {
        this.title = title;
        this.field = new Field();
        this.opponentField = new Field();
        this.ships = new ArrayList<>();
        this.prevHit = null;
        this.madeShots = new TreeSet<>();
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

    public Ship getOpponentHitShip() {
        return opponentHitShip;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public Coordinates getPrevHit() {
        return prevHit;
    }

    public Set<Coordinates> getMadeShots() {
        return madeShots;
    }

    public boolean isWin() {
        return isWin;
    }

    public void shipsLeft() {
        int singleDeckQty = 0;
        int doubleDeckQty = 0;
        int tripleDeckQty = 0;
        int quadrupleDeckQty = 0;

        for (Ship ship : ships) {
            switch (ship.getShipType().toString()) {
                case "SINGLE_DECK" : singleDeckQty++;
                break;
                case "DOUBLE_DECK" : doubleDeckQty++;
                break;
                case "TRIPLE_DECK" : tripleDeckQty++;
                break;
                case "QUADRUPLE_DECK" : quadrupleDeckQty++;
                break;
            }
        }

        System.out.print("Ships left: \nSingle deck: " + singleDeckQty + " Double deck: " + doubleDeckQty);
        System.out.println(" Triple deck: " + tripleDeckQty + " Quadruple deck: " + quadrupleDeckQty);
    }

    public abstract boolean shot(Player opponent);

    public boolean makeShot(Player opponent, int x, int y) {
        int[][] field = opponent.getField().getField();
        int[][] opponentField = this.opponentField.getField();
        ArrayList<Ship> opponentShips = opponent.getShips();
        madeShots.add(new Coordinates(x, y));

        if (field[y][x] == 1) {
            field[y][x] = -1;
            opponentField[y][x] = -1;
            opponentHitShip = findShip(opponentShips, x, y);
            prevHit = new Coordinates(x, y);

            if (!(opponentHitShip.isAfloat())) {
                markTerritory(opponentField, opponentHitShip.getCoords());
                opponentShips.remove(opponentHitShip);
                System.out.println("Ship was destroyed!");
            }

            if (opponentShips.size() <= 0) {
                this.isWin = true;
            }
            System.out.println(this.title + " hit!");
            return true;
        } else {
            field[y][x] = 2;
            opponentField[y][x] = 2;
            prevHit = null;
            System.out.println(this.title + " missed!");
            return false;
        }
    }

    private void markTerritory(int[][] opponentField, ArrayList<Coordinates> coords) {
        for (Coordinates coord : coords) {
            markCell(opponentField, coord.getX(), coord.getY());
        }

        for (Coordinates coord : coords) {
            opponentField[coord.getY()][coord.getX()] = -1;
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

                field[i][j] = 2;
                madeShots.add(new Coordinates(j, i));
            }
        }
    }

    private Ship findShip(ArrayList<Ship> ships, int x, int y) {
        Ship foundShip = null;
        for (Ship ship : ships) {
            ArrayList<Coordinates> coords = ship.getCoords();
            for (Coordinates coord : coords) {
                if (coord.getX() == x && coord.getY() == y) {
                    ship.setDecksNotHited();
                    foundShip = ship;
                    break;
                }
            }
        }

        return foundShip;
    }

}
