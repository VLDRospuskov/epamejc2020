package homeworks.java.arrays;

import lombok.*;

import java.util.Arrays;

@NoArgsConstructor
@EqualsAndHashCode
public class RandomCharArray {

    /**
     * Input must match following pattern: d_d, where d is an integer more than 0, _ is space. <br>
     * Example: 14 2
     */
    private String REGEX = "^[1-9]+ [1-9]+$";
    private int row, col;
    private char[][] arr = new char[][]{};

    public RandomCharArray(char[][] arr) {
        this.arr = arr;
        this.row = arr.length;
        this.col = arr[0].length;
    }

    public char[][] getArr() {

        return arr;

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] array : arr) {
            stringBuilder.append(Arrays.toString(array));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    /**
     * Generates an array in case of correct input
     *
     * @param input {@code String} input
     * @return {@code true} if array was successfully created and {@code false} otherwise
     */
    public boolean generateArr(String input) {

        boolean arrayCreated = false;

        if (setDimensions(input)) {
            fillArray();
            arrayCreated = true;
        }
        return arrayCreated;

    }

    /**
     * Builds a new {@code String} based on {@link homeworks.java.arrays.Strategy}
     * If the strategy is {@link homeworks.java.arrays.Strategy#A} outputs {@code String}
     * build of {@code chars} of every odd row and col of the array and
     * if the strategy is {@link homeworks.java.arrays.Strategy#B} outputs {@code String}
     * build of {@code chars} of every even row and col of the array.
     *
     * @param strategy Output strategy.
     */
    public String makeStringWithStrategy(Strategy strategy) {

        StringBuilder stringBuilder = new StringBuilder();
        if (arr.length == 0) {
            return "";
        }
        for (int i = strategy.ordinal(); i < row; i += 2) {
            for (int j = strategy.ordinal(); j < col; j += 2) {
                stringBuilder.append((arr[i][j]));
            }
        }
        return stringBuilder.toString();

    }

    /**
     * Sets the row and col values.
     *
     * @param input {@code String} user input
     * @return {@code true} if values set successfully and {@code false} otherwise
     */
    private boolean setDimensions(String input) {

        boolean dimensionsSet = false;
        if (input.length() != 0 && input.matches(REGEX)) {
            String[] dimensions = input.split(" ");
            row = Integer.valueOf(dimensions[0]);
            col = Integer.valueOf(dimensions[1]);
            dimensionsSet = true;
        }
        return dimensionsSet;

    }

    private void fillArray() {

        arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (char) (Math.random() * 26 + 97);
            }
        }

    }

}