package seabattle.java;

import lombok.Data;

import java.util.Arrays;

@Data
public class Ship {

    private Integer shipType;
    private Integer[] startYX;
    private Integer[] endYX;
    private boolean isSunk;
    private boolean isHorizontal;
    private boolean isPressLeft;
    private boolean isPressTop;
    private boolean isPressRight;
    private boolean isPressBottom;
    private boolean isPossibleToSetShip;
    private boolean isInitOk;


    public Ship(Integer shipType, Integer[] startYX, Integer[] endYX, Field field) {
        this.shipType = shipType;
        this.startYX = startYX;
        this.endYX = endYX;
        this.isSunk = false;
        isHorizontal = checkHorizontality();
        isPossibleToSetShip = checkPosition(field);
        isInitOk = false;
        isPressLeft = false;
        isPressTop = false;
        isPressRight = false;
        isPressBottom = false;

        if (isPossibleToSetShip) {
            setShip(field);
            setFlags();
            setBarier(field);
            isInitOk = true;
        } else {
            System.out.println("\nBad coordinates: " + Arrays.toString(startYX) + " " + Arrays.toString(endYX) + ". Try again.");
        }

    }

    private boolean checkPosition(Field field) {
        if (startYX[0] != endYX[0] && startYX[1] != endYX[1]) {
            return false;
        }

        if (isHorizontal && countFreeCellsInHorizontal(field) == shipType) {
            return true;
        } else if (!isHorizontal && countFreeCellsInVertical(field) == shipType) {
            return true;
        }
        return false;
    }

    private int countFreeCellsInHorizontal(Field field) {
        int countFreeCells = 0;
        int countCells = 0;
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            int status = field.getField().get(startYX[0]).get(i).getStatus();
            if (status == 0) {
                countFreeCells++;
            }
            countCells++;
        }
        if(countFreeCells != countCells){
            return 0;
        }
        return countFreeCells;
    }

    private int countFreeCellsInVertical(Field field) {
        int countFreeCells = 0;
        int countCells = 0;
        for (int i = startYX[0]; i <= endYX[0]; i++) {
            int status = field.getField().get(i).get(startYX[1]).getStatus();
            if (status == 0) {
                countFreeCells++;
            }
            countCells++;
        }
        if(countFreeCells != countCells){
            return 0;
        }
        return countFreeCells;
    }

    private boolean checkHorizontality() {
        if (startYX[0].equals(endYX[0])) {
            return true;
        }
        return false;
    }

    private void setShip(Field field) {
        if (isHorizontal) {
            for (int i = startYX[1]; i <= endYX[1]; i++) {
                field.getField().get(startYX[0]).get(i).setStatus(1);
            }
        } else {
            for (int i = startYX[0]; i <= endYX[0]; i++) {
                field.getField().get(i).get(startYX[1]).setStatus(1);
            }
        }
    }

    private void setFlags() {
        if (startYX[0] < 1) {
            isPressTop = true;
        }

        if (startYX[1] < 1) {
            isPressLeft = true;
        }

        if (endYX[0] > 8) {
            isPressBottom = true;
        }

        if (endYX[1] > 8) {
            isPressRight = true;
        }

    }

    private int setBarrierLeftTopCorner(Field field) {
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0]; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierLeftBottomCorner(Field field) {
        for (int i = startYX[1]; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierLeftSide(Field field) {
        for (int i = startYX[1]; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
            field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierRightTopCorner(Field field) {
        for (int i = startYX[0]; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
        }
        for (int i = startYX[1] - 1; i <= endYX[1]; i++) {
            field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierRightBottomCorner(Field field) {
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierRightSide(Field field) {
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
        }
        for (int i = startYX[1] - 1; i <= endYX[1]; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
            field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierTopSide(Field field) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] + 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0]; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierBottomSide(Field field) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarrierNoneSide(Field field) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
            field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
        }
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
            field.getField().get(i).get(endYX[1] + 1).setStatus(-1);
        }
        return 0;
    }

    private int setBarier(Field field) {
        if (isPressLeft) {
            if (isPressTop) {
                return setBarrierLeftTopCorner(field);
            }
            if (isPressBottom) {
                return setBarrierLeftBottomCorner(field);
            }
            return setBarrierLeftSide(field);
        }

        if (isPressRight) {
            if (isPressTop) {
                return setBarrierRightTopCorner(field);
            }
            if (isPressBottom) {
                return setBarrierRightBottomCorner(field);
            }
            return setBarrierRightSide(field);

        }
        if (isPressTop) {
            return setBarrierTopSide(field);
        }
        if (isPressBottom) {
            return setBarrierBottomSide(field);
        }
        return setBarrierNoneSide(field);
    }
}
