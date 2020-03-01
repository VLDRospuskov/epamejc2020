package seabattle.java;

import lombok.Data;

@Data
public class Cell {

    /**
     * 0 - empty, 1 - ship, -1 - barrier
     */
    private Integer status;
    private boolean isHit;

    public Cell() {
        this.status = 0;
    }

    @Override
    public String toString() {
        String output = "";
        if (!isHit) {
            if (status.equals(0)) {
                output = "_";
            } else if (status.equals(1)) {
                output = "#";
            } else if (status.equals(-1)) {
                output = "-";
            }
        } else {
            if (status.equals(0)) {
                output = "*";
            } else {
                output = "X";
            }
        }
        return output;
    }
}
