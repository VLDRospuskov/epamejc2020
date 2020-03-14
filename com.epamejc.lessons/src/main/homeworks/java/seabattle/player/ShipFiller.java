package homeworks.java.seabattle.player;

import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.input.Orientation;

import java.util.Random;

public class ShipFiller {

    private BasePlayer player;

    public ShipFiller(BasePlayer player) {

        this.player = player;
    }

    public void fill() {

        Random rand = new Random();

        for (int i = 1; i < DeckNumberCount.values().length; i++) {

            DeckNumberCount dc = DeckNumberCount.valueOf(i);

            while (player.getFreePlace(dc) > 0) {

                Orientation orient = rand.nextInt(2) > 0 ? Orientation.HORIZONTAL
                        : Orientation.VERTICAL;

                do {
                    int x = rand.nextInt(10);
                    int y = rand.nextInt(10);

                    Coordinatepointer coord = new Coordinatepointer(x, y);

                    if (player.isPosibleToPlace(orient, dc, coord)) {
                        player.addShip(orient, dc, coord);

                        break;
                    }
                }
                while (true);
            }
        }
    }

}
