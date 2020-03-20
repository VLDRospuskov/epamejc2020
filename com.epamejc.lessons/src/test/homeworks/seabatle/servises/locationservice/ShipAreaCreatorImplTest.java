package homeworks.seabatle.servises.locationservice;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShipAreaCreatorImplTest {
    private ShipAreaCreator creator;

    @Before
    public void setUp() throws Exception {
        creator = new ShipAreaCreatorImpl();

    }

    @Test
    public void getCrossArea() {
        List<Integer> expected1 = Arrays.asList(21, 10, 30);
        assertEquals(expected1, creator.getCrossArea(20));

        List<Integer> expected2 = Arrays.asList(50, 52, 41, 61);
        assertEquals(expected2, creator.getCrossArea(51));

        List<Integer> expected3 = Arrays.asList(1, 10);
        assertEquals(expected3, creator.getCrossArea(0));

        List<Integer> expected4 = Arrays.asList(8, 19);
        assertEquals(expected4, creator.getCrossArea(9));

        List<Integer> expected5 = Arrays.asList(98, 89);
        assertEquals(expected5, creator.getCrossArea(99));

        List<Integer> expected6 = Arrays.asList(91, 80);
        assertEquals(expected6, creator.getCrossArea(90));

        List<Integer> expected7 = Arrays.asList(7, 9, 18);
        assertEquals(expected7, creator.getCrossArea(8));
    }

    @Test
    public void getDiagonalArea() {
        List<Integer> expected1 = Arrays.asList(11, 31);
        assertEquals(expected1, creator.getDiagonalArea(20));

        List<Integer> expected2 = Arrays.asList(40, 60, 42, 62);
        assertEquals(expected2, creator.getDiagonalArea(51));

        List<Integer> expected3 = Arrays.asList(11);
        assertEquals(expected3, creator.getDiagonalArea(0));

        List<Integer> expected4 = Arrays.asList(7, 27, 9, 29);
        assertEquals(expected4, creator.getDiagonalArea(18));

        List<Integer> expected5 = Arrays.asList(88);
        assertEquals(expected5, creator.getDiagonalArea(99));

        List<Integer> expected6 = Arrays.asList(81);
        assertEquals(expected6, creator.getDiagonalArea(90));

    }
}