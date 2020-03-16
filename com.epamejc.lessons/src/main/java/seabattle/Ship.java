package seabattle;

import java.util.List;

public class Ship {
    
    private Coordinate firstCoordinate;
    private Coordinate secondCoordinate;
    private List<Coordinate> shipParts;
    private int length;
    private int direction;
    
    public Ship(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
        this.length = calculateLength();
        this.direction = calculateDirection();
        this.shipParts = fillShipPartsList();
    }
    
    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }
    
    public void setFirstCoordinate(Coordinate firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }
    
    public Coordinate getSecondCoordinate() {
        return secondCoordinate;
    }
    
    public void setSecondCoordinate(Coordinate secondCoordinate) {
        this.secondCoordinate = secondCoordinate;
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getDirection() {
        return this.direction;
    }
    
    public int calculateLength() {
        return firstCoordinate.getX() == secondCoordinate.getX() ?
               Math.abs(firstCoordinate.getY() - secondCoordinate.getY()) :
               Math.abs(firstCoordinate.getX() - secondCoordinate.getX());
    }
    
    public int calculateDirection() {
        if (firstCoordinate.getY() == secondCoordinate.getY() && secondCoordinate.getX() == firstCoordinate.getX()) {
            return 0;
        }
        if (firstCoordinate.getX() == secondCoordinate.getX()) {
            if (firstCoordinate.getY() - secondCoordinate.getY() > 0) {
                return 1;
            } else {
                return 3;
            }
        } else {
            if (firstCoordinate.getX() - secondCoordinate.getX() < 0) {
                return 2;
            } else {
                return 4;
            }
        }
    }
    
    private List<Coordinate> fillShipPartsList() {
        
        switch (selectStrategy()) {
            case "vertically":
                break;
            case "horizontally":
                break;
        }
        
        return null;
    }
    
    private String selectStrategy() {
        return null;
    }
    
}
