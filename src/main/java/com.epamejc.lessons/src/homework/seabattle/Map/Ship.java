package com.epamejc.lessons.src.homework.seabattle.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ship {
    private final List<Cell> location = new ArrayList<>();

    public Ship(Cell head, Cell tail) {
        if (!head.getLetter().equals(tail.getLetter()) && head.getNumber() != tail.getNumber()) {
            throw new IllegalArgumentException("Клетки не образуют прямую линию");
        }
        if (head.equals(tail)) {
            location.add(new Cell(head.getLetter(), head.getNumber(), CellStatus.SHIP));
        } else if (head.getNumber() == tail.getNumber()) {
            String[] letters = getArrayOfLetters(head, tail);
            for (String letter : letters) {
                location.add(new Cell(letter, tail.getNumber(), CellStatus.SHIP));
            }
        } else {
            int max = Math.max(tail.getNumber(), head.getNumber());
            int min = Math.min(tail.getNumber(), head.getNumber());
            for (int i = min; i <= max; i++) {
                location.add(new Cell(head.getLetter(), i, CellStatus.SHIP));
            }
        }
    }

    public Ship(Cell cell) {
        location.add(new Cell(cell.getLetter(), cell.getNumber(), CellStatus.SHIP));
    }

    public boolean isDead() {
        List<Cell> aliveCells =
                location.stream()
                        .filter(cell -> cell.getStatus() == CellStatus.SHIP)
                        .collect(Collectors.toList());
        return aliveCells.size() == 0;
    }

    public boolean shootByCell(Cell cell) {
        for (Cell shipCell : location) {
            if (shipCell.getNumber() == cell.getNumber()
                    && shipCell.getLetter().equals(cell.getLetter())) {
                shipCell.setStatus(CellStatus.HIT);
                return true;
            }
        }
        return false;
    }

    public List<Cell> getLocation() {
        return location;
    }

    public int getSize() {
        return location.size();
    }

    private String[] getArrayOfLetters(Cell head, Cell tail) {
        int firstLetter = Arrays.binarySearch(BattleMap.letters, head.getLetter());
        int secondLetter = Arrays.binarySearch(BattleMap.letters, tail.getLetter());
        int max = Math.max(firstLetter, secondLetter);
        int min = Math.min(firstLetter, secondLetter);
        return Arrays.copyOfRange(BattleMap.letters, min, max + 1);
    }
}
