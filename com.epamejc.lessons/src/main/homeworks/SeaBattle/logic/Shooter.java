package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.Ship;
import homeworks.SeaBattle.data.enums.Chars;
import homeworks.SeaBattle.data.players.Player;
import homeworks.SeaBattle.data.players.User;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.SeaBattle.data.StaticVariables.TOTAL_SCORE;
import static homeworks.SeaBattle.data.StaticVariables.sleepTimeMs;
import static homeworks.SeaBattle.logic.IO.printFields;
import static homeworks.SeaBattle.logic.Util.getComputerSmartShoot;

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

        Helper.getStringSilently("Your turn is finished. Press any button.");
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
            System.out.println("Мимо!");
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
            System.out.println("Убит!");
        } else {
            markHitOnField(p);
            System.out.println("Попал!");
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
