package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.data.enums.Ships;

import java.util.*;
import java.util.stream.Collectors;

import static homeworks.java.seabattle.data.Field.deckSize;

public class AI {

    private List<Cell> area;
    private List<Cell> excludedList;
    private int offset;
    private Cell lastShot;

    public AI () {

        offset = findTheBiggestShip();
        this.excludedList = new ArrayList<>();
        this.area = generateShootingArea(offset);
        lastShot = null;

    }

    public Cell shoot() {

        area.removeAll(excludedList);
        if(area.isEmpty()) {
            offset -= 1;
            area = generateShootingArea(offset);
            area.removeAll(excludedList);
        }
        lastShot = area.get(new Random().nextInt(area.size()));
        return lastShot;

    }

    public Cell finishOff() {

        return new Cell(0,0);

    }

    //add finish off the ship method if hit
    private List<Cell> generateShootingArea(int offset) {

        List<Cell> area = new ArrayList<>();
        for (int i = 1; i <= deckSize; i++) {
            for (int j = i - deckSize / offset * offset; j <= deckSize; j += offset) {
                if (j > 0) {
                    area.add(new Cell(i, j));
                }
            }
        }
        area.removeAll(excludedList);
        return area;

    }

    public void exclude(List<Cell> enemyField) {

        excludedList = enemyField.stream()
                .filter(cell -> !cell.isShootable())
                .collect(Collectors.toList());

    }

    private int findTheBiggestShip() {

        return Arrays.stream(Ships.values())
                .max(Comparator.comparing(Ships::getLength))
                .map(Ships::getLength)
                .get();

    }

}
