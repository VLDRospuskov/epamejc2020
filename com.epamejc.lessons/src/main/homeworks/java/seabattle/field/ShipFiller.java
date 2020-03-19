package homeworks.java.seabattle.field;

import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.input.Orientation;
import homeworks.java.seabattle.player.BasePlayer;

import java.util.ArrayList;
import java.util.Random;

public class ShipFiller {

    private BasePlayer player;
    private int shipCounter = 0;
    private int attemptsCounter = 0;
    private Random rand = new Random();

    public ShipFiller(BasePlayer player) {
        this.player = player;
    }

    public void fill() {
        for (int i = 1; i < DeckNumberCount.decksOnField.length + 1; i++) {
            DeckNumberCount dc = DeckNumberCount.valueOf(i);

            while (player.getFreePlace(dc) > 0 && attemptsCounter < 250) {
                Orientation orient = rand.nextInt(2) > 0 ? Orientation.HORIZONTAL
                        : Orientation.VERTICAL;
                while (shipCounter < 10 && attemptsCounter < 250) {
                    int x = rand.nextInt(10);
                    int y = rand.nextInt(10);

                    Coordinatepointer coord = new Coordinatepointer(x, y);

                    if (player.isPosibleToPlace(orient, dc, coord)) {
                        player.addShip(orient, dc, coord);
                        shipCounter++;
                        break;
                    } else {
                        attemptsCounter++;
                    }
                }
            }
        }
        if (!player.isFieldFilled()){
            attemptsCounter = 0;
            shipCounter = 0;
            player.ships = new ArrayList<>();
            player.field = new Field();
            player.init();
            player.fillAutomatically();
        }
    }

}
