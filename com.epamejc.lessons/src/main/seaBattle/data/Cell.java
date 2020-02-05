package main.seaBattle.data;

public class Cell {

    private int cellIndex;
    private int xCoord;
    private char yCoord;
    private String cellStatus;

    public Cell(int cellIndex, int xCoord, char yCoord, String cellStatus) {
        this.cellIndex = cellIndex;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.cellStatus = cellStatus;
    }


}
