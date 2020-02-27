package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.ConsoleColors;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Cell {

    private final int coordX;
    private final int coordY;

    private boolean occupied;
    private boolean shootable;
    private Ship ship = null;

    public Cell(int coordX, int coordY) {

        this.coordX = coordX;
        this.coordY = coordY;
        occupied = false;
        shootable = true;

    }

    public String printCell(boolean visible) {

        return (occupied ? shootable ? visible ?
                ConsoleColors.GREEN.color() + "■" + ConsoleColors.RESET.color()
                : "∙"
                : ConsoleColors.RED.color() + "X" + ConsoleColors.RESET.color()
                : shootable ? "∙"
                : ConsoleColors.RED.color() + "○" + ConsoleColors.RESET.color());

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordX == cell.coordX &&
                coordY == cell.coordY;

    }

    @Override
    public int hashCode() {

        return Objects.hash(coordX, coordY);

    }

}
