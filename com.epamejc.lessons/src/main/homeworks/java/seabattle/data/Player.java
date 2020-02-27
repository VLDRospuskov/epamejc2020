package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameStats;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {

    int moves;
    private String name;
    private Field field;
    private boolean visible;

    public Player() {

        this.moves = 0;
        this.field = new Field();
        this.visible = false;

    }

    public void arrangeShips() {

        field.arrangeShipsRandom();

    }

    public abstract GameStats shoot(Player player);

}
