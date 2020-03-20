package seabattle;

public class Shot {
    
    Coordinate coordinate;
    
    public Shot(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    public Coordinate getCoordinate() {
        return coordinate;
    }
    
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + coordinate.getX();
        result = prime * result + coordinate.getY();
        return result;
    }
    
    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shot shot = (Shot) o;
        return getCoordinate().equals(shot.getCoordinate());
    }
    
}
