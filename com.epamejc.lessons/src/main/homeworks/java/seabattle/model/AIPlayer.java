package main.homeworks.java.seabattle.model;

import main.homeworks.java.seabattle.enums.State;

import java.util.*;

import static main.homeworks.java.seabattle.enums.GameMode.SINGLEPLAYER;

public class AIPlayer extends Player {

    private List<Ship> fleet = new ArrayList<>();
    private boolean hit = false;
    private boolean wounded = false;
    private boolean vertical;
    private Board board;
    private Random rand = new Random();

    private int x;
    private int y;

    private int firstHitX = -1;
    private int firstHitY = -1;

    private List<Square> verticalShots = new ArrayList<>();
    private List<Square> horizontalShots = new ArrayList<>();
    private Set<Square> shotsPerformed = new HashSet<>();

    public void generateShips() {
        fleet.add(new Ship(4));
        fleet.add(new Ship(3));
        fleet.add(new Ship(3));
        fleet.add(new Ship(2));
        fleet.add(new Ship(2));
        fleet.add(new Ship(2));
        fleet.add(new Ship(1));
        fleet.add(new Ship(1));
        fleet.add(new Ship(1));
        fleet.add(new Ship(1));
    }

    @Override
    public void setUp() {
        generateShips();
        board = new Board(fleet);
        board.setGameMode(SINGLEPLAYER);
        board.placeAllShips();
        board.printBoards();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public List<Ship> getFleet() {
        return fleet;
    }

    @Override
    public String toString() {
        return "AIPlayer ";
    }

    @Override
    public void shoot(Player enemy) {
        Set<Square> changed;
        do {

            if (enemy.getBoard().getFleet().isEmpty() || this.getBoard().getFleet().isEmpty()) {
                break;
            }

            do {

                prepareToShoot();
                changed = enemy.getBoard().shoot(x, y);
                this.board.placeShot(changed);
                this.getBoard().printBoards();

            } while (changed.isEmpty());

        } while (successfulShot(changed));
        hit = false;
    }

    private void prepareToShoot() {
        horizontalShots.removeAll(shotsPerformed);
        verticalShots.removeAll(shotsPerformed);

        if (horizontalShots.isEmpty()) vertical = true;
        if (verticalShots.isEmpty()) vertical = false;

        prepareCoords();
    }

    private void prepareCoords() {
        if (wounded) {
            findDirection();
        } else {
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        }
    }

    private void findDirection() {
        if (vertical) {
            x = verticalShots.get(0).getX();
            y = verticalShots.get(0).getY();
        } else {
            x = horizontalShots.get(0).getX();
            y = horizontalShots.get(0).getY();
        }
    }

    private void prepareShots() {
        if (hit && !wounded) {
            horizontalShots.clear();
            verticalShots.clear();
            if (firstHitX != 9) {
                horizontalShots.add(new Square(firstHitX + 1, firstHitY));
            }
            if (firstHitX != 0) {
                horizontalShots.add(new Square(firstHitX - 1, firstHitY));
            }
            if (firstHitY != 9) {
                verticalShots.add(new Square(firstHitX, firstHitY + 1));
            }
            if (firstHitY != 0) {
                verticalShots.add(new Square(firstHitX, firstHitY - 1));
            }
        }
    }

    private boolean successfulShot(Set<Square> changed) {
        shotsPerformed.addAll(changed);
        for (Square square : changed) {
            if (square.getStatus().equals(State.HIT)) {
                hit(square);
                checkIfDestroyed(changed);
                checkVertical(square);
                checkHorizontal(square);
                return true;
            }
            removeSuccessfulShot(square);
        }
        return false;
    }

    private void removeSuccessfulShot(Square square) {
        if (wounded) {
            if (verticalShots.contains(square)) verticalShots.remove(square);
            else horizontalShots.remove(square);
        }
    }

    private void hit(Square square) {
        hit = true;
        if (!wounded) {
            firstHitX = square.getX();
            firstHitY = square.getY();
            prepareShots();
            wounded = true;
        }
    }

    private void checkVertical(Square square) {
        if (verticalShots.contains(square)) {
            vertical = true;

            if (square.getY() != 9) {
                verticalShots.add(new Square(square.getX(), square.getY() + 1));
            }
            if (square.getY() != 0) {
                verticalShots.add(new Square(square.getX(), square.getY() - 1));
            }
            verticalShots.remove(square);
        }
    }

    private void checkHorizontal(Square square) {
        if (horizontalShots.contains(square)) {
            vertical = false;
            if (square.getX() != 9) {
                horizontalShots.add(new Square(square.getX() + 1, square.getY()));
            }
            if (square.getX() != 0)
            horizontalShots.add(new Square(square.getX() - 1, square.getY()));
            horizontalShots.remove(square);
        }
    }

    private void checkIfDestroyed(Set<Square> changed) {
        if (changed.size() > 1) {
            hit = false;
            wounded = false;
            firstHitX = -1;
            firstHitY = -1;
        }
    }
}
