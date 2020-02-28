package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;

import java.util.*;
import java.util.stream.Collectors;

import static homeworks.java.seabattle.data.Field.deckSize;

public class AI {

    private List<Cell> area;
    private List<Cell> finishOffArea;
    private List<Cell> excludedList;
    private int offset;
    private Cell foundShip;
    private Cell lastShot;
    private Cell alignment;
    private boolean finishOffMode;
    private GameState lastState;

    public AI() {

        offset = findTheBiggestShip();
        this.excludedList = new ArrayList<>();
        this.finishOffArea = new ArrayList<>();
        this.area = generateShootingArea(offset);
        foundShip = null;
        finishOffMode = false;

    }

    public GameState shoot(Player enemy) {

        GameState gameState;
        if (finishOffMode) {
            gameState = enemy.getField().hit(finishOff());
        } else {
            gameState = enemy.getField().hit(seek());
            if (gameState.equals(GameState.HIT)) {
                alignment = new Random().nextInt(2) == 0 ?
                        new Cell(0, 1)
                        : new Cell(1, 0);
                generateFinishOffArea(alignment);
                finishOffMode = true;
            }
        }
        if (gameState.equals(GameState.DESTROYED)) {
            exclude(enemy.getField().getDeck());
            finishOffMode = false;
            lastShot = null;
        }
        lastState = gameState;
        return lastState;

    }

    private Cell seek() {

        if (area.isEmpty()) {
            offset -= 1;
            area = generateShootingArea(offset);
        }
        foundShip = area.remove(new Random().nextInt(area.size()));
        excludedList.add(foundShip);
        return foundShip;

    }

    private Cell finishOff() {

        if (lastState.equals(GameState.HIT) && lastShot != null) {
            lastShot = new Cell(foundShip.getCoordX() + lastShot.getCoordX() - foundShip.getCoordX(),
                    foundShip.getCoordY() + lastShot.getCoordY() - foundShip.getCoordY());
            excludedList.add(lastShot);
        } else {
            if (finishOffArea.isEmpty()) {
                alignment = new Cell(1 - alignment.getCoordX(), 1 - alignment.getCoordY());
                generateFinishOffArea(alignment);
            }
            lastShot = finishOffArea.remove(new Random().nextInt((finishOffArea.size())));
        }
        return lastShot;

    }

    private void generateFinishOffArea(Cell alignment) {

        int coordX = foundShip.getCoordX();
        int coordY = foundShip.getCoordY();
        int horizontal = alignment.getCoordX();
        int vertical = alignment.getCoordY();
        for (int i = coordX * horizontal + coordY * vertical - 1;
             i <= coordX * horizontal + coordY * vertical + 1; i++) {
            if (i > 0 && i <= deckSize) {
                finishOffArea.add(new Cell(i * horizontal + coordX * vertical,
                        i * vertical + coordY * horizontal));
            }
        }
        finishOffArea.removeAll(excludedList);

    }

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

    private void exclude(List<Cell> enemyField) {

        excludedList = enemyField.stream()
                .filter(cell -> !cell.isShootable())
                .collect(Collectors.toList());
        area.removeAll(excludedList);

    }

    private int findTheBiggestShip() {

        return Arrays.stream(Ships.values())
                .max(Comparator.comparing(Ships::getLength))
                .map(Ships::getLength)
                .get();

    }

}
