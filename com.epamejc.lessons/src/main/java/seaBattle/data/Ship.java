package seaBattle.data;

import java.util.Objects;

public class Ship {

    private String shipType;
    private int shipDecks;
    private int shipHP;
    private boolean isDestroyed;
    private String direction;
    private int xCoord;
    private int yCoord;

    public Ship(String shipType, int shipDecks) {
        this.shipType = shipType;
        this.shipDecks = shipDecks;
        this.shipHP = shipDecks;
        this.isDestroyed = false;
    }

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getShipDecks() {
        return shipDecks;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }


    public void hitShip() {
        if (this.shipHP > 0) {
            this.shipHP -= 1;
            updateShipCondition();
        }

    }

    public void updateShipCondition() {
        if (this.shipHP == 0) {
            this.isDestroyed = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return shipDecks == ship.shipDecks &&
                xCoord == ship.xCoord &&
                yCoord == ship.yCoord &&
                Objects.equals(direction, ship.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipDecks, direction, xCoord, yCoord);
    }
}
