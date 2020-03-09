package homework.seabattle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Ship {

    public enum Type {
        VERTICAL,
        HORIZONTAL
    }

    protected final int length;

    private List<Coordinate> coordinates = new ArrayList<>();

    private Set<Coordinate> areaCoordinates = new HashSet<>();

    public static Ship create(Type type, Coordinate startCoordinate, int length) {
        if (type == Type.HORIZONTAL) {
            return new HorizontalShip(startCoordinate, length);
        }

        if (type == Type.VERTICAL) {
            return new VerticalShip(startCoordinate, length);
        }

        throw new IllegalStateException("Unexpected value: " + type);
    }

    public static Ship createOneDeckShip(Coordinate coordinate) {
        return new HorizontalShip(coordinate, 1);
    }

    public Ship(Coordinate startCoordinate, int length) {
        this.length = length;
        calculateAllCoordinates(startCoordinate);

        if (isValid()) {
            areaCoordinates.addAll(calculateArea());
        }
    }

    protected abstract void calculateAllCoordinates(Coordinate startCoordinate);

    protected abstract Set<Coordinate> calculateArea();

    public int getLength() {
        return length;
    }

    public List<Coordinate> getCoordinates() {
        return new ArrayList<>(coordinates);
    }

    public Set<Coordinate> getAreaCoordinates() {
        return new HashSet<>(areaCoordinates);
    }

    public Coordinate getFirstCoordinate() {
        return coordinates.get(0);
    }

    public Coordinate getLastCoordinate() {
        return coordinates.get(coordinates.size() - 1);
    }

    public boolean addCoordinate(Coordinate coordinate) {
        return coordinates.add(coordinate);
    }

    public boolean removeCoordinate(Coordinate coordinate) {
        return coordinates.remove(coordinate);
    }

    public boolean isValid() {
        return !coordinates.isEmpty();
    }

    public boolean contains(Coordinate coordinate) {
        return coordinates.contains(coordinate);
    }

    public boolean occupies(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            return true;
        }
        return areaCoordinates.contains(coordinate);
    }

    public boolean intersects(Ship anotherShip) {
        for (Coordinate coordinate : coordinates) {
            if (anotherShip.occupies(coordinate)) {
                return true;
            }
        }
        return false;
    }
}
