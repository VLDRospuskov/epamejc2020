package Seabattle;

public class ShipParameters {
    private CellCoordinates startCell;
    private int size;
    private Direction direction;

    public ShipParameters() {}

    public ShipParameters(CellCoordinates startCell, int size, Direction direction) {
        this.startCell = startCell;
        this.size = size;
        this.direction = direction;
    }

    public CellCoordinates getShipAreaTopLeft() {
        switch (direction) {
            case DOWN:
            case RIGHT:
            default:
                return startCell.subtract((char) 1, 1);
            case UP:
                return startCell.subtract((char) 1, size);
            case LEFT:
                return startCell.subtract((char) size, 1);
        }
    }

    public CellCoordinates getShipAreaBottomRight() {
        switch (direction) {
            case DOWN:
                return startCell.add((char) 1, size);
            case RIGHT:
                return startCell.add((char) size, 1);
            case UP:
            case LEFT:
            default:
                return startCell.add((char) 1, 1);
        }
    }

    public CellCoordinates getStartCell() {
        return startCell;
    }

    public void setStartCell(CellCoordinates startCell) {
        this.startCell = startCell;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
