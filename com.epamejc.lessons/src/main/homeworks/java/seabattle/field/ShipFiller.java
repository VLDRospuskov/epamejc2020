package homeworks.java.seabattle.field;

import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.input.Orientation;
import homeworks.java.seabattle.player.BasePlayer;

import java.util.Random;

public class ShipFiller {

    private BasePlayer player;
    private int shipCounter = 0;

    public ShipFiller(BasePlayer player) {

        this.player = player;
    }

    public void fill() {
        Random rand = new Random();

        for (int i = 1; i < DeckNumberCount.decksOnField.length + 1; i++) {
            DeckNumberCount dc = DeckNumberCount.valueOf(i);

            while (player.getFreePlace(dc) > 0) {
                Orientation orient = rand.nextInt(2) > 0 ? Orientation.HORIZONTAL
                        : Orientation.VERTICAL;
                while (shipCounter < 10) {
                    int x = rand.nextInt(10);
                    int y = rand.nextInt(10);

                    Coordinatepointer coord = new Coordinatepointer(x, y);

                    if (player.isPosibleToPlace(orient, dc, coord)) {
                        player.addShip(orient, dc, coord);
                        shipCounter++;
                        break;
                    }
                }
            }
        }
    }

}
