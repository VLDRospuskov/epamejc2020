package seabattle;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
//to do написать икзс и хешкод
public class Coordinates {
    private int X;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return X == that.X &&
                Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    private int Y;
}
