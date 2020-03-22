package seabattle.players;

import java.io.IOException;

public interface Player {
    void setShips() throws IOException;
    void shoot();
}
