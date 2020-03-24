package seabattle.java.models;

import lombok.Data;

@Data
public class Cell {

    /**
     * Status: 0 - empty cell, 1 - ship, -1 - init barrier, -2 sunk barrier
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
            if (status.equals(0) || status.equals(-1) || status.equals(-2)) {
                output = "_";
            } else if (status.equals(1)) {
                output = "#";
            }
        } else {
            if (status.equals(0) || status.equals(-1) || status.equals(-2)) {
                output = "*";
            } else {
                output = "X";
            }
        }
        return output;
    }

    public String printHidden() {
        String output = "";
        if (!isHit) {
            output = "_";
        } else {
            if (status.equals(0) || status.equals(-1) || status.equals(-2)) {
                output = "*";
            } else {
                output = "X";
            }
        }
        return output;
    }

}
