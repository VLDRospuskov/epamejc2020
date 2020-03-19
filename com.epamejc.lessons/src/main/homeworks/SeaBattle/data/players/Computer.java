package homeworks.SeaBattle.data.players;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Computer extends Player {

    private String name = "Computer";

}
