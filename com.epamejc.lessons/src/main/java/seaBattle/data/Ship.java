package seaBattle.data;

public class Ship {

    private String shipType;
    private int shipDecks;
    private boolean isDestroyed;

    public Ship(String shipType, int shipDecks) {
        this.shipType = shipType;
        this.shipDecks = shipDecks;
        this.isDestroyed = false;
    }
}
