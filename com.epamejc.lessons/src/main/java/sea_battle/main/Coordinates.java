package sea_battle.main;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Coordinates implements Comparable<Coordinates> {

    private int x;
    private int y;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Coordinates o) {
        return (x - o.x) + (y - o.y);
    }
}
