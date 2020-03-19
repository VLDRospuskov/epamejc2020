package seabattle;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
@Getter
@AllArgsConstructor
class ShipPart {
    private Coordinates coordinates;
    private boolean hit = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipPart shipPart = (ShipPart) o;
        return Objects.equals(coordinates, shipPart.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
