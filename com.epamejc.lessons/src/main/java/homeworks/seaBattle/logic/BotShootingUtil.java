package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Configuration;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.CellStatus;
import homeworks.seaBattle.data.enums.SystemMessages;
import homeworks.seaBattle.utils.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class BotShootingUtil extends PlayerShootingUtil {

    private final int STEP = 2;
    private boolean isPointFixed;
    private String shotDirection;
    private int shotCoordX;
    private int shotCoordY;
    private int offset;
    private Set<String> firingDirections = new HashSet<>();

    public BotShootingUtil(Player enemy) {
        super(enemy);
        this.isPointFixed = false;
        this.offset = 0;
    }

    /**
     * Method describes the algorithm of shooting at a human player field
     * after the first successful shot in the series
     *
     * @param shotCoordinates cell coordinates of the enemy field
     * @return true/false if computer hits or misses enemy ship
     */
    @Override
    public boolean shot(int[] shotCoordinates) {
        if (isPointFixed) {
            Cell fireCell = getEnemyPlayer().fieldOperations()
                    .getCellByDirection(shotDirection, shotCoordX, shotCoordY, offset + 1);
            Ship enemyShip = fireCell.getCellShip();
            if (enemyShip != null) {
                enemyShip.hitShip();
                if (enemyShip.isDestroyed()) {
                    System.out.println(SystemMessages.botKill.getMessage());
                    processDestroyedShip(enemyShip);
                    clearShotCoordinates();
                } else {
                    System.out.println(SystemMessages.botHit.getMessage());
                    fireCell.setCellStatus(CellStatus.HIT.getStatus());
                    getEnemyBannedCells().add(fireCell);
                    offset++;
                }
                return true;
            } else {
                System.out.println(SystemMessages.botMiss.getMessage());
                fireCell.setCellStatus(CellStatus.MISSED.getStatus());
                getEnemyBannedCells().add(fireCell);
                this.shotDirection = generateFireDirection(new int[]{shotCoordX, shotCoordY});
                this.offset = 1;
                return false;
            }
        } else {
            return randomShooting(shotCoordinates);
        }
    }

    /**
     * Method describes the algorithm of shooting at a human player field
     * after an unsuccessful hit or during the first shot
     *
     * @param shotCoordinates cell coordinates of the enemy field
     * @return true/false if computer hits or misses enemy ship
     */
    public boolean randomShooting(int[] shotCoordinates) {
        int[] validShotCoordinates = checkOrGenerateCoordinates(shotCoordinates);
        Cell fireCell = getEnemyPlayer().fieldOperations()
                .getCellByCoords(validShotCoordinates[0], validShotCoordinates[1]);
        Ship enemyShip = fireCell.getCellShip();
        if (enemyShip != null) {
            enemyShip.hitShip();
            if (enemyShip.isDestroyed()) {
                System.out.println(SystemMessages.botKill.getMessage());
                processDestroyedShip(enemyShip);
            } else {
                System.out.println(SystemMessages.botHit.getMessage());
                fireCell.setCellStatus(CellStatus.HIT.getStatus());
                getEnemyBannedCells().add(fireCell);
                setShotCoordinates(validShotCoordinates);
            }
            return true;
        } else {
            System.out.println(SystemMessages.botMiss.getMessage());
            fireCell.setCellStatus(CellStatus.MISSED.getStatus());
            getEnemyBannedCells().add(fireCell);
            return false;
        }
    }

    /**
     * Method for tests! Look at {@link BotShootingUtil#setShotCoordinates(int[])}
     *
     * @param validShotCoordinates direction for next shot (could be wrong)
     * @param shotDirection        coordinates of a successful shot
     */
    public void setShotCoordinatesTest(int[] validShotCoordinates, String shotDirection) {
        this.isPointFixed = true;
        this.shotCoordX = validShotCoordinates[0];
        this.shotCoordY = validShotCoordinates[1];
        this.shotDirection = shotDirection;
        this.offset = 1;
    }

    /**
     * Method for saving attributes of a successful shot
     *
     * @param validShotCoordinates coordinates of a successful shot
     */
    private void setShotCoordinates(int[] validShotCoordinates) {
        this.isPointFixed = true;
        this.shotCoordX = validShotCoordinates[0];
        this.shotCoordY = validShotCoordinates[1];
        this.shotDirection = generateFireDirection(validShotCoordinates);
        this.offset = 1;
    }

    /**
     * Method removes flag {@link BotShootingUtil#isPointFixed}
     */
    private void clearShotCoordinates() {
        this.isPointFixed = false;
    }

    /**
     * Method checks given coordinates and generates new ones if the given coordinates are wrong
     *
     * @param shotCoordinates given coordinates of the new shot
     * @return array of new (if generated) or given coordinates
     */
    private int[] checkOrGenerateCoordinates(int[] shotCoordinates) {
        Cell testCell = getEnemyPlayer().fieldOperations().getCellByCoords(shotCoordinates[0], shotCoordinates[1]);
        if (!getEnemyBannedCells().contains(testCell)) {
            return shotCoordinates;
        } else {
            return generateCoordinates();
        }
    }

    /**
     * Method generates new coordinates of the new shot
     *
     * @return array of generated coordinates
     */
    private int[] generateCoordinates() {
        boolean areCoordsValid = false;
        int[] newCoords = new int[2];
        while (!areCoordsValid) {
            newCoords[0] = RandomNumberGenerator.generateRandomInRange(Configuration.getFieldSize());
            newCoords[1] = RandomNumberGenerator.generateRandomInRange(Configuration.getFieldSize());
            Cell testCell = getEnemyPlayer().fieldOperations().getCellByCoords(newCoords[0], newCoords[1]);
            if (!getEnemyBannedCells().contains(testCell)) {
                areCoordsValid = true;
            }
        }
        return newCoords;
    }

    /**
     * Method determines the direction for shooting after a successful hit
     * (with checking {@link BotShootingUtil#firingDirections} of previous direction options)
     *
     * @param coordinates coordinates of successful hit
     * @return direction for shooting
     */
    private String generateFireDirection(int[] coordinates) {
        boolean isCorrectDirection = false;
        String direction = "";
        while (!isCorrectDirection) {
            direction = RandomNumberGenerator.generateRandomDirection();
            if (!firingDirections.contains(direction)) {
                if (getEnemyPlayer().fieldOperations().checkFieldBorder(direction, coordinates[0],
                        coordinates[1], STEP)) ;
                {
                    if (checkNextCell(direction, coordinates[0], coordinates[1], STEP)) {
                        break;
                    }
                }
            }
        }
        return direction;
    }

    /**
     * Method checks the field border for the next cell
     *
     * @param direction shooting direction
     * @param xCoord    horizontal coordinate
     * @param yCoord    vertical coordinate
     * @param step      distance from original shooting coordinate
     * @return true/false if there is/is not field border
     */
    private boolean checkNextCell(String direction, int xCoord, int yCoord, int step) {
        Cell checkCell = getEnemyPlayer().fieldOperations().getCellByDirection(direction, xCoord, yCoord, step);

        if (checkCell == null) {
            return false;
        } else {
            return !getEnemyBannedCells().contains(checkCell);
        }
    }
}
