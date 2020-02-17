package seaBattle.data;

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

    public boolean isShipInCell() {
        return cellShip != null;
    }

    public void setCellShip(Ship cellShip) {
        this.cellShip = cellShip;
    }

    public Ship getCellShip() {
        return cellShip;
    }
}

