package Seabattle;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static Seabattle.OutputFormatter.printColored;

public abstract class AbstractAIPlayer extends AbstractPlayer {
    @Override
    public void placeAllShips() {
        randomPlaceAllShips();
    }

    @Override
    public void turn() throws IOException, SurrenderedException, WonException {
        while (makeShot()) ;
    }

    protected CellCoordinates selectNewShotCoordinates() {
        return GameField.getRandomCellCoordinates();
    }
}

class EasyAIPlayer extends AbstractAIPlayer {
    @Override
    public void requestPlayerName() {
        setName("EasyAIPlayer");
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
            printColored(String.format("%s подбил ваш корабль на клетке %s", getName(), shotCell),
                    OutputFormatter.TextColor.RED);
            visibleEnemyGameField.setCell(shotCell, CellState.SHIP_HIT);
            getEnemy().hitShipAt(shotCell);
            if (getEnemy().checkShipDestroyed(shotCell)) {
                printColored(String.format("%s уничтожил ваш корабль выстрелом в %s!", getName(), shotCell),
                        OutputFormatter.TextColor.RED);
                Set<CellCoordinates> destroyedEnemyShip =
                        visibleEnemyGameField.getSetOfShipCells(shotCell,false);
                for (CellCoordinates cc: destroyedEnemyShip) {
                    visibleEnemyGameField.setAreaDestroyedShipCellsMissed(cc);
                }
                if (!getEnemy().hasShips())
                    throw new WonException(this);
            }
        }

        return true;
    }

    @Override
    protected CellCoordinates cellToShot() {
        CellCoordinates cc;
        do {
            cc = selectNewShotCoordinates();
        } while (visibleEnemyGameField.getCellState(cc) != CellState.EMPTY);
        return cc;
    }
}

class NormalAIPlayer extends AbstractAIPlayer {
    protected Set<CellCoordinates> enemyShipCells = new HashSet<>();

    @Override
    public void requestPlayerName() {
        setName("NormalAIPlayer");
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
            getEnemy().hitShipAt(shotCell);
            if (getEnemy().checkShipDestroyed(shotCell)) {
                printColored(String.format("%s уничтожил ваш корабль выстрелом в %s!", getName(), shotCell),
                        OutputFormatter.TextColor.RED);
                Set<CellCoordinates> destroyedEnemyShip =
                        visibleEnemyGameField.getSetOfShipCells(shotCell,false);
                enemyShipCells.clear();
                for (CellCoordinates cc: destroyedEnemyShip) {
                    visibleEnemyGameField.setAreaDestroyedShipCellsMissed(cc);
                }
                if (!getEnemy().hasShips())
                    throw new WonException(this);
            }
        }

        return true;
    }

    @Override
    protected CellCoordinates cellToShot() {
        CellCoordinates cc = new CellCoordinates();

        if (!enemyShipCells.isEmpty()) {
            if (enemyShipCells.size() == 1) {
                cc = enemyShipCells.iterator().next();

                CellCoordinates cc1 = new CellCoordinates((char) (cc.getCharacter() - 1), cc.getInteger());
                CellCoordinates cc2 = new CellCoordinates(cc.getCharacter(), cc.getInteger() - 1);
                CellCoordinates cc3 = new CellCoordinates(cc.getCharacter(), cc.getInteger() + 1);
                CellCoordinates cc4 = new CellCoordinates((char) (cc.getCharacter() + 1), cc.getInteger());

                if (visibleEnemyGameField.getCellState(cc1) == CellState.EMPTY)
                    return cc1;
                if (visibleEnemyGameField.getCellState(cc2) == CellState.EMPTY)
                    return cc2;
                if (visibleEnemyGameField.getCellState(cc3) == CellState.EMPTY)
                    return cc3;
                if (visibleEnemyGameField.getCellState(cc4) == CellState.EMPTY)
                    return cc4;
            } else {
                char maxCh = 'a', minCh = 'j';
                int maxInt = 1, minInt = 10;
                for (CellCoordinates esc : enemyShipCells) {
                    if (esc.getInteger() > maxInt) maxInt = esc.getInteger();
                    if (esc.getCharacter() > maxCh) maxCh = esc.getCharacter();
                    if (esc.getInteger() < minInt) minInt = esc.getInteger();
                    if (esc.getCharacter() < minCh) minCh = esc.getCharacter();
                }
                if (maxCh == minCh) {
                    cc.setCharacter(maxCh);
                    if (visibleEnemyGameField.getCellState(maxCh, minInt - 1) == CellState.EMPTY) {
                        cc.setInteger(minInt - 1);
                    } else cc.setInteger(maxInt + 1);
                } else {
                    cc.setInteger(maxInt);
                    if (visibleEnemyGameField.getCellState((char)(minCh - 1), maxInt) == CellState.EMPTY) {
                        cc.setCharacter((char)(minCh - 1));
                    } else cc.setCharacter((char)(maxCh + 1));
                }

                return cc;
            }
        }

        do {
            cc = selectNewShotCoordinates();
        } while (visibleEnemyGameField.getCellState(cc) != CellState.EMPTY);

        return cc;
    }
}