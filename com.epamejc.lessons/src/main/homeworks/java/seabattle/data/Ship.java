package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;

public class Ship {

    private Ships type;
    private int length;
    private int hitPoints;
    private Cell startPoint;
    private Cell alignment;

    public Ship(Ships type, int length) {

        this.type = type;
        this.length = length;
        hitPoints = length;

    }

    public void setStartPoint(Cell startPoint) {

        this.startPoint = startPoint;

    }

    public void setAlignment(Cell alignment) {

        this.alignment = alignment;

    }

    public int getSize() {

        return length;

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

    public GameState hit() {

        GameState gameState = GameState.HIT;
        hitPoints--;
        if (hitPoints == 0) {
            gameState = GameState.DESTROYED;
        }
        return gameState;

    }

}
