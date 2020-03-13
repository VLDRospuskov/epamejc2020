package seabattle.java;

import lombok.Data;

import java.util.ArrayList;
import java.util.Random;

@Data
public class AI {

    protected ArrayList generateRandomShipParamsByShipType(int shipType) {
        ArrayList params = new ArrayList();
        params.add(shipType);
        Integer[] startYX = new Integer[2];
        Integer[] endYX = new Integer[2];
        boolean isHorizontal = new Random().nextBoolean();
        if (isHorizontal) {
            params = generateRandomHorizontalShip(params, startYX, endYX, shipType);
        } else {
            params = generateRandomVerticalShip(params, startYX, endYX, shipType);
        }
        return params;
    }

    private ArrayList generateRandomHorizontalShip(ArrayList params, Integer[] startYX, Integer[] endYX, int shipType) {
        startYX[0] = new Random().nextInt(10);
        startYX[1] = new Random().nextInt(10 - (shipType - 1));
        endYX[0] = startYX[0];
        endYX[1] = startYX[1] + (shipType - 1);
        params.add(startYX);
        params.add(endYX);
        return params;
    }

    private ArrayList generateRandomVerticalShip(ArrayList params, Integer[] startYX, Integer[] endYX, int shipType) {
        startYX[0] = new Random().nextInt(10 - (shipType - 1));
        startYX[1] = new Random().nextInt(10);
        endYX[0] = startYX[0] + (shipType - 1);
        endYX[1] = startYX[1];
        params.add(startYX);
        params.add(endYX);
        return params;
    }

    protected Integer[] generateRandomCoordinate(Field field) {
        boolean isAlreadyHit;
        Integer[] coordYX;
        do {
            isAlreadyHit = false;
            coordYX = new Integer[2];
            coordYX[0] = new Random().nextInt(10);
            coordYX[1] = new Random().nextInt(10);
            if (field.getField().get(coordYX[0]).get(coordYX[1]).isHit()) {
                isAlreadyHit = true;
            }
        } while (isAlreadyHit);
        return coordYX;
    }

}
