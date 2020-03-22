package seabattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

class User {
    private ArrayList<Ships> ships = new ArrayList<>();
    private Pole enemyPole = new Pole();
    private ArrayList<Integer> RemainingShips = new ArrayList<>();

    User() {
        this.RemainingShips.add(Settings.SHIP_TYPE_1_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_2_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_3_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_4_COUNT);
    }

    boolean isAllShipOnDesk() {
        return (Collections.max(RemainingShips) == 0);
    }

    boolean isHit(int x, int y) {
         return ships.stream().anyMatch(ship -> ship.isHit(x, y));
    }

    boolean isDead(int x, int y) {
        return ships.get(findShipSell(x, y, true)).isDead();
    }

    boolean isEnemyWin() {
        return IntStream.range(0, ships.size()).allMatch(i -> ships.get(i).isDead());
    }

    boolean addShip(int type, int x1, int y1, int x2, int y2) {
        int typeOfSHip = type - 1;
        if ((typeOfSHip >= 0) && (typeOfSHip <= 3) && (RemainingShips.get(typeOfSHip) > 0)) {
            if (isCorrectCoords(typeOfSHip, x1, y1, x2, y2) && (inPole(x2, y2) && (inPole(x1, y1)))) {
                ArrayList<Coordinates> coordinates = makeCoordinates(x1, y1, x2, y2);
                if (noShipsNearby(coordinates)) {
                    ships.add(new Ships(coordinates));
                    return true;
                }
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void printEnemyPole() {
        System.out.println(enemyPole.printPole());
    }

    boolean inPole(int x, int y) {
        return (x >= 0 && (x < 10) && (y >= 0) && (y < 10));
    }

    void ShipSet(int type) {
        int typeOfSHip = type - 1;
        RemainingShips.set((typeOfSHip), (RemainingShips.get(typeOfSHip)) - 1);
    }

    ArrayList<Coordinates> getShipCoordinates(int x, int y) {
        return ships.get(findShipSell(x, y, true)).getShipCoordinates();
    }

    void addEnemyPartShipToPole(int x, int y) {
        enemyPole.addShipPart(x, y);
    }

    void addEnemyShipToPole(ArrayList<Coordinates> ship) {
        ship.forEach(coordinates -> enemyPole.addShipPart(coordinates.getX(), coordinates.getY()));
    }

    void hitPass(int x, int y) {
        enemyPole.addHitPass(x, y);
    }

    private int findShipSell(int x, int y, boolean hit) {
        return ships.stream().mapToInt(ship -> ship.isThisRightShip(x, y, hit))
                .filter(cell -> cell >= 0).findFirst().orElse(-1);
    }

    private boolean noShipsNearby(ArrayList<Coordinates> coordinates) {
        ArrayList<Coordinates> badCoordinates = new ArrayList<>();
        coordinates.stream().map(this::CubeFromCoordinates).forEach(badCoordinates::addAll);
        return badCoordinates.stream()
                .noneMatch(badCoordinate
                        -> findShipSell(badCoordinate.getX(), badCoordinate.getY(), false) != (-1));
    }

    private ArrayList<Coordinates> CubeFromCoordinates(Coordinates coordinates) {
        ArrayList<Coordinates> tempCoords = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int x = DigitalAround(coordinates.getX(), j);
                int y = DigitalAround(coordinates.getY(), i);
                if ((inPole(x, y))&&!(tempCoords.contains(new Coordinates(x, y)))) {
                    tempCoords.add(new Coordinates(x, y));
                }
            }
        return tempCoords;
    }

    private int DigitalAround(int d, int i) {
        switch (i) {
            case 1:
                return d;
            case 2:
                return d + 1;
            default:
                return d - 1;
        }
    }

    private boolean isCorrectCoords(int type, int x1, int y1, int x2, int y2) {
        return ((x1 == x2) && Math.abs(y1 - y2) == type) || ((y2 == y1) && Math.abs(x1 - x2) == type);

    }

    private ArrayList<Coordinates> makeCoordinates(int x1, int y1, int x2, int y2) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        if (x1 > x2) {
            int t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y1 > y2) {
            int t = y1;
            y1 = y2;
            y2 = t;
        }
        int type;
        if (x1 == x2) {
            type = y2 - y1 + 1;
            for (int i = 0; i < type; i++) {
                coordinates.add(new Coordinates(x1, y1 + i));
            }
        } else {
            type = x2 - x1 + 1;
            for (int i = 0; i < type; i++) coordinates.add(new Coordinates(x1 + i, y1));
        }
        return coordinates;
    }

}
