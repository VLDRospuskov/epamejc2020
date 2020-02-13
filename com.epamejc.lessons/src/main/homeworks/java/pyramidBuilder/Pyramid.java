package homeworks.java.pyramidBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The {@code Pyramid class} represents a pyramid. The pyramid stores as two dimension array of integers.
 *
 * @author Vladimir Ivanov
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Pyramid {

    /**
     * Field to store a pyramid
     */
    private int[][] pyramid;
    /**
     * Fields to store the dimensions of an array
     */
    private int row, col;

    /**
     * Prints a pyramid. Replaces {@code 1} with {@code *} and {@code 0} with spaces.
     */
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

    /**
     * Builds a pyramid. The result looks like the following example:
     * <blockquote><pre>
     *
     *  0 0 0 0 1 0 0 0 0
     *  0 0 0 1 0 1 0 0 0
     *  0 0 1 0 1 0 1 0 0
     *  0 1 0 1 0 1 0 1 0
     *  1 0 1 0 1 0 1 0 1 {@code <}- parameter base is number of <b>1</b> in the bottom row
     *
     * </pre></blockquote>
     * <p>
     *
     * @param base This value means the size of the pyramid base.
     */
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
