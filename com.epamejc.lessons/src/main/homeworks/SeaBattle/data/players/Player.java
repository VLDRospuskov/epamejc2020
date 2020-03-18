package homeworks.SeaBattle.data.players;

import homeworks.SeaBattle.data.Ship;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class Player {

    private String name;
    private char[][] field;
    private ArrayList<Ship> ships;
    private boolean isActive;
    private boolean isManualShipGeneration;
    private int score;

    public Player() {
        this.field = new char[10][10];
        this.ships = new ArrayList<>();
        this.score = 0;
    }

}
