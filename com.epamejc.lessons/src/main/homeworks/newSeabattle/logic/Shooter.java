package homeworks.newSeabattle.logic;

import homeworks.seabattle_2_players.Ship;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.ArrayList;

public class Shooter {

//    //SHOOTING////////////
//    @SneakyThrows
//    public boolean shoot(Point p) {
//        if (cells[p.y][p.x] == SHIP) {
//            hit(p);
//            return true;
//        } else {
//            miss(p);
//            System.out.println("Мимо!");
//            Thread.sleep(sleepTimeMs);
//            return false;
//        }
//    }
//
//    private void hit(Point p) throws InterruptedException {
//        Ship ship = getShipByHitCell(p);
//        ship.hit(p);
//
//        if (ship.isDead()) {
//            sink(ship);
//            System.out.println("Убит!");
//            Thread.sleep(sleepTimeMs);
//        } else {
//            markHitOnField(p);
//            System.out.println("Попал!");
//            Thread.sleep(sleepTimeMs);
//        }
//    }
//
//    private void miss(Point p) {
//        char cell = cells[p.y][p.x];
//        if (cell != DESTROYED && cell != HIT) {
//            cells[p.y][p.x] = MISS;
//        }
//    }
//
//    private Ship getShipByHitCell(Point givenP) {
//        for (Ship ship : ships) {
//            for (Point foundP: ship.getCells()) {
//                if (givenP.equals(foundP)) {
//                    return ship;
//                }
//            }
//        }
//
//        throw new RuntimeException("The ship is not found by location!");
//    }
//
//    private void sink(Ship ship) {
//        ships.remove(ship);
//        markDeadShip(ship);
//        markNearCellsWithDots(ship);
//    }
//
//    private void markHitOnField(Point p) {
//        cells[p.y][p.x] = HIT;
//    }
//
//    private void markDeadShip(Ship ship) {
//        for (Point p : ship.getHitCells()) {
//            cells[p.y][p.x] = DESTROYED;
//        }
//    }
//
//    private void markNearCellsWithDots(Ship ship) {
//        for (Point shipCell : ship.getHitCells()) {
//            ArrayList<Point> nearCells = existingCellsNear(shipCell);
//            for (Point p : nearCells) {
//                if (cells[p.y][p.x] == ' ') {
//                    cells[p.y][p.x] = MISS;
//                }
//            }
//        }
//    }
//
}
