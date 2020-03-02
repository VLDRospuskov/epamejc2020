package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.CellStatus;
import homeworks.seaBattle.data.enums.SystemMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerShootingUtil {

    private Set<Cell> enemyBannedCells = new HashSet<>();
    private Player enemyPlayer;

    public PlayerShootingUtil(Player enemy) {
        this.enemyPlayer = enemy;
    }

    public Set<Cell> getEnemyBannedCells() {
        return enemyBannedCells;
    }

    public Player getEnemyPlayer() {
        return enemyPlayer;
    }

    /**
     * Method checks the banned cells of the enemy field {@link PlayerShootingUtil#enemyBannedCells}
     * @param potentialFireCell {@link Cell} cell where're going to shoot
     * @return true/false if the list of enemy banned cells contains/doesn't contain shooting cell
     */
    public boolean isCellShot(Cell potentialFireCell) {
        return enemyBannedCells.contains(potentialFireCell);
    }

    /**
     * Method describes the algorithm of shooting at a computer field
     * @param shotCoordinates cell coordinates of the enemy field
     * @return true/false if player hits or misses enemy ship
     */
    public boolean shot(int[] shotCoordinates) {
        Cell fireCell = enemyPlayer.fieldOperations().getCellByCoords(shotCoordinates[0], shotCoordinates[1]);
        Ship enemyShip = fireCell.getCellShip();
        if (enemyShip != null) {
            enemyShip.hitShip();
            if (enemyShip.isDestroyed()) {
                System.out.println(SystemMessages.playerKill.getMessage() + " " + enemyShip.getShipType());
                processDestroyedShip(enemyShip);
            } else {
                System.out.println(SystemMessages.playerHit.getMessage());
                fireCell.setCellStatus(CellStatus.HIT.getStatus());
                enemyBannedCells.add(fireCell);
            }
            return true;
        } else {
            System.out.println(SystemMessages.playerMiss.getMessage());
            fireCell.setCellStatus(CellStatus.MISSED.getStatus());
            enemyBannedCells.add(fireCell);
            return false;
        }
    }

    /**
     * Method for destroying an enemy ship and updating cells status
     * @param destroyedShip destroyed computer's ship {@link Ship}
     */
    public void processDestroyedShip(Ship destroyedShip) {
        List<Cell> destroyedShipCells = enemyPlayer.fieldOperations().getShipAndRadiusCells(destroyedShip);
        for (Cell cell : destroyedShipCells) {
            cell.setCellStatus(CellStatus.HIT.getStatus());
            if (!enemyBannedCells.contains(cell)) {
                enemyBannedCells.add(cell);
            }
        }
        removeShipFromCells(destroyedShip);
        enemyPlayer.shipsOperations().removeShip(destroyedShip);
    }

    /**
     * Method for removing a ship object from the field
     * @param destroyedShip destroyed computer's ship {@link Ship}
     */
    private void removeShipFromCells(Ship destroyedShip) {
        for (Cell cell : enemyPlayer.fieldOperations().getShipCells(destroyedShip)) {
            if (cell.getCellShip().equals(destroyedShip)) {
                cell.removeShip();
            }
        }
    }
}
