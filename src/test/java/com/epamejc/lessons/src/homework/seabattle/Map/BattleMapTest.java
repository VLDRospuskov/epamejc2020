package com.epamejc.lessons.src.homework.seabattle.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleMapTest {
    EventHandler eventHandler;
    BattleMap map;
    String name = "Мария";

    @Before
    public void init() {
        eventHandler = new EventHandler();
        map = new BattleMap(name, eventHandler);
    }

    @Test
    public void getOwner() {
        assertTrue(map.getOwner().equals(name));
    }

    @Test
    public void getFullMap() {
        Cell[][] cells = map.getFullMap();
        assertEquals(10, cells.length);
        assertEquals(10, cells[0].length);
    }

    @Test
    public void tryAddShipInEmptySpace() {
        Ship ship = new Ship(new Cell("а", 1));
        boolean isAdded = map.addShip(ship);
        assertTrue(isAdded);
        assertTrue(map.getFullMap()[0][0].getStatus() == CellStatus.SHIP);
        assertTrue(map.haveAliveShips());
        assertEquals(1, map.getNumberAliveShips());
    }

    @Test
    public void tryАddShipInEmptySpaceAroundOtherShip() {
        Ship ship = new Ship(new Cell("а", 1));
        boolean isAdded = map.addShip(ship);
        assertTrue(isAdded);
        Ship ship2 = new Ship(new Cell("а", 2));
        isAdded = map.addShip(ship2);
        assertFalse(isAdded);
        Ship ship3 = new Ship(new Cell("б", 1));
        isAdded = map.addShip(ship3);
        assertFalse(isAdded);
        assertTrue(map.haveAliveShips());
        assertEquals(1, map.getNumberAliveShips());
    }

    @Test
    public void tryАddShipOnOtherShip() {
        Ship ship = new Ship(new Cell("а", 1));
        boolean isAdded = map.addShip(ship);
        assertTrue(isAdded);
        Ship ship2 = new Ship(new Cell("а", 1));
        isAdded = map.addShip(ship2);
        assertFalse(isAdded);
    }

    @Test
    public void getMapWithoutShip() {
        Ship ship = new Ship(new Cell("а", 1));
        map.addShip(ship);
        Cell[][] cells = map.getMapWithoutShip();
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                assertTrue(cells[i][k].getStatus() != CellStatus.SHIP);
            }
        }
    }

    @Test
    public void shootByEmptyCell() {
        boolean shoot = map.shootByCell(new Cell("а", 1));
        assertFalse(shoot);
        assertTrue(eventHandler.getStringEvents().contains("промахнулся"));
        assertTrue(map.getFullMap()[0][0].getStatus() == CellStatus.MISS);
    }

    @Test
    public void shootByNotEmptyCell() {
        Cell cell = new Cell("а", 1);
        Ship ship = new Ship(cell);
        map.addShip(ship);
        boolean shoot = map.shootByCell(cell);
        assertTrue(shoot);
        assertTrue(eventHandler.getStringEvents().contains("попал"));
        assertTrue(map.getFullMap()[0][0].getStatus() == CellStatus.HIT);
    }

    @Test
    public void haveNoALiveShipsAfterShoot() {
        Cell cell = new Cell("а", 1);
        Ship ship = new Ship(cell);
        map.addShip(ship);
        map.shootByCell(cell);
        assertFalse(map.haveAliveShips());
        assertEquals(0, map.getNumberAliveShips());
    }

    @Test
    public void isNotShootedEmptyCell() {
        Cell cell = new Cell("а", 1);
        boolean isNotShooted = map.isNotShootedCell(cell);
        assertTrue(isNotShooted);
    }

    @Test
    public void isNotShootedCellWithShoot() {
        Cell cell = new Cell("а", 1);
        map.shootByCell(cell);
        boolean isNotShooted = map.isNotShootedCell(cell);
        assertFalse(isNotShooted);
    }


    @Test
    public void checkOpponentName() {
        map.setOpponent("Иван");
        map.shootByCell(new Cell("а", 1));
        assertTrue(eventHandler.getStringEvents().contains("Иван"));
    }
}