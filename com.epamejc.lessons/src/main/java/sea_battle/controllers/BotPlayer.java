package sea_battle.controllers;

import sea_battle.utils.RandomGenerator;

import java.util.ArrayList;

public class BotPlayer extends Player {

    private boolean isPrevHit;
    private ArrayList<int[]> nextHits;
    private ArrayList<int[]> madeShots;


    public BotPlayer(String title) {
        super(title);
        this.isPrevHit = false;
        this.madeShots = new ArrayList<>();
    }

    @Override
    public boolean shot(Player opponent) {
        boolean result;

        Coordinates coords = getCoords();

        result = super.makeShot(opponent, coords.getX(), coords.getY());
        return result;
    }

    private Coordinates getCoords() {
        Coordinates coord;
        boolean isNotUnique = true;
        int[] coords = new int[0];

        while (isNotUnique) {
            coords = RandomGenerator.generateCoordinates();

            if (madeShots.size() > 0) {
                for (int[] shot : madeShots) {
                    isNotUnique = true;
                    if (coords[0] == shot[0] && coords[1] == shot[1]) {
                        break;
                    }
                    isNotUnique = false;
                }
            }
        }

        return new Coordinates(coords[1], coords[0], false);
    }
}
