package main.homeworks.Homework3.PyramidBuilder;

import java.util.Arrays;
import java.util.Objects;

public class Pyramid {

    private int[][] pyramid;
    private int row, col;

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pyramid[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public int[][] getPyramid() {
        return pyramid;
    }

    public Pyramid(int base) {
        this.row = base;
        this.col = base * 2 - 1;
        buildPyramid();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pyramid that = (Pyramid) o;
        return Arrays.equals(pyramid, that.pyramid);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(pyramid);
        return result;
    }

    private void buildPyramid() {
        pyramid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = row - (i + 1); j < row + i; j += 2) {
                pyramid[i][j] = 1;
            }
        }
    }
}
