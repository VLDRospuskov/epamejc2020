package seabattle.java;

import org.junit.*;
import seabattle.java.models.Field;
import seabattle.java.models.Ship;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static seabattle.java.Utils.*;

public class UtilsTest {

    @Test
    public void checkBadCoordinatesTest() {
        Integer[] coordYX = {11, 2};
        boolean expected = true;
        boolean actual = checkBadCoordinates(coordYX);
        assertEquals(expected, actual);
    }

    @Test
    public void checkShipTypeTest() {
        int shipType = 0;
        boolean expected = true;
        boolean actual = checkBadShipType(shipType);
        assertEquals(expected, actual);
        shipType = 7;
        actual = checkBadShipType(shipType);
        assertEquals(expected, actual);
    }

    @Test
    public void sortCoordinatesAscendingTest() {
        int shipType = 3;
        Integer[] startYX = {0, 2};
        Integer[] endYX = {0, 0};
        int startY = startYX[0];
        int startX = startYX[1];
        int endY = endYX[0];
        int endX = endYX[1];

        ArrayList paramsBefore = new ArrayList();
        paramsBefore.add(shipType);
        paramsBefore.add(startYX);
        paramsBefore.add(endYX);

        ArrayList paramsAfter = sortCoordinatesAscending(paramsBefore);
        Integer[] newStartYX = (Integer[]) paramsAfter.get(1);
        Integer[] newEndYX = (Integer[]) paramsAfter.get(2);

        int newStartY = newStartYX[0];
        int newStartX = newStartYX[1];
        int newEndY = newEndYX[0];
        int newEndX = newEndYX[1];

        assertEquals(endY, newStartY);
        assertEquals(endX, newStartX);
        assertEquals(startY, newEndY);
        assertEquals(startX, newEndX);
    }

    @Test
    public void checkShipCountTest() {
        int shipType = 2;
        Field field = new Field(1);
        field.getShips().add(new Ship(shipType, new Integer[]{2, 0}, new Integer[]{3, 0}, field));
        field.getShips().add(new Ship(shipType, new Integer[]{6, 0}, new Integer[]{7, 0}, field));
        boolean expected = true;
        boolean actual = checkShipCount(field, shipType);
        assertEquals(expected, actual);

        field.getShips().add(new Ship(shipType, new Integer[]{2, 9}, new Integer[]{3, 9}, field));
        expected = false;
        actual = checkShipCount(field, shipType);
        assertEquals(expected, actual);
    }

    @Test
    public void getMaxCountOfShipByTypeTest() {
        int shipType = 2;
        int expected = 3;
        int actual = getMaxCountOfShipByType(shipType);
        assertEquals(expected, actual);
    }

    @Test
    public void checkIsCellAShipTest() {
        Integer[] startYX = new Integer[]{2, 0};
        Field field = new Field(1);
        field.getShips().add(new Ship(2, startYX, new Integer[]{3, 0}, field));
        boolean expected = true;
        boolean actual = checkIsCellAShip(field, startYX);
        assertEquals(expected, actual);

        Integer[] nonShipYX = {5, 5};
        expected = false;
        actual = checkIsCellAShip(field, nonShipYX);
        assertEquals(expected, actual);
    }

    @Test
    public void checkIsCellHitTest() {
        Integer[] startYX = new Integer[]{2, 0};
        Field field = new Field(1);
        field.getShips().add(new Ship(2, startYX, new Integer[]{3, 0}, field));
        shoot(field, startYX);
        boolean expected = true;
        boolean actual = checkIsCellHit(field, startYX);
        assertEquals(expected, actual);

        Integer[] nonHitYX = {5, 5};
        expected = false;
        actual = checkIsCellHit(field, startYX);
    }

    @Test
    public void shootTest() {
        Integer[] startYX = new Integer[]{2, 0};
        Field field = new Field(1);
        field.getShips().add(new Ship(2, startYX, new Integer[]{3, 0}, field));
        shoot(field, startYX);
        boolean expected = true;
        boolean actual = field.getField().get(startYX[0]).get(startYX[1]).isHit();
        assertEquals(expected, actual);
    }

}
