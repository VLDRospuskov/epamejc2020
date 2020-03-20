package seabattle.java.models;

import lombok.Data;
import static seabattle.java.Utils.*;

@Data
public class ShootData {

    private Field field;
    private boolean doNotShootLeft;
    private boolean doNotShootUp;
    private boolean doNotShootRight;
    private boolean doNotShootDown;
    private final Integer[] START_YX;
    private Integer[] lastYX;
    private boolean isDone;
    private int shootLeft;
    private int shootUp;
    private int shootRight;
    private int shootDown;

    public ShootData(Field field, Integer[] startYX) {
        this.field = field;
        this.START_YX = startYX;
        this.lastYX = null;
        doNotShootLeft = false;
        doNotShootUp = false;
        doNotShootRight = false;
        doNotShootDown = false;
        initFlags();
        isDone = false;
        shootLeft = 0;
        shootUp = 0;
        shootRight = 0;
        shootDown = 0;
    }

    public void initFlags() {
        if (START_YX[0] == 0) {
            doNotShootUp = true;
        }
        if (START_YX[0] == 9) {
            doNotShootDown = true;
        }
        if (START_YX[1] == 0) {
            doNotShootLeft = true;
        }
        if (START_YX[1] == 9) {
            doNotShootRight = true;
        }
    }

    public void checkFlags() {
        checkBorders();
        checkDone();
        checkHit();
    }

    private void checkBorders() {
        if (START_YX[1] - (shootLeft + 1) < 0) {
            doNotShootLeft = true;
        }
        if (START_YX[0] - (shootUp + 1) < 0) {
            doNotShootUp = true;
        }
        if (START_YX[1] + (shootRight + 1) > 9) {
            doNotShootRight = true;
        }
        if (START_YX[0] + (shootDown + 1) > 9) {
            doNotShootDown = true;
        }
    }

    private void checkDone() {
        if (doNotShootLeft && doNotShootUp && doNotShootRight && doNotShootDown) {
            isDone = true;
        }
        if (shootLeft > 3 || shootUp > 3 || shootRight > 3 || shootDown > 3) {
            isDone = true;
        }
    }

    private void checkHit() {
        checkLeftHit();
        checkUpHit();
        checkRightHit();
        checkDownHit();
    }

    private void checkLeftHit() {
        int y = START_YX[0];
        int x = START_YX[1] - (shootLeft + 1);
        Integer[] coordYX = {y, x};
        if (x >= 0 && checkIsCellHit(field, coordYX)) {
            doNotShootLeft = true;
        }
    }

    private void checkUpHit() {
        int y = START_YX[0] - (shootUp + 1);
        int x = START_YX[1];
        Integer[] coordYX = {y, x};
        if (y >= 0 && checkIsCellHit(field, coordYX)) {
            doNotShootUp = true;
        }
    }

    private void checkRightHit() {
        int y = START_YX[0];
        int x = START_YX[1] + (shootRight + 1);
        Integer[] coordYX = {y, x};
        if (x <= 9 && checkIsCellHit(field, coordYX)) {
            doNotShootRight = true;
        }
    }

    private void checkDownHit() {
        int y = START_YX[0] + (shootDown + 1);
        int x = START_YX[1];
        Integer[] coordYX = {y, x};
        if (y <= 9 && checkIsCellHit(field, coordYX)) {
            doNotShootDown = true;
        }
    }

}
