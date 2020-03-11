package homeworks.seabatle.model.board;


import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.factories.ShipAutoGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FieldTest {
    private Field field;
    private ShipsRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new ShipAutoGenerator().getGeneratedRepository();
        field = new Field(repository);
    }

    @Test
    public void testGetStrikeRes() {
        for (int i = 0; i < 5000; i++) {
            ShipsRepository repository = new ShipAutoGenerator().getGeneratedRepository();
            Field field = new Field(repository);
            List<Ship> ships = new ArrayList<>();
            ships.addAll(repository.getAll());
            StrikeResult result = null;
            assertEquals(ships, repository.getAll());
            int j = 0;
            for (Ship ship : ships) {
                int[] coords = ship.getCoords();
                for (int coord : coords) {
                    result = field.getStrikeRes(coord);
                    j = coord;
                }
            }
            StrikeResult result2 = field.getStrikeRes(j);
            assertThat(result2, is(StrikeResult.SHOOT));
            assertEquals(0, repository.getSize());
            assertThat(result, is(StrikeResult.LOSE));
        }

    }

    @Test
    public void testToString1() {
        assertEquals(253, field.toString().length());
    }

    @Test
    public void testGetFieldArray() {
        List<String> printField = field.getFieldArray();
        assertEquals(11, printField.size());
        assertEquals(22, printField.get(2).length());
    }
}