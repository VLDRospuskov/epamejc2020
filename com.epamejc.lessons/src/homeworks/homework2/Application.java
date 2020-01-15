package homeworks.homework2;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        SpatialDimension c137 = new SpatialDimension("C-137");
        List<String> family = new ArrayList();
        family.add("Morty");
        family.add("Summer");
        family.add("Bet");
        family.add("Jerry");

        RickSanchez rickC137 = new RickSanchez("Rick Sanchez", c137, family);
        System.out.println(rickC137.toString());

        SpatialDimension c132 = c137.setName("C-132");
        RickSanchez rickC132 = rickC137.setSpatialDimension(c132);

        System.out.println(rickC132.toString());
    }
}
