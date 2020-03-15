package Seabattle;

import java.io.IOException;
import java.util.Set;

import static Seabattle.OutputFormatter.printColored;

public abstract class AbstractPlayer implements Player {

    protected final GameField gameField = new GameField();
    protected final GameField visibleEnemyGameField = new GameField();
    protected static final int[] maxShipCountBySize = new int[]{0, 4, 3, 2, 1};
    protected int[] currentShipCountBySize = new int[]{0, 0, 0, 0, 0};
    private Player enemy;

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "Unnamed";

    protected void randomPlaceAllShips() {
        gameField.clear();

        for (int i = maxShipCountBySize.length - 1; i > 0; i--){
            for (int j = currentShipCountBySize[i]; j < maxShipCountBySize[i]; j++) {
                gameField.randomPlaceShip(i);
            }
            currentShipCountBySize[i] = maxShipCountBySize[i];
        }
    }

    protected boolean hasVacantSlotForSize(int size) {
        return currentShipCountBySize[size] < maxShipCountBySize[size];
    }

    protected boolean hasVacantShipSlots() {
        return currentShipCountBySize[1] != maxShipCountBySize[1] ||
                currentShipCountBySize[2] != maxShipCountBySize[2] ||
                currentShipCountBySize[3] != maxShipCountBySize[3] ||
                currentShipCountBySize[4] != maxShipCountBySize[4];
    }

    protected boolean makeShot() throws IOException, SurrenderedException, WonException {
        CellCoordinates shotCell = cellToShot();

        if (!getEnemy().hasShipAt(shotCell)) {
            visibleEnemyGameField.setCell(shotCell, CellState.MISSED);
            printColored("Вы промахнулись!", OutputFormatter.TextColor.YELLOW);
            getEnemy().setMissAt(shotCell);
            return false;
        } else {
            printColored("Вы попали!", OutputFormatter.TextColor.GREEN);
            visibleEnemyGameField.setCell(shotCell, CellState.SHIP_HIT);
            getEnemy().hitShipAt(shotCell);
            if (getEnemy().checkShipDestroyed(shotCell)) {
                printColored("Вы уничтожили вражеский корабль!", OutputFormatter.TextColor.YELLOW);
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
    public boolean hasShips(){
        return gameField.hasShips();
    }

    @Override
    public boolean hasShipAt(CellCoordinates cellCoordinates){
        return gameField.getCellState(cellCoordinates) == CellState.SHIP;
    }

    @Override
    public void hitShipAt(CellCoordinates cellCoordinates){
        gameField.setCell(cellCoordinates, CellState.SHIP_HIT);
    }

    @Override
    public void setMissAt(CellCoordinates cellCoordinates){
        gameField.setCell(cellCoordinates, CellState.MISSED);
    }

    @Override
    public boolean checkShipDestroyed(CellCoordinates shipCell){
        return gameField.checkShipDestroyed(shipCell);
    }

    protected abstract CellCoordinates cellToShot() throws IOException, SurrenderedException;

    public void printGameField() {
        System.out.println("Поле игрока " + name);
        System.out.println(gameField);
    }

}
