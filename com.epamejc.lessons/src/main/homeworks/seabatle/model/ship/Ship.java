package homeworks.seabatle.model.ship;


import homeworks.seabatle.exception.ShipCreationRequestException;
import homeworks.seabatle.myenum.ShipType;
import lombok.Getter;

import java.util.Random;

@Getter
public class Ship {
    private int lives;
    private long id;
    private int[] coords;
    private ShipType type;

    public Ship() {
        id = new Random().nextLong();
    }

    public Ship(ShipType type, int lives) {
        id = new Random().nextLong();
        this.type = type;
        this.lives = lives;
    }

    public void decrementLives() {
        lives--;
    }

    /**
     * method validate coordinates
     *
     * @param coords array of coordinates
     * @throws ShipCreationRequestException if data is incorrect
     */
    public void setCoords(int[] coords) throws ShipCreationRequestException {
        if (coords.length == lives) {
            this.coords = coords;
        } else throw new ShipCreationRequestException(" requested dimension is invalid");
    }
}
