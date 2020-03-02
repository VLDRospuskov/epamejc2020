package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.CellStatus;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FieldOperationsTest {

//    private static FieldOperations testFieldOperations;
//    @BeforeClass
//    public static void initClass() {
//        testFieldOperations = new FieldOperations();
//    }

    /**
     * Testing method {@link FieldOperations#getCellByCoords(int, int)}
     */
    @Test
    public void testGetCellByCoords() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        int expectedCoordX = 6;
        int expectedCoordY = 5;
        Cell actualCell = testFieldOperations.getCellByCoords(expectedCoordX, expectedCoordY);
        int actualCoordX = actualCell.getxCoord();
        int actualCoordY = actualCell.getyCoord();
        Assert.assertEquals(expectedCoordX, actualCoordX);
        Assert.assertEquals(expectedCoordY, actualCoordY);
    }

    /**
     * Testing method {@link FieldOperations#getCellByDirection(String, int, int, int)}
     */
    @Test
    public void testGetCellByDirection() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        int step = 2;
        int coordX1 = 2;
        int coordY1 = 2;
        String direction1 = Directions.RIGHT.getDirection();
        String direction2 = Directions.DOWN.getDirection();
        Cell actualCell1 = testFieldOperations.getCellByDirection(direction1, coordX1, coordY1, step);
        Cell expectedCell1 = new Cell(-1, 3, 2, CellStatus.HIDDEN.getStatus());
        Cell actualCell2 = testFieldOperations.getCellByDirection(direction2, coordX1, coordY1, step);
        Cell expectedCell2 = new Cell(-2, 2, 3, CellStatus.HIDDEN.getStatus());
        Assert.assertEquals(expectedCell1.getxCoord(), actualCell1.getxCoord());
        Assert.assertEquals(expectedCell1.getyCoord(), actualCell1.getyCoord());
        Assert.assertEquals(expectedCell2.getxCoord(), actualCell2.getxCoord());
        Assert.assertEquals(expectedCell2.getyCoord(), actualCell2.getyCoord());
    }

    /**
     * Testing method {@link FieldOperations#getShipCells(Ship)}
     */
    @Test
    public void testGetShipCells() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        Ship testShip1 = generateShip(2,5, Directions.RIGHT.getDirection(),2);
        Ship testShip2 = generateShip(2, 5, Directions.LEFT.getDirection(), 2);
        List<Cell> expectedShipCellsList1 = new ArrayList<>();
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(2,5));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(3,5));
        List<Cell> expectedShipCellsList2 = new ArrayList<>();
        expectedShipCellsList2.add(testFieldOperations.getCellByCoords(1,5));
        expectedShipCellsList2.add(testFieldOperations.getCellByCoords(2,5));
        List<Cell> actualShipCellsList1 = testFieldOperations.getShipCells(testShip1);
        List<Cell> actualShipCellsList2 = testFieldOperations.getShipCells(testShip2);
        assertThat(actualShipCellsList1, is(expectedShipCellsList1));
        assertThat(actualShipCellsList2, is(expectedShipCellsList2));
    }

    /**
     * Testing method {@link FieldOperations#getShipAndRadiusCells(Ship)}
     */
    @Test
    public void testGetShipAndRadiusCells() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        Ship testShip1 = generateShip(9,1, Directions.RIGHT.getDirection(),2);
        List<Cell> expectedShipCellsList1 = new ArrayList<>();
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(8,1));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(9,1));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(10,1));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(8,2));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(9,2));
        expectedShipCellsList1.add(testFieldOperations.getCellByCoords(10,2));
        List<Cell> actualShipCellsList1 = testFieldOperations.getShipAndRadiusCells(testShip1);
        assertThat(actualShipCellsList1, is(expectedShipCellsList1));
    }

    /**
     * Testing method {@link FieldOperations#checkFieldBorder(String, int, int, int)}
     */
    @Test
    public void testCheckFieldBorder() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        int coordX = 3;
        int coordY = 8;
        int step = 4;
        boolean actual1 = testFieldOperations.checkFieldBorder(Directions.UP.getDirection(), coordX, coordY, step);
        boolean actual2 = testFieldOperations.checkFieldBorder(Directions.LEFT.getDirection(), coordX, coordY, step);
        boolean actual3 = testFieldOperations.checkFieldBorder(Directions.DOWN.getDirection(), coordX, coordY, step);
        boolean actual4 = testFieldOperations.checkFieldBorder(Directions.RIGHT.getDirection(), coordX, coordY, step);
        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
        Assert.assertTrue(actual4);
    }

    /**
     * Testing method {@link FieldOperations#getTopDirectionRadius(int, int, int)}
     */
    @Test
    public void getTopDirectionRadius() {
        FieldOperations testFieldOperations = new FieldOperations();
        testFieldOperations.generateField();
        List<Cell> expectedCellsList = new ArrayList<>();
        expectedCellsList.add(testFieldOperations.getCellByCoords(1,1));
        expectedCellsList.add(testFieldOperations.getCellByCoords(2,1));
        expectedCellsList.add(testFieldOperations.getCellByCoords(1,2));
        expectedCellsList.add(testFieldOperations.getCellByCoords(2,2));
        List<Cell> actualCellsList = testFieldOperations.getTopDirectionRadius(1, 1, 1);
        assertThat(actualCellsList, is(expectedCellsList));
    }

    /**
     * Method generates {@link Ship} object with specific attributes
     * @param coordX horizontal coordinate value
     * @param coordY vertical coordinate value
     * @param direction direction of ship
     * @param shipDecksNumber number of ship decks
     * @return {@link Ship} object
     */
    private Ship generateShip(int coordX, int coordY, String direction, int shipDecksNumber) {
        Ship testShip = new Ship(ShipType.DESTROYER.getType(), shipDecksNumber);
        testShip.setDirection(direction);
        testShip.setShipCoordX(coordX);
        testShip.setShipCoordY(coordY);
        return testShip;
    }
}