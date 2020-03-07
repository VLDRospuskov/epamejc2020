package com.epamejc.lessons.src.homework.seabattle.Map;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShipTest {
    @Test(expected = IllegalArgumentException.class)
    public void createCellWithDiagonalCells() {
        Cell cell1 = new Cell("A", 1);
        Cell cell2 = new Cell("б", 2);
        new Ship(cell1, cell2);
    }

    @Test
    public void createShipWithOneCell() {
        Cell cell1 = new Cell("а", 1);
        Ship ship = new Ship(cell1);
        assertEquals(1, ship.getSize());
    }

    @Test
    public void createShipWithTwoEqualCells() {
        Cell cell1 = new Cell("а", 1);
        Cell cell2 = new Cell("а", 1);
        Ship ship = new Ship(cell1, cell2);
        assertEquals(1, ship.getSize());
    }

    @Test
    public void createShipWithTwoDifferentCellsEqualLetters() {
        for (int i = 1; i < 11; i++) {
            for (int k = 1; k < 11; k++) {
                Cell cell1 = new Cell("а", i);
                Cell cell2 = new Cell("а", k);
                Ship ship = new Ship(cell1, cell2);
                int expectedSize = Math.abs(k - i) + 1;
                assertEquals(expectedSize, ship.getSize());
            }
        }
    }

    @Test
    public void createShipWithTwoDifferentCellsEqualNumbers() {
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                Cell cell1 = new Cell(BattleMap.letters[i], 1);
                Cell cell2 = new Cell(BattleMap.letters[k], 1);
                Ship ship = new Ship(cell1, cell2);
                int expectedSize = Math.abs(k - i) + 1;
                assertEquals(expectedSize, ship.getSize());
            }
        }
    }

    @Test
    public void shootByCell() {
        Ship ship = new Ship(new Cell("а", 1));
        for (int i = 0; i < 10; i++) {
            for (int k = 1; k < 11; k++) {
                Cell cell = new Cell(BattleMap.letters[i], k);
                boolean shoot = ship.shootByCell(cell);
                if (k == 1 && BattleMap.letters[i].equals("А")) {
                    assertTrue(shoot);
                } else {
                    assertFalse(shoot);
                }
            }
        }
    }

    @Test
    public void isDeadWorkingForOneCellShip() {
        Cell cell = new Cell("а", 1);
        Ship ship = new Ship(cell);
        boolean shoot = ship.shootByCell(cell);
        assertTrue(shoot);
        assertTrue(ship.isDead());
    }

    @Test
    public void isDeadWorkingForManyCellsShip() {
        Cell cell1 = new Cell(BattleMap.letters[0], 1);
        Cell cell2 = new Cell(BattleMap.letters[4], 1);
        Ship ship = new Ship(cell1, cell2);
        for (int i = 0; i < 5; i++) {
            assertFalse(ship.isDead());
            boolean shoot = ship.shootByCell(new Cell(BattleMap.letters[i], 1));
            assertTrue(shoot);
        }
        assertTrue(ship.isDead());
    }

    @Test
    public void getLocationOneCellShip() {
        Cell cell = new Cell("а", 1);
        Ship ship = new Ship(cell);
        List<Cell> location = ship.getLocation();
        assertTrue(location.contains(cell));
    }

    @Test
    public void getLocationManyCellsShip() {
        Cell cell1 = new Cell("А", 1);
        Cell cell2 = new Cell("А", 5);
        Ship ship = new Ship(cell1, cell2);
        List<Cell> location = ship.getLocation();
        for (int i = 1; i < 5; i++) {
            Cell cell = new Cell("А", i);
            assertTrue(location.contains(cell));
        }
    }


}