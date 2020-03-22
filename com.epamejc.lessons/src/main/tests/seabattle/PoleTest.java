package seabattle;

import org.junit.Test;

import static org.junit.Assert.*;

public class PoleTest {


    @Test
    public void printPole() {
        Pole pole = new Pole();
        pole.addShipPart(0, 0);
        pole.addHitPass(1, 1);
        String o =
                "DCCCCCCCCC" +
                        "CHCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC";
        assertEquals(pole.printPole(), o);
    }

    @Test
    public void addShipPart() {
        Pole pole = new Pole();
        pole.addShipPart(3, 3);
        String o =
                "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCDCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC";
        assertEquals(pole.printPole(), o);


    }

    @Test
    public void getCellId() {
        Pole pole = new Pole();
        assertEquals(pole.getCellId(3, 3), 33);
    }


    @Test
    public void addHitPass() {
        Pole pole = new Pole();
        pole.addHitPass(1, 1);
        String o =
                "CCCCCCCCCC" +
                        "CHCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC" +
                        "CCCCCCCCCC";
        assertEquals(pole.printPole(), o);
    }
}
