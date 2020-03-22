package seabattle.states;

import seabattle.Coordinate;

public class Assist {
    
    private Coordinate assistPoint;
    
    public Assist(Coordinate assistPoint) {
        this.assistPoint = assistPoint;
    }
    
    public Coordinate getAssistPoint() {
        return assistPoint;
    }
    
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + assistPoint.getX();
        result = prime * result + assistPoint.getY();
        return result;
    }
    
    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Assist assist = (Assist) o;
        return getAssistPoint().equals(assist.getAssistPoint());
    }
    
}
