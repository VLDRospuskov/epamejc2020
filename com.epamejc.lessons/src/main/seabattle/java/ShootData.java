package seabattle.java;

import lombok.Data;

@Data
public class ShootData {

    private boolean doNotShootLeft;
    private boolean doNotShootUp;
    private boolean doNotShootRight;
    private boolean doNotShootDown;
    private final Integer[] START_YX;
    private Integer[] lastYX;
    private boolean isDone;
    private int shootCounter;
    private int shootLeft;
    private int shootUp;
    private int shootRight;
    private int shootDown;

    public ShootData(Integer[] startYX) {
        this.START_YX = startYX;
        this.lastYX = null;
        doNotShootLeft = false;
        doNotShootUp = false;
        doNotShootRight = false;
        doNotShootDown = false;
        initFlags();
        isDone = false;
        shootCounter = 0;
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
        if ((doNotShootLeft && doNotShootUp && doNotShootRight && doNotShootDown)
                || (shootLeft > 3 || shootUp > 3 || shootRight > 3 || shootDown > 3)) {
            isDone = true;
        }
     }


}
