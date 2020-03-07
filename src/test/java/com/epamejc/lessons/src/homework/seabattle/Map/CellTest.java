package com.epamejc.lessons.src.homework.seabattle.Map;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class CellTest {

    @Test(expected = IllegalArgumentException.class)
    public void createCellWrongLetter() {
        new Cell("d", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCellZeroNumber() {
        new Cell("в", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCellNumberBiggerThen10() {
        new Cell("в", 11);
    }

    @Test
    public void createCellRightLetterAndNumbers() {
        for (String letter : BattleMap.letters) {
            for (int i = 1; i < 11; i++) {
                Cell cell = new Cell(letter, i);
                assertEquals(letter, cell.getLetter());
                assertEquals(i, cell.getNumber());
                assertEquals(CellStatus.EMPTY, cell.getStatus());
            }
        }
    }

    @Test
    public void createCellRightLetterAndNumbersAndStatus() {
        for (String letter : BattleMap.letters) {
            for (int i = 1; i < 11; i++) {
                Cell cell = new Cell(letter, i, CellStatus.HIT);
                assertEquals(letter, cell.getLetter());
                assertEquals(i, cell.getNumber());
                assertEquals(CellStatus.HIT, cell.getStatus());
            }
        }
    }

    @Test
    public void createCellWithLowerCaseLetter() {
        Cell cell = new Cell("а", 1);
        assertEquals("А", cell.getLetter());
    }

    @Test
    public void checkIsCellHigherPredicate() {
        Predicate<Cell> predicate = Cell.isCellHigherThan(new Cell("д", 5));
        for (int i = 1; i < 11; i++) {
            for (String letter : BattleMap.letters) {
                boolean isHigher = predicate.test(new Cell(letter, i));
                if (i > 5) {
                    assertTrue(isHigher);
                } else {
                    assertFalse(isHigher);
                }
            }
        }
    }

    @Test
    public void checkIsCellLowerPredicate() {
        Predicate<Cell> predicate = Cell.isCellLowerThan(new Cell("д", 5));
        for (int i = 1; i < 11; i++) {
            for (String letter : BattleMap.letters) {
                boolean isLower = predicate.test(new Cell(letter, i));
                if (i < 5) {
                    assertTrue(isLower);
                } else {
                    assertFalse(isLower);
                }
            }
        }
    }

    @Test
    public void checkIsCellMoreRightPredicate() {
        String cellLetter = "Д";
        Predicate<Cell> predicate = Cell.isCellMoreRightThan(new Cell(cellLetter, 5));
        for (String letter : BattleMap.letters) {
            for (int i = 1; i < 11; i++) {
                boolean isMoreRight = predicate.test(new Cell(letter, i));
                if (letter.compareTo(cellLetter) > 0) {
                    assertTrue(isMoreRight);
                } else {
                    assertFalse(isMoreRight);
                }
            }
        }
    }

    @Test
    public void checkIsCellMoreLeftPredicate() {
        String cellLetter = "Д";
        Predicate<Cell> predicate = Cell.isCellMoreLeftThan(new Cell(cellLetter, 5));
        for (String letter : BattleMap.letters) {
            for (int i = 1; i < 11; i++) {
                boolean isMoreLeft = predicate.test(new Cell(letter, i));
                if (letter.compareTo(cellLetter) < 0) {
                    assertTrue(isMoreLeft);
                } else {
                    assertFalse(isMoreLeft);
                }
            }
        }
    }
}
