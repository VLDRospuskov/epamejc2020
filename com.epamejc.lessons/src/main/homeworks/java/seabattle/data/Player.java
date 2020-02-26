package homeworks.java.seabattle.data;

import lombok.Getter;
import lombok.Setter;

import static homeworks.java.seabattle.data.Field.deckSize;

@Getter
@Setter
public abstract class Player {

    private String name;
    private Field field;
    private boolean visible;

    public Player() {

        this.name = "Default";
        this.field = new Field();
        this.visible = false;

    }



    public void arrangeShips() {

        field.arrangeShipsRandom();

    }

    public abstract Cell shoot();

}
