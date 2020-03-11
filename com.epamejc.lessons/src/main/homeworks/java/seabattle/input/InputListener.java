package homeworks.java.seabattle.input;

import homeworks.java.seabattle.field.Coordinatepointer;

public interface InputListener {

    boolean makeShip(int decksNum, Orientation o, Coordinatepointer startCoordinate);

    void fillAutomatically();

    void exitGame();

    void attack(int x, int y);
}
