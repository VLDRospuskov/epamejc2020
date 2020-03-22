package main.homeworks.java.seabattle.model;

import main.homeworks.java.seabattle.enums.State;

import java.util.*;

public class Ship {

    private Set<Square> ship;
    private Set<Square> aroundShip;
    private int deckNumber;

    public Ship(int deckNumber, Scanner sc) {
        this.deckNumber = deckNumber;
        ship = new HashSet<>();
        aroundShip = new HashSet<>();
        createShip(deckNumber, sc);
    }

    public Ship(int deckNumber) {
        this.deckNumber = deckNumber;
        ship = new HashSet<>();
        aroundShip = new HashSet<>();
        createShip(deckNumber);
    }

    public Set<Square> getAroundShip() {
        return aroundShip;
    }

    public boolean isDestroyed() {
        return ship.isEmpty();
    }

    public Set<Square> getShip() {
        return ship;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public void getHit(Square square) {
        square.setStatus(State.HIT);
        ship.remove(square);
        markAroundShip();
    }

    private void markAroundShip() {
        if (isDestroyed()) {
            for (Square s : aroundShip) {
                s.setStatus(State.MISS);
            }
        }
    }

    private void createShip(int deckNumber, Scanner sc) {
        System.out.println("Let's place " + deckNumber + " deck ship");
            for (int i = 0; i < deckNumber; i++) {
                System.out.println("Input coordinates for " + (i + 1) + " deck (x y)");
                int x = sc.nextInt();
                int y = sc.nextInt();
                ship.add(new Square(x, y));
            }
            checkIfShip(sc);
    }

    private void createShip(int deckNumber) {
        Random rand = new Random();
        boolean direction = rand.nextBoolean();
        int x;
        int y;

        if (direction) {
            x = rand.nextInt(10);
            y = rand.nextInt(10 - deckNumber);

        } else {
            x = rand.nextInt(10 - deckNumber);
            y = rand.nextInt(10);
        }

        for (int i = 0; i < deckNumber; i++) {
            ship.add(new Square(x, y));
            if (direction) {
                y++;
            } else {
                x++;
            }
        }
        checkIfShip();
    }

    private void checkIfShip(Scanner sc) {
        if (!isShip()) {
            System.err.println("IT'S NOT A SHIP. TRY AGAIN:");
            ship.clear();
            createShip(deckNumber, sc);
        } else {
            setShipStatus();
            squaresAroundShip();
        }
    }

    private void checkIfShip() {
        if (!isShip()) {
            ship.clear();
            createShip(deckNumber);
        } else {
            setShipStatus();
            squaresAroundShip();
        }
    }

    private void setShipStatus() {
        for (Square s : ship) {
            s.setStatus(State.DECK);
        }
    }

    private void squaresAroundShip() {
        for (Square s : ship) {
            getAvailableSquares(s);
        }
        for (Square s : ship) {
            aroundShip.remove(s);
        }
    }

    private void getAvailableSquares(Square s) {
        getRightSquare(s);
        getLeftSquare(s);
        getTopSquare(s);
        getBottomSquare(s);
        getTopRightSquare(s);
        getBottomRightSquare(s);
        getTopLeftSquare(s);
        getBottomLeftSquare(s);
    }

    private void getBottomLeftSquare(Square s) {
        if (s.getX() > 0 && s.getY() > 0) {
            aroundShip.add(new Square(s.getX() - 1, s.getY() - 1));
        }
    }

    private void getTopLeftSquare(Square s) {
        if (s.getX() > 0 && s.getY() < 9) {
            aroundShip.add(new Square(s.getX() - 1, s.getY() + 1));
        }
    }

    private void getBottomRightSquare(Square s) {
        if (s.getX() < 9 && s.getY() > 0) {
            aroundShip.add(new Square(s.getX() + 1, s.getY() - 1));
        }
    }

    private void getTopRightSquare(Square s) {
        if (s.getX() < 9 && s.getY() < 9) {
            aroundShip.add(new Square(s.getX() + 1, s.getY() + 1));
        }
    }

    private void getBottomSquare(Square s) {
        if (s.getY() > 0) {
            aroundShip.add(new Square(s.getX(), s.getY() - 1));
        }
    }

    private void getTopSquare(Square s) {
        if (s.getY() < 9) {
            aroundShip.add(new Square(s.getX(), s.getY() + 1));
        }
    }

    private void getLeftSquare(Square s) {
        if (s.getX() > 0) {
            aroundShip.add(new Square(s.getX() - 1, s.getY()));
        }
    }

    private void getRightSquare(Square s) {
        if (s.getX() < 9) {
            aroundShip.add(new Square(s.getX() + 1, s.getY()));
        }
    }

    private boolean isShip() {
        if (ship.size() != deckNumber) return false;
        int[] xs = new int[ship.size()];
        int[] ys = new int[ship.size()];
        int i = 0;
        for (Square s : ship) {
            xs[i] = s.getX();
            ys[i] = s.getY();
            i++;
        }
        Arrays.sort(xs);
        Arrays.sort(ys);
        return isValidShape(xs, ys);
    }

    private boolean isValidShape(int[] xs, int[] ys) {
        for (int j = 1; j < xs.length; j++) {
            if (xs[j - 1] == xs[j]) {
                if (Math.abs(ys[j - 1] - ys[j]) > 1) return false;
            } else {
                if (Math.abs(xs[j - 1] - xs[j]) > 1) return false;
            }
        }
        return true;
    }
}
