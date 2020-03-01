package seabattle.java;

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


    public Ship(Integer shipType, Integer[] startYX, Integer[] endYX, Field field) {
        this.shipType = shipType;
        this.startYX = startYX;
        this.endYX = endYX;
        this.isSunk = false;
        this.isHorizontal = false;
        this.isPressLeft = false;
        this.isPressTop = false;
        this.isPressRight = false;
        this.isPressBottom = false;
//        field.get(startCoordinate[0]).get(startCoordinate[1]).setStatus(1);
//        field.get(1).get(1).setStatus(1);
        setShip(field);
        setFlags();
        setBarier(field);
    }

    private void setShip(Field field) {
        if (startYX[0].equals(endYX[0])) {
            for (int i = startYX[1]; i <= endYX[1]; i++) {
                field.getField().get(startYX[0]).get(i).setStatus(1);
                isHorizontal = true;
            }
        } else if (startYX[1].equals(endYX[1])) {
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
        System.out.println("Left: " + isPressLeft + ", Top: " + isPressTop + ", Right: " + isPressRight + ", Bottom: " + isPressBottom);
        System.out.println("Horizontal: " + isHorizontal);

    }

    private void setBarier(Field field) {
//        if(isHorizontal) {
        if (isPressLeft && isPressTop) {
            for (int i = startYX[1]; i <= endYX[1]; i++) {
                field.getField().get(startYX[0] + 1).get(i).setStatus(-1);
            }
            field.getField().get(startYX[0]).get(endYX[1] + 1).setStatus(-1);
            field.getField().get(startYX[0] + 1).get(endYX[1] + 1).setStatus(-1);
        }

        if (isPressRight && isPressTop) {
            for (int i = startYX[0]; i <= endYX[0]; i++) {
                field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
            }

            for (int i = startYX[1] - 1; i <= endYX[1]; i++) {
                field.getField().get(endYX[0] + 1).get(i).setStatus(-1);
            }

//            field.getField().get(startXY[0]).get(startXY[1] - 1).setStatus(-1);
//            field.getField().get(startXY[0] + 1).get(startXY[1] - 1).setStatus(-1);
        }

        if (isPressRight && isPressBottom) {
            for (int i = startYX[1]; i <= endYX[1]; i++) {
                field.getField().get(startYX[0] - 1).get(i).setStatus(-1);
            }
            for (int i = startYX[0] - 1; i <= endYX[0]; i++) {
                field.getField().get(i).get(startYX[1] - 1).setStatus(-1);
            }
        }
//        }

    }
}
