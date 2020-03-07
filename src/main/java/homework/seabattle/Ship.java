package homework.seabattle;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Data
public abstract class Ship {

    public enum Type {
        VERTICAL,
        HORIZONTAL;
    }

    protected final int length;
    protected List<Coordinate> coordinates = new ArrayList<>();
    protected Set<Coordinate> areaCoordinates = new HashSet<>();

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
            calculateArea();
        }
    }

    public boolean isValid() {
        return !coordinates.isEmpty();
    }

    public boolean contains(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            return true;
        }
        return false;
    }

    public boolean occupies(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            return true;
        }
        if (areaCoordinates.contains(coordinate)) {
            return true;
        }
        return false;
    }

    protected abstract void calculateAllCoordinates(Coordinate startCoordinate);

    protected abstract void calculateArea();

}
