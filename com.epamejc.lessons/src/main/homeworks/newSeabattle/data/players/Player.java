package homeworks.newSeabattle.data.players;

import homeworks.newSeabattle.data.Ship;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class Player {

    private String name;
    private char[][] field;
    private ArrayList<Ship> ships;
    private int score = 0;

}
