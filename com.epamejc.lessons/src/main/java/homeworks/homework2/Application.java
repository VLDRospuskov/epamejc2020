package homeworks.homework2;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ImmutableSpatialDimension c137 = new ImmutableSpatialDimension("C-137");
        ArrayList<String> family = new ArrayList();
        family.add("Morty");
        family.add("Summer");
        family.add("Bet");
        family.add("Jerry");

        RickSanchez rickC137 = new RickSanchez("Rick Sanchez", c137, family);
        System.out.println(rickC137);

        family.remove("Morty");
        System.out.println(family);

        System.out.println(rickC137);

        SpatialDimension c132 = new SpatialDimension("C-132");
        RickSanchez rickC132 = new RickSanchez("Rick Sanchez", c132, family);
        System.out.println(rickC132);

        c132.setName("C-123");
        System.out.println(c132);

        System.out.println(rickC132);
    }
}
