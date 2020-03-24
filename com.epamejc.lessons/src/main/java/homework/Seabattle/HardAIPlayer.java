package homework.Seabattle;

import java.util.*;

import static homework.Seabattle.OutputFormatter.printColored;

class HardAIPlayer extends NormalAIPlayer {
    private int[] enemyCurrentDestroyedShipCountBySize = new int[]{0, 0, 0, 0, 0};
    private static final Random RANDOM = new Random();
    private boolean hit;

    @Override
    public void requestPlayerName() {
        setName("HardAIPlayer");
    }

    @Override
    protected boolean makeShot() throws WonException {
        CellCoordinates shotCell = cellToShot();

        if (!getEnemy().hasShipAt(shotCell)) {
            visibleEnemyGameField.setCell(shotCell, CellState.MISSED);
            printColored(String.format("%s выстрелил в клетку %s, но промахнулся", getName(), shotCell),
                    OutputFormatter.TextColor.YELLOW);
            getEnemy().setMissAt(shotCell);
            return false;
        } else {
            visibleEnemyGameField.setCell(shotCell, CellState.SHIP_HIT);
            printColored(String.format("%s подбил ваш корабль на клетке %s", getName(), shotCell),
                    OutputFormatter.TextColor.RED);
            enemyShipCells.add(shotCell);
            hit = true;
            getEnemy().hitShipAt(shotCell);
            if (getEnemy().checkShipDestroyed(shotCell)) {
                printColored(String.format("%s уничтожил ваш корабль выстрелом в %s!", getName(), shotCell),
                        OutputFormatter.TextColor.RED);
                Set<CellCoordinates> destroyedEnemyShip =
                        visibleEnemyGameField.getSetOfShipCells(shotCell, false);
                enemyCurrentDestroyedShipCountBySize[destroyedEnemyShip.size()]++;
                enemyShipCells.clear();
                for (CellCoordinates cc : destroyedEnemyShip) {
                    visibleEnemyGameField.setAreaDestroyedShipCellsMissed(cc);
                }
                if (!getEnemy().hasShips())
                    throw new WonException(this);
            }
        }

        return true;
    }

    @Override
    protected CellCoordinates selectNewShotCoordinates() {
        if (!hit) return super.selectNewShotCoordinates();

        int[][] shipCellCount = new int[10][10];
        int maxCount = 0;

        for (int size = 4; size >= 1; size--) {
            if (enemyCurrentDestroyedShipCountBySize[size] == maxShipCountBySize[size]) continue;
            for (char c = 'a'; c <= 'j'; c++) {
                for (int n = 1; n <= 10; n++) {
                    for (Direction d : Direction.values()) {
                        if (visibleEnemyGameField.checkCreateShip(c, n, size, d)) {
                            switch (d) {
                                case LEFT:
                                    for (char i = 1; i < size; i++) {
                                        shipCellCount[c - i - 'a'][n - 1]++;
                                        if (shipCellCount[c - i - 'a'][n - 1] > maxCount) {
                                            maxCount = shipCellCount[c - i - 'a'][n - 1];
                                        }
                                    }
                                    break;
                                case RIGHT:
                                    for (char i = 1; i < size; i++) {
                                        shipCellCount[c + i - 'a'][n - 1]++;
                                        if (shipCellCount[c + i - 'a'][n - 1] > maxCount) {
                                            maxCount = shipCellCount[c + i - 'a'][n - 1];
                                        }
                                    }
                                    break;
                                case UP:
                                    for (char i = 1; i < size; i++) {
                                        shipCellCount[c - 'a'][n - i - 1]++;
                                        if (shipCellCount[c - 'a'][n - i - 1] > maxCount) {
                                            maxCount = shipCellCount[c - 'a'][n - i - 1];
                                        }
                                    }
                                    break;
                                case DOWN:
                                    for (char i = 1; i < size; i++) {
                                        shipCellCount[c - 'a'][n + i - 1]++;
                                        if (shipCellCount[c - 'a'][n + i - 1] > maxCount) {
                                            maxCount = shipCellCount[c - 'a'][n + i - 1];
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }

        List<CellCoordinates> possibleShotCells = new ArrayList<>(100);

        for (char c = 'a'; c <= 'j'; c++) {
            for (int n = 1; n <= 10; n++) {
                if (shipCellCount[c - 'a'][n - 1] == maxCount) {
                    CellCoordinates cc = new CellCoordinates(c, n);
                    possibleShotCells.add(cc);
                }
            }
        }

        return possibleShotCells.get(RANDOM.nextInt(possibleShotCells.size()));
    }
}