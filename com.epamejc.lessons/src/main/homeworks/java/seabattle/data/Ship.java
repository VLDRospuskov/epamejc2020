package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.Ships;

public class Ship {

    private Ships type;
    private int hitPoints;
    private Cell startPoint;
    private Cell alignment;

    public Ship(Ships type) {

        this.type = type;
        hitPoints = type.getLength();

    }

    public void setStartPoint(Cell startPoint) {
        this.startPoint = startPoint;
    }

    public void setAlignment(Cell alignment) {
        this.alignment = alignment;
    }

    public Ships getType() {
        return type;
    }

    public Cell getStartPoint() {
        return startPoint;
    }

    public Cell getAlignment() {
        return alignment;
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
