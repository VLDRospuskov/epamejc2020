package sea_battle.controllers;

import sea_battle.utils.RandomGenerator;

import java.util.ArrayList;

public class BotPlayer extends Player {

    private boolean isPrevHit;
    private ArrayList<int[]> nextHits;

    public BotPlayer(String title) {
        super(title);
        this.isPrevHit = false;
    }

    @Override
    public boolean shot(Player opponent) {
     return true;
    }
}
