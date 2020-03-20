package homework.seabattle.model;

import homework.seabattle.model.ships.HorizontalShip;
import homework.seabattle.model.ships.Ship;
import homework.seabattle.model.ships.VerticalShip;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TacticalSituationTest {

    private TacticalSituation situation;

    @Before
    public void setup()
    {
        situation = new TacticalSituation();
    }

    @Test
    public void searchShip() {

        Coordinate coordinate1 = new Coordinate('a', 1);
        situation.setCellState(coordinate1, CellState.State.DAMAGED);
        situation.setCellState(new Coordinate('a', 2), CellState.State.DAMAGED);
        situation.setCellState(new Coordinate('a', 3), CellState.State.DAMAGED);

        Ship ship1 = situation.searchShip(coordinate1);
        assertTrue(ship1 instanceof VerticalShip);
        assertEquals(3, ship1.getLength());

        Coordinate coordinate2 = new Coordinate('g', 5);
        situation.setCellState(coordinate2, CellState.State.DAMAGED);
        situation.setCellState(new Coordinate('h', 5), CellState.State.DAMAGED);

        Ship ship2 = situation.searchShip(coordinate2);
        assertTrue(ship2 instanceof HorizontalShip);
        assertEquals(2, ship2.getLength());
    }

    @Test
    public void setCellState() {
        Coordinate coordinate1 = new Coordinate('b', 2);
        assertEquals(CellState.State.UNCHECKED, situation.getCellState(coordinate1));

        situation.setCellState(coordinate1, CellState.State.DAMAGED);
        assertEquals(CellState.State.DAMAGED, situation.getCellState(coordinate1));

        Coordinate coordinate2 = new Coordinate('f', 6);
        assertEquals(CellState.State.UNCHECKED, situation.getCellState(coordinate2));

        situation.setCellState(coordinate2, CellState.State.DAMAGED);
        assertEquals(CellState.State.DAMAGED, situation.getCellState(coordinate2));
    }
}