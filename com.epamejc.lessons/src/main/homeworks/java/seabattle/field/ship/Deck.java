package homeworks.java.seabattle.field.ship;

import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.IFieldObject;

public class Deck implements IFieldObject {

    private Coordinatepointer position;
    private char aliveView, destroyedView;
    private boolean isAlive;

    public Deck(Coordinatepointer position, char aliveView, char destroyedView) {
        this.position = position;
        this.aliveView = aliveView;
        this.destroyedView = destroyedView;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Coordinatepointer getPosition() {
        return position;
    }

    @Override
    public char getView() {
        return isAlive ? aliveView : destroyedView;
    }

}
