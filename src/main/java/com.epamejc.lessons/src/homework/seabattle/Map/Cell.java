package com.epamejc.lessons.src.homework.seabattle.Map;

import lombok.Data;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

@Data
public class Cell {
    private String letter;
    private int number;
    private CellStatus status;

    public Cell(String letter, int number, CellStatus status) {
        letter = letter.toUpperCase();
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Ожидалось число от 1 до 10");
        }
        if (!Arrays.asList(BattleMap.letters).contains(letter)) {
            throw new IllegalArgumentException(
                    "Ожидалась буква из набора : " + Arrays.toString(BattleMap.letters));
        }
        this.letter = letter;
        this.number = number;
        this.status = status;
    }

    public Cell(String letter, int number) {
        letter = letter.toUpperCase();
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Ожидалось число от 1 до 10");
        }
        if (!Arrays.asList(BattleMap.letters).contains(letter)) {
            throw new IllegalArgumentException(
                    "Ожидалась буква из набора : " + Arrays.toString(BattleMap.letters));
        }
        this.letter = letter;
        this.number = number;
        this.status = CellStatus.EMPTY;
    }

    public static Predicate<Cell> isCellHigherThan(Cell cell) {
        return c -> c.getNumber() > cell.getNumber();
    }

    public static Predicate<Cell> isCellLowerThan(Cell cell) {
        return c -> c.getNumber() < cell.getNumber();
    }

    public static Predicate<Cell> isCellMoreRightThan(Cell cell) {
        return c -> c.getLetter().compareTo(cell.getLetter()) > 0;
    }

    public static Predicate<Cell> isCellMoreLeftThan(Cell cell) {
        return c -> c.getLetter().compareTo(cell.getLetter()) < 0;
    }

    public String getLocation() {
        return letter + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return number == cell.number && Objects.equals(letter, cell.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, number);
    }
}
