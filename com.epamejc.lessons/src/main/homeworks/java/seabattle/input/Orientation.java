package homeworks.java.seabattle.input;

import homeworks.java.seabattle.field.Coordinatepointer;

public enum  Orientation {
    HORIZONTAL(0),
    VERTICAL(1),
    NONE(-1),
    DEFAULT(0);

    private final int value;

    Orientation(int value){
        this.value = value;
    }

    public Coordinatepointer getDirection(){
        return value > 0 ? new Coordinatepointer(0, 1) : new Coordinatepointer(1, 0);
    }

}
