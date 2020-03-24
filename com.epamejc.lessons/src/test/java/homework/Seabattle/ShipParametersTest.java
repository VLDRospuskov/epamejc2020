package homework.Seabattle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShipParametersTest {

    public class TestCase {
        private ShipParameters shipParameters;
        private CellCoordinates expectedTopLeft;
        private CellCoordinates expectedBottomRight;

        public TestCase(ShipParameters shipParameters,
                        CellCoordinates expectedTopLeft,
                        CellCoordinates expectedBottomRight) {
            this.shipParameters = shipParameters;
            this.expectedTopLeft = expectedTopLeft;
            this.expectedBottomRight = expectedBottomRight;
        }
    }

    @Test
    public void getShipArea() {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase(new ShipParameters(
                new CellCoordinates('b', 2), 2, Direction.RIGHT)
                , new CellCoordinates('a', 1)
                , new CellCoordinates('d', 3)));
        testCases.add(new TestCase(new ShipParameters(
                new CellCoordinates('b', 5), 1, Direction.UP)
                , new CellCoordinates('a', 4)
                , new CellCoordinates('c', 6)));
        testCases.add(new TestCase(new ShipParameters(
                new CellCoordinates('e', 6), 1, Direction.UP)
                , new CellCoordinates('d', 5)
                , new CellCoordinates('f', 7)));
        testCases.add(new TestCase(new ShipParameters(
                new CellCoordinates('d', 10), 1, Direction.UP)
                , new CellCoordinates('c', 9)
                , new CellCoordinates('e', 11)));
        testCases.add(new TestCase(new ShipParameters(
                new CellCoordinates('i', 9), 1, Direction.UP)
                , new CellCoordinates('h', 8)
                , new CellCoordinates('j', 10)));

        for (TestCase tc : testCases) {
            assertEquals(tc.expectedTopLeft, tc.shipParameters.getShipAreaTopLeft());
            assertEquals(tc.expectedBottomRight, tc.shipParameters.getShipAreaBottomRight());
        }
    }
}