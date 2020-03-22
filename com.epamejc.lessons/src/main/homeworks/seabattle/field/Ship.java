package main.homeworks.seabattle.field;

import main.homeworks.seabattle.player.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ship {

    private int length = 0;
    /**
     * direction equals 0 for horizontal placement, equals one for vertical placement;
     */
    private int direction = -1;
    private Character locX = '-';
    private int locY = -1;

    public int hitPoints;

    private int ShipId;

    private Player owner;

    public Ship(int length, int direction, Character locX, int locY) {
        if (length < 1 || (direction < 0 && length > 1) || locX < 1 || locY < 1) {
            throw new IllegalArgumentException("Check arguments");
        }
        this.length = length;
        if (length == 1) {
            this.direction = 0;
        } else {
            this.direction = direction;
        }
        this.locX = locX;
        this.locY = locY;
        this.hitPoints = length;
    }

    public void handleGetHit() {
        if (hitPoints >= 1) {
            hitPoints--;
        }
        if (hitPoints == 0) {
            System.out.println("Ship is destroyed.");
            owner.shipDestroyed(this);
        }
    }
}
