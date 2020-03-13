package seabattle.java;

import lombok.Data;

@Data
public class ShootData {

    private boolean doNotShootLeft;
    private boolean doNotShootUp;
    private boolean doNotShootRight;
    private boolean doNotShootDown;
    private Integer[] startYX;

    public ShootData(Integer[] startYX) {
        this.startYX = startYX;
        doNotShootLeft = false;
        doNotShootUp = false;
        doNotShootRight = false;
        doNotShootDown = false;
        initFlags();
    }

    public void initFlags() {
        if (startYX[0] == 0) {
            doNotShootUp = true;
        }
        if (startYX[0] == 9) {
            doNotShootDown = true;
        }
        if (startYX[1] == 0) {
            doNotShootLeft = true;
        }
        if (startYX[1] == 9) {
            doNotShootRight = true;
        }
    }


}
