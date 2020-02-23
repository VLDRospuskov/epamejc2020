package sea_battle.controllers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Coordinates {

    private int x;
    private int y;
    private boolean isHit;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
