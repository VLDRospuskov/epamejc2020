package seaBattle.data;

public class Cell {

    private int cellIndex;
    private int xCoord;
    private int yCoord;
    private String cellStatus;
    private boolean isOccupied;

    public Cell(int cellIndex, int xCoord, int yCoord, String cellStatus) {
        this.cellIndex = cellIndex;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.cellStatus = cellStatus;
        this.isOccupied = false;
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
}
