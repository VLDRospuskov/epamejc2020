package homeworks.homework2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class RickSanchezTest {

    private static RickSanchez rickC137;
    private static ArrayList<String> family;
    private static SpatialDimension spatialDimension;

    @BeforeClass
    public static void setup() {
        family = new ArrayList<>();
        family.add("Morty");
        family.add("Summer");
        family.add("Bet");
        family.add("Jerry");

        spatialDimension = new SpatialDimension("C-137");
        rickC137 = new RickSanchez("Rick Sanchez", spatialDimension, family);
    }

    @Test
    public void testRickSanchez() {
        String rickExpected = "RickSanchez{" +
                "name='Rick Sanchez', " +
                "spatialDimension=SpatialDimension{name='C-137'}, " +
                "family=[Morty, Summer, Bet, Jerry]}";

        String rickActual = rickC137.toString();

        Assert.assertEquals(rickExpected, rickActual);
    }

}