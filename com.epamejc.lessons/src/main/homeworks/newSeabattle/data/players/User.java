package homeworks.newSeabattle.data.players;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User extends Player {

    private String name;
    private boolean isManualShipGeneration;

}
