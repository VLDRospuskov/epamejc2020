package main.seaBattle.data;

public class Ship {

    private String shipType;
    private int shipDecks;
    private boolean isDestroyed;
    private boolean isPlayersShip;

    public Ship(String shipType, int shipDecks, boolean isDestroyed, boolean isPlayersShip) {
        this.shipType = shipType;
        this.shipDecks = shipDecks;
        this.isDestroyed = isDestroyed;
        this.isPlayersShip = isPlayersShip;
    }
}
