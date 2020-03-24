package homework.Seabattle;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameFieldTest {

    class TestCaseCell {
        char ch;
        int num;
        CellState cellState;

        private TestCaseCell(char ch, int num, CellState cellState) {
            this.ch = ch;
            this.num = num;
            this.cellState = cellState;
        }
    }

    class TestCaseShipParameter {
        char ch;
        int i;
        int size;
        Direction direction;
        boolean isLegal;
        CellCoordinates expectedC1;

        public TestCaseShipParameter(char ch, int i, int size, Direction direction, boolean isLegal,
                                     CellCoordinates expectedC1, CellCoordinates expectedC2) {
            this.ch = ch;
            this.i = i;
            this.size = size;
            this.direction = direction;
            this.isLegal = isLegal;
            this.expectedC1 = expectedC1;
            this.expectedC2 = expectedC2;
        }

        CellCoordinates expectedC2;

        @Override
        public String toString() {
            return "TestCaseShipParameter{" +
                    "ch=" + ch +
                    ", i=" + i +
                    ", size=" + size +
                    ", direction=" + direction +
                    ", isLegal=" + isLegal +
                    ", expectedC1=" + expectedC1 +
                    ", expectedC2=" + expectedC2 +
                    '}';
        }

//        public TestCaseShipParameter(char ch, int i, int size,
//                                     Direction direction, boolean isLegal) {
//            this.ch = ch;
//            this.i = i;
//            this.size = size;
//            this.direction = direction;
//            this.isLegal = isLegal;
//        }
//
//        public TestCaseShipParameter(char ch, int i, int size, Direction direction,
//                                     CellCoordinates expectedC1, CellCoordinates expectedC2) {
//            this.ch = ch;
//            this.i = i;
//            this.size = size;
//            this.direction = direction;
//            this.expectedC1 = expectedC1;
//            this.expectedC2 = expectedC2;
//        }
//
//        public TestCaseShipParameter(boolean isLegal, CellCoordinates expectedC1, CellCoordinates expectedC2) {
//            this.isLegal = isLegal;
//            this.expectedC1 = expectedC1;
//            this.expectedC2 = expectedC2;
//        }
    }

    @Test
    public void setCell() {
        GameField gameField = new GameField();


        TestCaseCell[] testCaseCells = new TestCaseCell[]{
                new TestCaseCell('a', 4, CellState.MISSED),
                new TestCaseCell('h', 5, CellState.SHIP),
                new TestCaseCell('f', 10, CellState.MISSED),
                new TestCaseCell('A', 4, CellState.SHIP_HIT),
                new TestCaseCell('r', 4, CellState.OUT_OF_BOUNDS),
                new TestCaseCell('k', 11, CellState.OUT_OF_BOUNDS),
                new TestCaseCell('h', 15, CellState.OUT_OF_BOUNDS)
        };

        for (TestCaseCell testCaseCell : testCaseCells) {
            if (testCaseCell.cellState != CellState.OUT_OF_BOUNDS)
                gameField.setCell(testCaseCell.ch, testCaseCell.num, testCaseCell.cellState);
            assertEquals(testCaseCell.cellState, gameField.getCellState(testCaseCell.ch, testCaseCell.num));
        }

    }


    @Test
    public void createShip() {
        GameField gameField = new GameField();
        gameField.createShip('a', 3, 1, Direction.UP);
        gameField.createShip('h', 5, 4, Direction.DOWN);
        gameField.createShip('e', 2, 2, Direction.RIGHT);
        gameField.createShip('g', 6, 2, Direction.LEFT);

        Set<CellCoordinates> isShip = new HashSet<>();

        isShip.add(new CellCoordinates('a', 3));

        isShip.add(new CellCoordinates('h', 5));
        isShip.add(new CellCoordinates('h', 6));
        isShip.add(new CellCoordinates('h', 7));
        isShip.add(new CellCoordinates('h', 8));

        isShip.add(new CellCoordinates('e', 2));
        isShip.add(new CellCoordinates('f', 2));

        isShip.add(new CellCoordinates('g', 6));
        isShip.add(new CellCoordinates('f', 6));

        for (int i = 1; i <= 10; i++) {
            for (char ch = 'a'; ch <= 'j'; ch++) {
                if (isShip.contains(new CellCoordinates(ch, i))) {
                    assertEquals(CellState.SHIP, gameField.getCellState(ch, i));
                } else {
                    assertEquals(CellState.EMPTY, gameField.getCellState(ch, i));
                }
            }
        }
    }

    List<TestCaseShipParameter> testCaseShipParameters = new LinkedList<>();

    {
        testCaseShipParameters.add(new TestCaseShipParameter('e', 1, 4, Direction.RIGHT, false,
                new CellCoordinates('d', 0), new CellCoordinates('i', 2)));
        testCaseShipParameters.add(new TestCaseShipParameter('e', 2, 2, Direction.RIGHT, false,
                new CellCoordinates('d', 1), new CellCoordinates('g', 3)));
        testCaseShipParameters.add(new TestCaseShipParameter('h', 5, 4, Direction.DOWN, false,
                new CellCoordinates('g', 4), new CellCoordinates('i', 9)));
        testCaseShipParameters.add(new TestCaseShipParameter('a', 3, 3, Direction.UP, true,
                new CellCoordinates((char) ('a' - 1), 0), new CellCoordinates('b', 4)));
        testCaseShipParameters.add(new TestCaseShipParameter('a', 3, 4, Direction.LEFT, false,
                new CellCoordinates((char) ('a' - 4), 2), new CellCoordinates('b', 4)));
        testCaseShipParameters.add(new TestCaseShipParameter('a', 1, 4, Direction.UP, false,
                new CellCoordinates((char) ('a' - 1), -3), new CellCoordinates('b', 2)));
        testCaseShipParameters.add(new TestCaseShipParameter('j', 1, 4, Direction.RIGHT, false,
                new CellCoordinates('i', 0), new CellCoordinates((char) ('j' + 4), 2)));
        testCaseShipParameters.add(new TestCaseShipParameter('a', 10, 4, Direction.DOWN, false,
                new CellCoordinates((char) ('a' - 1), 9), new CellCoordinates('b', 14)));
        testCaseShipParameters.add(new TestCaseShipParameter('e', 2, 2, Direction.DOWN, false,
                new CellCoordinates((char) ('d'), 1), new CellCoordinates('f', 4)));

    }

    @Test
    public void areaToCheckTest() {
        GameField gameField = new GameField();

        CellCoordinates c1 = new CellCoordinates();
        CellCoordinates c2 = new CellCoordinates();
        for (TestCaseShipParameter tcsp : testCaseShipParameters) {
            System.out.println(tcsp);
            gameField.areaToCheck(tcsp.ch, tcsp.i, tcsp.size, tcsp.direction, c1, c2);
            assertEquals(tcsp.expectedC1, c1);
            assertEquals(tcsp.expectedC2, c2);
        }
    }

    @Test
    public void checkNewShipAreaTest() {
        GameField gameField = new GameField();

        gameField.createShip('f', 2, 4, Direction.RIGHT);
        gameField.createShip('c', 4, 1, Direction.UP);
        gameField.createShip('h', 8, 3, Direction.DOWN);

        System.out.println(gameField);

        for (TestCaseShipParameter tcsp : testCaseShipParameters) {
            System.out.println(tcsp);
            assertEquals(tcsp.isLegal, gameField.checkNewShipArea(tcsp.expectedC1, tcsp.expectedC2));
        }
    }

    @Test
    public void checkCreateShipTest() {
        GameField gameField = new GameField();

        gameField.createShip('f', 2, 4, Direction.RIGHT);
        gameField.createShip('c', 4, 1, Direction.UP);
        gameField.createShip('h', 8, 3, Direction.DOWN);

        System.out.println(gameField);

        for (TestCaseShipParameter tcsp : testCaseShipParameters) {
            System.out.println(tcsp);
            assertEquals(tcsp.isLegal, gameField.checkCreateShip(tcsp.ch, tcsp.i, tcsp.size, tcsp.direction));
        }
    }

    @Test
    public void getSetOfShipCellsTest() {

        class TestCase {
            private Set<CellCoordinates> ship;

            private TestCase(Set<CellCoordinates> ship) {
                this.ship = ship;
            }
        }

        List<TestCase> testCases = new LinkedList<>();
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('b', 2),
                new CellCoordinates('c', 2),
                new CellCoordinates('d', 2),
                new CellCoordinates('e', 2)))));
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('a', 2),
                new CellCoordinates('b', 2)
        ))));
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('a', 7),
                new CellCoordinates('a', 8),
                new CellCoordinates('a', 9),
                new CellCoordinates('a', 10)
        ))));

        GameField gameField = new GameField();

        for (TestCase tc : testCases) {
            gameField.clear();
            for (CellCoordinates cc : tc.ship) {
                gameField.setCell(cc, CellState.SHIP_HIT);
            }
            for (CellCoordinates cc : tc.ship) {
                assertEquals(tc.ship, gameField.getSetOfShipCells(cc, false));
            }
        }

    }

    @Test
    public void checkShipDestroyedTest() {

        class TestCase {
            private Set<CellCoordinates> shipHit;
            private Set<CellCoordinates> shipIntact;

            private TestCase(Set<CellCoordinates> shipHit, Set<CellCoordinates> shipIntact) {
                this.shipHit = shipHit;
                this.shipIntact = shipIntact;
            }
        }

        List<TestCase> testCases = new LinkedList<>();
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('b', 2),
                new CellCoordinates('c', 2),
                new CellCoordinates('d', 2),
                new CellCoordinates('e', 2))),
                new HashSet<>()));
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('a', 2),
                new CellCoordinates('b', 2))),
                new HashSet<>()));
        testCases.add(new TestCase(new HashSet<>(Arrays.asList(
                new CellCoordinates('a', 7),
                new CellCoordinates('a', 8),
                new CellCoordinates('a', 9),
                new CellCoordinates('a', 10))),
                new HashSet<>()));
        testCases.add(new TestCase(
                new HashSet<>(Arrays.asList(
                        new CellCoordinates('e', 6),
                        new CellCoordinates('e', 5)
                )),
                new HashSet<>(Collections.singletonList(
                        new CellCoordinates('e', 7)
                ))
        ));

        GameField gameField = new GameField();

        for (TestCase tc : testCases) {
            gameField.clear();
            for (CellCoordinates cc : tc.shipHit) {
                gameField.setCell(cc, CellState.SHIP_HIT);
            }
            for (CellCoordinates cc : tc.shipIntact) {
                gameField.setCell(cc, CellState.SHIP);
            }
            for (CellCoordinates cc : tc.shipHit) {
                assertEquals(tc.shipIntact.isEmpty() ? tc.shipHit.size() : 0, gameField.checkShipDestroyed(cc));
            }
            for (CellCoordinates cc : tc.shipIntact) {
                assertEquals(tc.shipIntact.isEmpty() ? tc.shipHit.size() : 0, gameField.checkShipDestroyed(cc));
            }
        }

    }
}