package seaBattle.data;

public class Cell {

    private int cellIndex;
    private int xCoord;
    private char yCoord;
    private String cellStatus;
    private boolean isOccupied;

    public Cell(int cellIndex, int xCoord, char yCoord, String cellStatus) {
        this.cellIndex = cellIndex;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.cellStatus = cellStatus;
        this.isOccupied = false;
    }

    public char getyCoord() {
        return yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public String getCellStatus() {
        return cellStatus;
    }
}
