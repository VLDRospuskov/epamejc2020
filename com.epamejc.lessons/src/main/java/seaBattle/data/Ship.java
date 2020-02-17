package seaBattle.data;

public class Ship {

    private String shipType;
    private int shipDecks;
    private int shipHP;
    private boolean isDestroyed;
    private String direction;
    private int xCoord;
    private int yCoord;

    public int getShipCoordX() {
        return xCoord;
    }

    public void setShipCoordX(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getShipCoordY() {
        return yCoord;
    }

    public void setShipCoordY(int yCoord) {
        this.yCoord = yCoord;
    }

    public Ship(String shipType, int shipDecks) {
        this.shipType = shipType;
        this.shipDecks = shipDecks;
        this.shipHP = shipDecks;
        this.isDestroyed = false;
    }

    public int getShipDecks() {
        return shipDecks;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
