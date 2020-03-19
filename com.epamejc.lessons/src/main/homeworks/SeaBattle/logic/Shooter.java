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

import static homeworks.SeaBattle.data.StaticVariables.*;
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
    }

    @SneakyThrows
    private void computerKeepShooting() {
        boolean isHit;

        do {
            System.out.println(Messages.COMPUTER_TURN_STARTED);
            Point p = getComputerSmartShootingPoint();
            isHit = shoot(p);
            if (winningCondition()) {
                isHit = false;
            }
        } while (isHit);

        System.out.println(Messages.COMPUTER_TURN_FINISHED);
        Thread.sleep(sleepTimeMs);
        System.out.println("-----------------------------------");
    }

    public Point getComputerSmartShootingPoint() {
        ArrayList<Point> hitCells = findHitShipPoints();
        switch (findHitShipPoints().size()) {
            case 0: {
                return getRandomShot();
            }
            case 1: {
                return getComputerCrossShot(hitCells);
            }
            default: {
                return getComputerContinuedShot(hitCells);
            }
        }
    }

    private Point getComputerContinuedShot(ArrayList<Point> hitCells) {
        boolean isHorizontal = isShipHorizontal(hitCells);
        int[] edges = findMinMaxCoordinates(hitCells);
        ArrayList<Point> probablePoints = getProbableTargetPoints(edges, isHorizontal);
        removePointsThatCannotBeHit(probablePoints);
        return getRandom(probablePoints);
    }

    private ArrayList<Point> getProbableTargetPoints(int[] edges, boolean isHorizontal) {
        ArrayList<Point> probablePoints = new ArrayList<>();

        if (isHorizontal) {
            probablePoints.add(new Point(edges[0] + 1, edges[2]));
            probablePoints.add(new Point(edges[1] - 1, edges[3]));
        } else {
            probablePoints.add(new Point(edges[0], edges[2] + 1));
            probablePoints.add(new Point(edges[1], edges[3] - 1));
        }

        return probablePoints;
    }

    private boolean isShipHorizontal(ArrayList<Point> hitCells) {
        return hitCells.get(0).x != hitCells.get(1).x;
    }

    private int[] findMinMaxCoordinates(ArrayList<Point> hitCells) {
        Point p1 = hitCells.get(0);
        int[] edges = {p1.x, p1.x, p1.y, p1.y};

        for (Point p : hitCells) {
            if (p.x > edges[0]) {
                edges[0] = p.x;
            }
            if (p.x < edges[1]) {
                edges[1] = p.x;
            }
            if (p.y > edges[2]) {
                edges[2] = p.y;
            }
            if (p.y < edges[3]) {
                edges[3] = p.y;
            }
        }

        return edges;
    }

    private void removePointsThatCannotBeHit(ArrayList<Point> points) {
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
        return getRandom(availablePoints);
    }

    private <T> T getRandom(ArrayList<T> arrayList) {
        int n = (int) (Math.random() * arrayList.size());
        return arrayList.get(n);
    }

    private Point getComputerCrossShot(ArrayList<Point> hitCells) {
        ArrayList<Point> aims = new ArrayList<>();
        for (Point p : hitCells) {
            aims.add(new Point(p.x - 1, p.y));
            aims.add(new Point(p.x + 1, p.y));
            aims.add(new Point(p.x, p.y - 1));
            aims.add(new Point(p.x, p.y + 1));
        }

        removePointsThatCannotBeHit(aims);
        return getRandom(aims);
    }

    private ArrayList<Point> findHitShipPoints() {
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
                isHit = false;
            }
        } while (isHit);

        Helper.getString(Messages.USER_TURN_FINISHED.toString());
        System.out.println("-----------------------------------");
    }

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
