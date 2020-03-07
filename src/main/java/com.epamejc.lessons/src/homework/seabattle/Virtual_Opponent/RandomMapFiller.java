package com.epamejc.lessons.src.homework.seabattle.Virtual_Opponent;

import com.epamejc.lessons.src.homework.seabattle.Map.BattleMap;
import com.epamejc.lessons.src.homework.seabattle.Map.Cell;
import com.epamejc.lessons.src.homework.seabattle.Map.Ship;

import java.util.Random;

public class RandomMapFiller {
    private final BattleMap map;
    private final Random random = new Random();

    public RandomMapFiller(BattleMap map) {
        this.map = map;
    }

    public BattleMap fillMap() {
        for (int i = 4; i > 0; i--) {
            for (int k = 0; k < 5 - i; k++) {
                placeShip(i);
            }
        }
        return map;
    }

    private void placeShip(int length) {
        boolean done = false;
        while (!done) {
            Cell[] cells = getRandomCellLine(length);
            Ship ship = length == 1 ? new Ship(cells[0]) : new Ship(cells[0], cells[1]);
            done = map.addShip(ship);
        }
    }

    private Cell getRandomCell() {
        int number = 1 + random.nextInt(10);
        String letter = BattleMap.letters[random.nextInt(10)];
        return new Cell(letter, number);
    }

    private Cell[] getRandomCellLine(int length) {
        Cell[] cells = length == 1 ? new Cell[1] : new Cell[2];
        if (length == 1) {
            cells[0] = getRandomCell();
        } else {
            boolean isHorizontal = random.nextBoolean();
            if (isHorizontal) {
                fillRandomArrayHorizontal(length, cells);
            } else {
                fillRandomArrayVertical(length, cells);
            }
        }
        return cells;
    }

    private void fillRandomArrayVertical(int length, Cell[] cells) {
        String letter = BattleMap.letters[random.nextInt(10)];
        int number = 1 + random.nextInt(10 - length - 1);
        cells[0] = new Cell(letter, number);
        cells[1] = new Cell(letter, number + length - 1);
    }

    private void fillRandomArrayHorizontal(int length, Cell[] cells) {
        int indexLetter = random.nextInt(10 - length);
        int number = 1 + random.nextInt(10);
        cells[0] = new Cell(BattleMap.letters[indexLetter], number);
        cells[1] = new Cell(BattleMap.letters[indexLetter + length - 1], number);
    }
}
