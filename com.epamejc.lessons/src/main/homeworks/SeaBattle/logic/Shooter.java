package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.Ship;
import homeworks.SeaBattle.data.enums.Chars;
import homeworks.SeaBattle.data.enums.Messages;
import homeworks.SeaBattle.data.players.Player;
import homeworks.SeaBattle.data.players.User;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.SeaBattle.data.StaticVariables.TOTAL_SCORE;
import static homeworks.SeaBattle.data.StaticVariables.sleepTimeMs;
import static homeworks.SeaBattle.logic.IO.printFields;
import static homeworks.SeaBattle.logic.Util.isInField;

public class Shooter {

    private Player hunter;
    private Player target;

    public Shooter(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.isActive()) {
                hunter = player;
            } else {
                target = player;
            }
        }
    }

    public void keepShooting() {
        if (hunter instanceof User) {
            userKeepShooting();
        } else {
            computerKeepShooting();
        }

        System.out.println("-----------------------------------");
    }

    @SneakyThrows
    private void computerKeepShooting() {
        boolean isHit;

        do {
            System.out.println("It's computer's turn!");
            Point p = getComputerSmartShoot();
            isHit = shoot(p);
            if (winningCondition()) {
                break;
            }
        } while (isHit);

        System.out.println("Computer's turn is finished.");
        Thread.sleep(sleepTimeMs);
    }

    public Point getComputerSmartShoot() {
        ArrayList<Point> hitCells = findHitShipCells();

        switch (hitCells.size()) {
            case 0: {
                return getRandomShot();
            }
            case 1: {
                return getComputerNearShot(hitCells);
            }
            default: {
                return getComputerContinuedShot(hitCells);
            }
        }
    }

    private Point getComputerContinuedShot(ArrayList<Point> hitCells) {
        Point p1 = hitCells.get(0);
        Point p2 = hitCells.get(1);
        int lowestY = p1.y;
        int highestY = p1.y;
        int lowestX = p1.x;
        int highestX = p1.x;

        boolean horizontalShip = false;
        if (p1.x != p2.x) {
            horizontalShip = true;
        }

        for (Point p : hitCells) {
            if (p.x > highestX) {
                highestX = p.x;
            }
            if (p.x < lowestX) {
                lowestX = p.x;
            }
            if (p.y > highestY) {
                highestY = p.y;
            }
            if (p.y < lowestY) {
                lowestY = p.y;
            }
        }

        ArrayList<Point> probablePoints = new ArrayList<>();
        if (horizontalShip) {
            probablePoints.add(new Point(highestX + 1, p1.y));
            probablePoints.add(new Point(lowestX - 1, p1.y));
        } else {
            probablePoints.add(new Point(p1.x, highestY + 1));
            probablePoints.add(new Point(p1.x, lowestY - 1));
        }

        removePointsThatCantBeHit(probablePoints);
        return randomFrom(probablePoints);
    }

    private void removePointsThatCantBeHit(ArrayList<Point> points) {
        points.removeIf(point -> !isInField(point)
                || target.getField()[point.y][point.x] == Chars.MISS.getChar()
                || target.getField()[point.y][point.x] == Chars.HIT.getChar()
                || target.getField()[point.y][point.x] == Chars.DESTROYED.getChar());
    }

    private Point getRandomShot() {
        ArrayList<Point> availablePoints = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (target.getField()[j][i] == Chars.EMPTY.getChar()
                        || target.getField()[j][i] == Chars.SHIP.getChar()) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return randomFrom(availablePoints);
    }

    private Point randomFrom(ArrayList<Point> points) {
        return points.get((int) (Math.random() * points.size()));
    }

    private Point getComputerNearShot(ArrayList<Point> hitCells) {
        ArrayList<Point> aims = new ArrayList<>();
        for (Point p : hitCells) {
            aims.add(new Point(p.x - 1, p.y));
            aims.add(new Point(p.x + 1, p.y));
            aims.add(new Point(p.x, p.y - 1));
            aims.add(new Point(p.x, p.y + 1));
        }

        removePointsThatCantBeHit(aims);
        return randomFrom(aims);
    }

    private ArrayList<Point> findHitShipCells() {
        ArrayList<Point> hitShipPoints = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (target.getField()[j][i] == Chars.HIT.getChar()) {
                    hitShipPoints.add(new Point(i, j));
                }
            }
        }

        return hitShipPoints;


    }

    private void userKeepShooting() {
        boolean isHit;

        do {
            printFields(hunter, target);
            Point p = IO.getUserShoot();
            isHit = shoot(p);
            if (winningCondition()) {
                break;
            }
        } while (isHit);

        Helper.getString(Messages.USER_TURN_FINISHED.toString());
    }

    //SHOOTING////////////
    @SneakyThrows
    public boolean shoot(Point p) {
        if (target.getField()[p.y][p.x] == Chars.SHIP.getChar()) {
            hit(p);
            increaseScore();
            return true;
        } else {
            miss(p);
            System.out.println(Messages.MISS);
            Thread.sleep(sleepTimeMs);
            return false;
        }
    }

    private void increaseScore() {
        int score = hunter.getScore();
        hunter.setScore(++score);
        System.out.println(score);
    }

    private void hit(Point p) throws InterruptedException {
        Ship ship = getShipByHitCell(p);
        ship.hit(p);

        if (ship.isDead()) {
            sink(ship);
            System.out.println(Messages.DESTROYED);
        } else {
            markHitOnField(p);
            System.out.println(Messages.HIT);
        }

        Thread.sleep(sleepTimeMs);
    }

    private void miss(Point p) {
        char cell = target.getField()[p.y][p.x];
        if (cell != Chars.DESTROYED.getChar() && cell != Chars.HIT.getChar()) {
            target.getField()[p.y][p.x] = Chars.MISS.getChar();
        }
    }

    private Ship getShipByHitCell(Point givenP) {
        for (Ship ship : target.getShips()) {
            for (Point foundP : ship.getCells()) {
                if (givenP.equals(foundP)) {
                    return ship;
                }
            }
        }

        throw new RuntimeException("The ship is not found by location!");
    }

    private void sink(Ship ship) {
        target.getShips().remove(ship);
        markDeadShip(ship);
        markNearCellsWithDots(ship);
    }

    private void markHitOnField(Point p) {
        target.getField()[p.y][p.x] = Chars.HIT.getChar();
    }

    private void markDeadShip(Ship ship) {
        for (Point p : ship.getHitCells()) {
            target.getField()[p.y][p.x] = Chars.DESTROYED.getChar();
        }
    }

    private void markNearCellsWithDots(Ship ship) {
        for (Point shipCell : ship.getHitCells()) {
            ArrayList<Point> nearCells = Util.existingCellsNear(shipCell);
            for (Point p : nearCells) {
                if (target.getField()[p.y][p.x] == ' ') {
                    target.getField()[p.y][p.x] = Chars.MISS.getChar();
                }
            }
        }
    }

    private boolean winningCondition() {
        return hunter.getScore() == TOTAL_SCORE;
    }

}
