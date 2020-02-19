package seaBattle.data;

import java.util.Objects;

public class Cell {

    private int cellIndex;
    private int xCoord;
    private int yCoord;
    private String cellStatus;
    private Ship cellShip;

    public Cell(int cellIndex, int xCoord, int yCoord, String cellStatus) {
        this.cellIndex = cellIndex;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.cellStatus = cellStatus;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public String getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(String cellStatus) {
        this.cellStatus = cellStatus;
    }

    public boolean isShipInCell() {
        return cellShip != null;
    }

    public void removeShip() {
        this.cellShip = null;
    }

    public void setCellShip(Ship cellShip) {
        this.cellShip = cellShip;
    }

    public Ship getCellShip() {
        return cellShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return cellIndex == cell.cellIndex &&
                xCoord == cell.xCoord &&
                yCoord == cell.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellIndex, xCoord, yCoord);
    }
}

