package homeworks.seabatle.model.players;

import homeworks.seabatle.model.board.Field;
import lombok.Data;

@Data
public abstract class Player {
    private Field field;
    private String name;
}
