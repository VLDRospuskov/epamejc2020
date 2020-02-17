package homeworks.java.pyramidBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The {@code Pyramid class} represents a pyramid, stored as a two dimension array of integers.
 *
 * @author Vladimir Ivanov
 */
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Pyramid {

    private int[][] pyramid;
    private int row, col;

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int[] row : pyramid) {
            for (int col : row) {
                if (col == 1) {
                    stringBuilder.append('*');
                } else {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

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
            throw new CannotBuildPyramidException("Base can't be less than 1");
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
