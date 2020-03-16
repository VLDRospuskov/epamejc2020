package seabattle;

import java.util.Objects;

public class Shots {
    
    Coordinate coordinate;
    
    public Shots(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    public Coordinate getCoordinate() {
        return coordinate;
    }
    
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    @Override public int hashCode() {
        return Objects.hash(getCoordinate());
    }
    
    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shots shots = (Shots) o;
        return getCoordinate().equals(shots.getCoordinate());
    }
    
}
