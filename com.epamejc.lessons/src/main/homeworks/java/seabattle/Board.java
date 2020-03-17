package main.homeworks.java.seabattle;

import java.util.*;

import static main.homeworks.java.seabattle.GameMode.MULTIPLAYER;

public class Board {

    private static final int X_DIMENSION = 10;
    private static final int Y_DIMENSION = 10;
    private List<Ship> fleet;
    private GameMode gameMode = MULTIPLAYER;
    private Square[][] fleetBoard = new Square[X_DIMENSION][Y_DIMENSION];
    private Square[][] emptyBoard = new Square[X_DIMENSION][Y_DIMENSION];

    private List<Ship> failedToPlace = new ArrayList<>();

    public Board(List<Ship> fleet) {
        this.fleet = fleet;
        initializeBoard();
    }

    public List<Ship> getFleet() {
        return fleet;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void printBoards() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fleetBoard.length; i++) {
            for (int j = 0; j < fleetBoard[i].length; j++) {
                sb.append(fleetBoard[j][i]).append(" ");
            }
            sb.append("    ");
            for (int j = 0; j < fleetBoard[i].length; j++) {
                sb.append(emptyBoard[j][i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void placeAllShips() {
        for (Ship ship : fleet) {
            if(!isPlaced(ship)) {
                placeShip(ship);
            }
        }
        fleet.removeAll(failedToPlace);
        placeFailedShips();
    }

    public Set<Square> shoot(int x, int y) {
        List<Ship> destroyedShip = new ArrayList<>();
        Set<Square> changed = new HashSet<>();

        if (canPlaceShot(x, y)) {
            Square shot = new Square(x, y);
            shot.setStatus(State.MISS);
            changed.add(shot);
            hit(destroyedShip, changed, shot);

            fleetBoard[x][y] = shot;
            fleet.removeAll(destroyedShip);
        }
        return changed;
    }

    public void placeShot(Set<Square> changed) {
        for (Square s : changed) {
            emptyBoard[s.getX()][s.getY()] = s;
        }
    }

    private boolean canPlaceShip(Ship ship) {
        for (Ship s : fleet) {
            if (isPlaced(s)) {
                for (Square square : ship.getShip()) {
                    if (square.getX() >= 10 || square.getY() >= 10
                            || !fleetBoard[square.getX()][square.getY()].getStatus().equals(State.WATER)
                    ) {
                        return false;
                    }

                    if (s != ship && s.getAroundShip().contains(square)) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    private void initializeBoard() {
        for(int i = 0; i < fleetBoard.length; i++) {
            for( int j = 0; j < fleetBoard[i].length; j++) {
                fleetBoard[i][j] = new Square(i, j);
                emptyBoard[i][j] = new Square(i, j);
            }
        }
    }

    private void placeShip(Ship ship) {
        if (canPlaceShip(ship)) {
            for (Square square : ship.getShip()) {
                fleetBoard[square.getX()][square.getY()] = square;
            }
        } else {
            failedToPlace.add(ship);
        }
    }

    private void placeFailedShips() {
        while (!failedToPlace.isEmpty()) {
            for (Ship ship : failedToPlace) {

                if (gameMode == MULTIPLAYER) {
                    fleet.add(new Ship(ship.getDeckNumber(), new Scanner(System.in)));
                } else {
                    fleet.add(new Ship(ship.getDeckNumber()));
                }

            }
            failedToPlace.clear();
            placeAllShips();
        }
    }

    private void hit(List<Ship> destroyedShip, Set<Square> changed, Square shot) {
        for (Ship ship : fleet) {
            if (ship.getShip().contains(shot)) {
                ship.getHit(shot);
                destroyed(changed, destroyedShip, ship);
            }
        }
    }

    private void destroyed(Set<Square> changed, List<Ship> destroyedShip, Ship ship) {
        if (ship.isDestroyed()) {
            destroyedShip.add(ship);
            changed.addAll(ship.getAroundShip());
            changeAroundDestroyedShip(ship);
        }
    }

    private void changeAroundDestroyedShip(Ship ship) {
        for (Square s : ship.getAroundShip()) {
            if (!ship.getShip().contains(s)) {
                fleetBoard[s.getX()][s.getY()] = s;
            }
        }
    }

    private boolean isPlaced(Ship ship) {
        int count = 0;
        for (Square square : ship.getShip()) {
            for (int i = 0; i < fleetBoard.length; i++) {
                for (int j = 0; j < fleetBoard[i].length; j++) {
                    if (fleetBoard[j][i] == square) count++;
                }
            }
        }
        return count == ship.getDeckNumber();
    }

    private boolean canPlaceShot(int x, int y) {
        return x < 10 && x >= 0 && y < 10 && y >= 0 &&
                (fleetBoard[x][y].getStatus().equals(State.WATER) || fleetBoard[x][y].getStatus().equals(State.DECK));
    }
}
