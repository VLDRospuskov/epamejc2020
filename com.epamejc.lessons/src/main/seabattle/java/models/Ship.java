package seabattle.java.models;

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
        isHorizontal = checkHorizontal();
        isPossibleToSetShip = checkPosition(field);
        isInitOk = false;
        isPressLeft = false;
        isPressTop = false;
        isPressRight = false;
        isPressBottom = false;

        if (isPossibleToSetShip) {
            setShip(field);
            setFlags();
            int status = -1;
            setBarrier(field, status);
            isInitOk = true;
        }
    }

    public void printBadCoordinates() {
        System.out.println("\nBad coordinates: " + Arrays.toString(startYX) + " " + Arrays.toString(endYX) + ". Try again.");
    }

    public void checkSunk(Field field) {
        if (isHorizontal && countHitCellsInHorizontal(field) == shipType) {
            isSunk = true;
        } else if (!isHorizontal && countHitCellsInVertical(field) == shipType) {
            isSunk = true;
        }
    }

    public void setDeadBarrier(Field field) {
        if (isSunk) {
            int status = -2;
            setBarrier(field, status);
        }
    }

    private int countHitCellsInHorizontal(Field field) {
        int countHitCells = 0;
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            if (field.getField().get(startYX[0]).get(i).isHit()) {
                countHitCells++;
            }
        }
        return countHitCells;
    }

    private int countHitCellsInVertical(Field field) {
        int countHitCells = 0;
        for (int i = startYX[0]; i <= endYX[0]; i++) {
            if (field.getField().get(i).get(startYX[1]).isHit()) {
                countHitCells++;
            }
        }
        return countHitCells;
    }

    private boolean checkPosition(Field field) {
        if (!startYX[0].equals(endYX[0]) && !startYX[1].equals(endYX[1])) {
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
        if (countFreeCells != countCells) {
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
        if (countFreeCells != countCells) {
            return 0;
        }
        return countFreeCells;
    }

    private boolean checkHorizontal() {
        return startYX[0].equals(endYX[0]);
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

    private void setBarrier(Field field, int status) {
        setBarrierLeft(field, status);
        setBarrierRight(field, status);
        setBarrierTop(field, status);
        setBarrierBottom(field, status);
        setBarrierCenter(field, status);
    }

    private void setBarrierLeft(Field field, int status) {
        if (isPressLeft && isPressTop) {
            setBarrierLeftTopCorner(field, status);
        } else if (isPressLeft && isPressBottom) {
            setBarrierLeftBottomCorner(field, status);
        } else if (!isPressTop && !isPressBottom && isPressLeft) {
            setBarrierLeftSide(field, status);
        }
    }

    private void setBarrierRight(Field field, int status) {
        if (isPressRight && isPressTop) {
            setBarrierRightTopCorner(field, status);
        } else if (isPressRight && isPressBottom) {
            setBarrierRightBottomCorner(field, status);
        } else if (!isPressTop && !isPressBottom && isPressRight) {
            setBarrierRightSide(field, status);
        }
    }

    private void setBarrierTop(Field field, int status) {
        if (!isPressLeft && !isPressRight && isPressTop) {
            setBarrierTopSide(field, status);
        }
    }

    private void setBarrierBottom(Field field, int status) {
        if (!isPressLeft && !isPressRight && isPressBottom) {
            setBarrierBottomSide(field, status);
        }
    }

    private void setBarrierCenter(Field field, int status) {
        if (!isPressLeft && !isPressTop && !isPressRight && !isPressBottom) {
            setBarrierNoneSide(field, status);
        }
    }

    private void setBarrierLeftTopCorner(Field field, int status) {
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
        for (int i = startYX[0]; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

    private void setBarrierLeftBottomCorner(Field field, int status) {
        for (int i = startYX[1]; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

    private void setBarrierLeftSide(Field field, int status) {
        for (int i = startYX[1]; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

    private void setBarrierRightTopCorner(Field field, int status) {
        for (int i = startYX[0]; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
        }
        for (int i = startYX[1] - 1; i <= endYX[1]; i++) {
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
    }

    private void setBarrierRightBottomCorner(Field field, int status) {
        for (int i = startYX[1]; i <= endYX[1]; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
        }
    }

    private void setBarrierRightSide(Field field, int status) {
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
        }
        for (int i = startYX[1] - 1; i <= endYX[1]; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
    }

    private void setBarrierTopSide(Field field, int status) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
        for (int i = startYX[0]; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

    private void setBarrierBottomSide(Field field, int status) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
        }
        for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

    private void setBarrierNoneSide(Field field, int status) {
        for (int i = startYX[1] - 1; i <= endYX[1] + 1; i++) {
            field.getField().get(startYX[0] - 1).get(i).setStatus(status);
            field.getField().get(endYX[0] + 1).get(i).setStatus(status);
        }
        for (int i = startYX[0] - 1; i <= endYX[0] + 1; i++) {
            field.getField().get(i).get(startYX[1] - 1).setStatus(status);
            field.getField().get(i).get(endYX[1] + 1).setStatus(status);
        }
    }

}
