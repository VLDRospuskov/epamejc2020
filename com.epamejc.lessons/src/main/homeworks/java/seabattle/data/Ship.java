package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;
import lombok.Getter;

@Getter
public class Ship {

    private Ships type;
    private int size;
    private int hitPoints;
    private Cell startPoint;
    private Cell alignment;

    public Ship(Ships type, int size) {

        this.type = type;
        this.size = size;
        hitPoints = size;

    }

    public void setStartPoint(Cell startPoint) {

        this.startPoint = startPoint;

    }

    public void setAlignment(Cell alignment) {

        this.alignment = alignment;

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
