package homeworks.java.seabattle.field;

import java.util.Objects;

public class Coordinatepointer {

    public int x;
    public int y;

    public Coordinatepointer() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinatepointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinatepointer that = (Coordinatepointer) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
