package seabattle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
//todo везде убрать паблик классы
public class ShipPart {

    private Coordinates coordinates;
    private Boolean hit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipPart shipPart = (ShipPart) o;
        return hit == shipPart.hit &&
                Objects.equals(coordinates, shipPart.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, hit);
    }

}
