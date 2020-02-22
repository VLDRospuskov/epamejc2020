package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.Ships;

public class Ship {

    private Ships type;
    private int hitPoints;

    public Ship(Ships type, int hitPoints) {

        this.type = type;
        this.hitPoints = hitPoints;

    }

    public Ships getType() {
        return type;
    }

    public boolean hit() {

        boolean killed = false;
        hitPoints--;
        if (hitPoints == 0) {
            killed = true;
        }
        return killed;

    }
}
