package homeworks.java.pyramidBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Pyramid {

    private int[][] pyramid;
    private int row, col;

    public void printPyramid() {
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

    public void buildPyramid(int base) {
        if (base < 1) {
            throw new CannotBuildPyramidException("Base can not be less than 1");
        }

        this.row = base;
        this.col = base * 2 - 1;

        pyramid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = row - (i + 1); j < row + i; j += 2) {
                pyramid[i][j] = 1;
            }
        }
    }
}
