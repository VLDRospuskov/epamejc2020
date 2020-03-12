package seabattle.java;

import lombok.Data;

@Data
public class ShootData {

    private boolean shootLeft;
    private boolean shootTop;
    private boolean shootRight;
    private boolean shootDown;
    private Integer[] startYX;

    public ShootData(Integer[] startYX) {
        this.startYX = startYX;
    }


}
