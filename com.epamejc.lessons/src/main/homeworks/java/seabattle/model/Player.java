package main.homeworks.java.seabattle.model;

import main.homeworks.java.seabattle.enums.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private List<Ship> fleet = new ArrayList<>();
    private Board board;
    private Scanner sc;

    private static int count = 1;
    private final int id = count++;

    public Player() {

    }

    public Player(Scanner sc) {
        this.sc = sc;
    }

    public void createShips() {
        fleet.add(new Ship(4, sc));
        fleet.add(new Ship(3, sc));
        fleet.add(new Ship(3, sc));
        fleet.add(new Ship(2, sc));
        fleet.add(new Ship(2, sc));
        fleet.add(new Ship(2, sc));
        fleet.add(new Ship(1, sc));
        fleet.add(new Ship(1, sc));
        fleet.add(new Ship(1, sc));
        fleet.add(new Ship(1, sc));
    }

    public void setUp() {
        createShips();
        board = new Board(fleet);

        board.placeAllShips();

        board.printBoards();
    }

    public Board getBoard() {
        return board;
    }

    public List<Ship> getFleet() {
        return fleet;
    }

    public String toString() {
        return "Player " + id + " ";
    }

    public void shoot(Player enemy) {
        Set<Square> changed;
        int x;
        int y;
        do {

            if (enemy.getBoard().getFleet().isEmpty() || this.getBoard().getFleet().isEmpty()) {
                break;
            }

            do {
                System.out.println("Enter coordinates to shoot: ");
                x = sc.nextInt();
                y = sc.nextInt();
                changed = enemy.getBoard().shoot(x, y);
                this.board.placeShot(changed);
                System.out.println(this);
                this.getBoard().printBoards();
            } while (changed.isEmpty());

        } while (successfulShot(changed));
    }

    private boolean successfulShot(Set<Square> changed) {
        for (Square square : changed) {
            if (square.getStatus().equals(State.HIT)) {
                return true;
            }
        }
        return false;
    }
}
