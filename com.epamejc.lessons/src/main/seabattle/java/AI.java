package seabattle.java;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static seabattle.java.Utils.*;

@Data
public class AI {

    private ShootData shootData;

    public AI() {
        shootData = null;
    }

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

    protected void finishingShooting(Field field) {
        Integer[] coordYX = shootData.getSTART_YX();
        int y = coordYX[0];
        int x = coordYX[1];
        if (!shootData.isDoNotShootLeft()) {
            finishingShootLeft(field, y, x);
        } else if (!shootData.isDoNotShootUp()) {
            finishingShootUp(field, y, x);
        } else if (!shootData.isDoNotShootRight()) {
            finishingShootRight(field, y, x);
        } else if (!shootData.isDoNotShootDown()) {
            finishingShootDown(field, y, x);
        }
        shootData.checkFlags();
    }

    private void finishingShootLeft(Field field, int y, int x) {
        x -= shootData.getShootLeft() + 1;
        Integer[] coordYX = new Integer[] {y, x};
//        if (!checkIsCellHit(field, coordYX)) {
            shoot(field, coordYX);
            shootData.setShootLeft(shootData.getShootLeft() + 1);
            shootData.setLastYX(coordYX);
            if (!checkIsCellAShip(field, coordYX)) {
                shootData.setDoNotShootLeft(true);
            }
            if (shootData.getShootLeft() > 1) {
                shootData.setDoNotShootUp(true);
                shootData.setDoNotShootDown(true);
            }
//        } else {
//            coordYX = generateRandomCoordinate(field);
//            shoot(field, coordYX);
//            shootData = new ShootData(coordYX);
//        }
    }

    private void finishingShootUp(Field field, int y, int x) {
        y -= shootData.getShootUp() + 1;
        Integer[] coordYX = new Integer[] {y, x};
        shoot(field, coordYX);
        shootData.setShootUp(shootData.getShootUp() + 1);
        shootData.setLastYX(coordYX);
        if (!checkIsCellAShip(field, coordYX)) {
            shootData.setDoNotShootUp(true);
        }
        if (shootData.getShootUp() > 1) {
            shootData.setDoNotShootLeft(true);
            shootData.setDoNotShootRight(true);
        }
    }

    private void finishingShootRight(Field field, int y, int x) {
        x += shootData.getShootRight() + 1;
        Integer[] coordYX = new Integer[] {y, x};
        shoot(field, coordYX);
        shootData.setShootRight(shootData.getShootRight() + 1);
        shootData.setLastYX(coordYX);
        if (!checkIsCellAShip(field, coordYX)) {
            shootData.setDoNotShootRight(true);
        }
        if (shootData.getShootRight() > 1) {
            shootData.setDoNotShootUp(true);
            shootData.setDoNotShootDown(true);
        }
    }

    private void finishingShootDown(Field field, int y, int x) {
        y += shootData.getShootDown() + 1;
        Integer[] coordYX = new Integer[] {y, x};
        shoot(field, coordYX);
        shootData.setShootDown(shootData.getShootDown() + 1);
        shootData.setLastYX(coordYX);
        if (!checkIsCellAShip(field, coordYX)) {
            shootData.setDoNotShootDown(true);
        }
        if (shootData.getShootDown() > 1) {
            shootData.setDoNotShootLeft(true);
            shootData.setDoNotShootRight(true);
        }
    }

}
