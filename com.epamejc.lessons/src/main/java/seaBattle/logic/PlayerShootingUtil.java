package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.Player;
import seaBattle.data.Ship;
import seaBattle.data.enums.CellStatus;
import seaBattle.data.enums.SystemMessages;

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

    public boolean isCellShot(Cell potentialFireCell) {
        return enemyBannedCells.contains(potentialFireCell);
    }

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
                // добавляем ячейку в бан и ставим статус
                fireCell.setCellStatus(CellStatus.HIT.getStatus());
                enemyBannedCells.add(fireCell);
            }
            return true;
        } else {
            System.out.println(SystemMessages.playerMiss.getMessage());
            // добавляем ячейку в бан и ставим статус
            fireCell.setCellStatus(CellStatus.MISSED.getStatus());
            enemyBannedCells.add(fireCell);
            return false;
        }
    }

    public void processDestroyedShip(Ship destroyedShip) {
        // забираем все ячейки в радиусе корабля и ставим им статус, добавляем в бан
        List<Cell> destroyedShipCells = enemyPlayer.fieldOperations().getShipAndRadiusCells(destroyedShip);
        for (Cell cell : destroyedShipCells) {
            cell.setCellStatus(CellStatus.HIT.getStatus());
            if (!enemyBannedCells.contains(cell)) {
                enemyBannedCells.add(cell);
            }
        }
        // удаляем корабль у ячеек
        removeShipFromCells(destroyedShip);
        // удаляем корабль из листа кораблей бота
        enemyPlayer.shipsOperations().removeShip(destroyedShip);
    }

    private void removeShipFromCells(Ship destroyedShip) {
        for (Cell cell : enemyPlayer.fieldOperations().getShipCells(destroyedShip)) {
            if (cell.getCellShip().equals(destroyedShip)) {
                cell.removeShip();
            }
        }
    }
}
