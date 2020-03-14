package homeworks.java.seabattle.input;

import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.ship.DeckNumberCount;

public interface InputListener {

    boolean makeShip(DeckNumberCount decksNum, Orientation o, Coordinatepointer startCoordinate);

    void fillAutomatically();

    void exitGame();

    void attack(int x, int y);
}
