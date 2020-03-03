package seabattle.java;

import java.util.ArrayList;
import java.util.Arrays;

import static seabattle.java.Utils.*;

public class SeaBattle {

    public void run() {
        Engine engine = new Engine();
        engine.startWithManualShipPlacement();


//        ArrayList params = scanShipParams();
//        Integer[] i1 = (Integer[]) params.get(1);
//        Integer[] i2 = (Integer[]) params.get(2);
//
//        System.out.println(" " + params.get(0) + " " + Arrays.toString(i1) + " " + Arrays.toString(i2));

//       Integer[] coord = scanCoordinates();
//        System.out.println(" " + coord[0] + " " + coord[1]);
//        Integer shipType = scanShipType();
//        System.out.println(shipType);

    }

    public void setShips(Field field) {
        Ship ship11 = new Ship(1, new Integer[]{9,9}, new Integer[]{9,9}, field);
        Ship ship12 = new Ship(1, new Integer[]{8,5}, new Integer[]{8,5}, field);
        Ship ship13 = new Ship(1, new Integer[]{3,4}, new Integer[]{3,4}, field);
        Ship ship14 = new Ship(1, new Integer[]{7,1}, new Integer[]{7,1}, field);
        Ship ship21 = new Ship(2, new Integer[]{2,7}, new Integer[]{2,8}, field);
        Ship ship22 = new Ship(2, new Integer[]{0,0}, new Integer[]{1,0}, field);
        Ship ship23 = new Ship(2, new Integer[]{8,8}, new Integer[]{8,9}, field);
        Ship ship31 = new Ship(3, new Integer[]{5,7}, new Integer[]{5,9}, field);
        Ship ship32 = new Ship(3, new Integer[]{0,6}, new Integer[]{0,8}, field);
        Ship ship4 = new Ship(4, new Integer[]{2,2}, new Integer[]{5,2}, field);
    }

}
