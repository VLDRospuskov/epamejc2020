package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.ConsoleColors;

import java.util.Objects;

public class Cell {

    private final int coordX;
    private final int coordY;

    private boolean isOccupied;
    private boolean shootable;

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isShootable() {
        return shootable;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setShootable(boolean shootable) {
        this.shootable = shootable;
    }

    @Override
    public String toString() {

        return (isOccupied? shootable? ConsoleColors.GREEN.color() + "□" + ConsoleColors.RESET.color()
                : ConsoleColors.RED.color() + "X" + ConsoleColors.RESET.color()
                : shootable? "∙"
                : ConsoleColors.RED.color() + "•" + ConsoleColors.RESET.color());

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

    public Cell (int coordX, int coordY) {

        this.coordX = coordX;
        this.coordY = coordY;
        isOccupied = false;
        shootable = true;

    }

}
