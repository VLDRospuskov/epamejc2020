package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.Actor;
import homeworks.java.seabattle.enums.GameStats;
import lombok.Data;

@Data
public class Player {

    private Actor actor;
    private String name;
    private Field field;

    public Player (Actor actor) {

        this.actor = actor;
        this.field = new Field();
        this.name = actor.getName();

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void arrangeShips() {

        field.arrangeShipsRandom();

    }

    public GameStats shoot(Cell cell) {

        return field.hit(cell);

    }

}
