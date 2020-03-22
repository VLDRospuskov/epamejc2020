package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.engine.Settings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a bot behavior in the game.
 * It can solve the problems of seeking and destroying
 * enemy ships. The search implemented using diagonal
 * algorithm: first the diagonals at a distance of 3 cells
 * are affected, then 2 cells, then the rest.
 * In case of hit, AI tries to finish off the found ship.
 */
public class AI {

    private int DECK_SIZE;
    private List<Cell> shootingArea;
    private List<Cell> finishOffArea;

    /**
     * The {@code List} of already affected cells, including the area around destroyed ships
     */
    private List<Cell> excludedList;

    /**
     * The distance between diagonals to compute shooting area
     */
    private int offset;
    private Cell foundShip;
    private Cell lastShot;
    private Cell alignment;
    private boolean finishOffMode;
    private GameState lastState;

    public AI() {

        Settings settings = new Settings();
        offset = settings.getTheBiggestShip();
        DECK_SIZE = settings.getDeckSize();
        excludedList = new ArrayList<>();
        finishOffArea = new ArrayList<>();
        shootingArea = generateShootingArea(offset);
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
                generateFinishOffArea(foundShip);
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

        if (shootingArea.isEmpty()) {
            offset -= 1;
            shootingArea = generateShootingArea(offset);
        }
        foundShip = shootingArea.remove(new Random().nextInt(shootingArea.size()));
        excludedList.add(foundShip);
        return foundShip;

    }

    private Cell finishOff() {

        if ((lastState.equals(GameState.HIT) && lastShot != null)) {
            generateFinishOffArea(lastShot);
        }
        if (finishOffArea.isEmpty()) {
            alignment = new Cell(1 - alignment.getCoordX(), 1 - alignment.getCoordY());
            generateFinishOffArea(foundShip);
        }
        lastShot = finishOffArea.remove(new Random().nextInt(finishOffArea.size()));
        excludedList.add(lastShot);
        return lastShot;

    }

    private void generateFinishOffArea(Cell cell) {

        int coordX = cell.getCoordX();
        int coordY = cell.getCoordY();
        int horizontal = alignment.getCoordX();
        int vertical = alignment.getCoordY();
        for (int i = coordX * horizontal + coordY * vertical - 1;
             i <= coordX * horizontal + coordY * vertical + 1; i++) {
            if (i > 0 && i <= DECK_SIZE) {
                finishOffArea.add(new Cell(i * horizontal + coordX * vertical,
                        i * vertical + coordY * horizontal));
            }
        }
        finishOffArea.removeAll(excludedList);

    }

    private List<Cell> generateShootingArea(int offset) {

        List<Cell> area = new ArrayList<>();
        for (int i = 1; i <= DECK_SIZE; i++) {
            for (int j = i - DECK_SIZE / offset * offset; j <= DECK_SIZE; j += offset) {
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
        shootingArea.removeAll(excludedList);

    }

}