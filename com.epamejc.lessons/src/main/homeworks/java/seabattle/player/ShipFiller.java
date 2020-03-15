package homeworks.java.seabattle.player;

import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.Field;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.input.Orientation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipFiller {

    private BasePlayer player;

    public ShipFiller(BasePlayer player) {

        this.player = player;
    }

    public void fill() {

        Random rand = new Random();
        List<Coordinatepointer> fieldPoints = new ArrayList<>();

        for(int x = 0; x < Field.WIDTH; x++) {
            for (int y = 0; y < Field.HEIGHT; y++) {
                fieldPoints.add(new Coordinatepointer(x, y));
            }
        }

        for (int i = 1; i < DeckNumberCount.values().length; i++) {

            DeckNumberCount dc = DeckNumberCount.valueOf(i);

            while (player.getFreePlace(dc) > 0) {

                Orientation orient = rand.nextInt(2) > 0 ? Orientation.HORIZONTAL
                        : Orientation.VERTICAL;

                do {
                    int index = rand.nextInt(fieldPoints.size());

                    Coordinatepointer coord = fieldPoints.get(index);

                    if (player.isPosibleToPlace(orient, dc, coord)) {
                        player.addShip(orient, dc, coord);

                        break;
                    }
                }
                while (!fieldPoints.isEmpty());
            }
        }
    }

}
