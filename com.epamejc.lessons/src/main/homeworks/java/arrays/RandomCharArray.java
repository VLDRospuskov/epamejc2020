package homeworks.java.arrays;

import lombok.*;

/**
 * The {@code RandomCharArray class} represents a random generated two dimensional {@code char} array.
 *
 * @author Vladimir Ivanov
 */

@NoArgsConstructor
@EqualsAndHashCode
public class RandomCharArray {

    /**
     * stores REGEX to parse dimensions input
     */
    private String REGEX = "^\\d+ \\d+$";
    /**
     * stores dimensions of the array
     */
    private int row, col;
    /**
     * stores the array
     */
    private char[][] arr = new char[][]{};

    public RandomCharArray(char[][] arr) {
        this.arr = arr;
        this.row = arr.length;
        this.col = arr[0].length;
    }

    public char[][] getArr() {

        return arr;

    }

    /**
     * Generates an array in case of correct input
     *
     * @param input {@code String} input
     * @return {@code true} if array was successfully created and {@code false} otherwise
     */
    public boolean generateArr(String input) {

        boolean arrayCreated = false;

        if (setDimentions(input)) {
            fillArray();
            arrayCreated = true;
        }
        return arrayCreated;

    }

    /**
     * Prints an array to console
     */
    public void print() {

        if (arr.length != 0) {
            System.out.print("Array " + row + " x " + col + ": \n");
            for (char[] chars : arr) {
                for (char character : chars) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Array is empty!");
        }

    }

    /**
     * Prints a new {@code String} based on {@link homeworks.java.arrays.Strategy}
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
            return "Array is empty!";
        } else if (strategy == Strategy.A) {
            for (int i = 0; i < arr.length; i += 2) {
                for (int j = 0; j < arr[i].length; j += 2) {
                    stringBuilder.append(arr[i][j]);
                }
            }
        } else if (strategy == Strategy.B) {
            for (int i = 1; i < arr.length; i += 2) {
                for (int j = 1; j < arr[i].length; j += 2) {
                    stringBuilder.append(arr[i][j]);
                }
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
    private boolean setDimentions(String input) {

        boolean dimensionsSet = false;
        if (input.length() != 0 && input.matches(REGEX)) {
            String[] dimensions = input.split(" ");
            row = Integer.valueOf(dimensions[0]);
            col = Integer.valueOf(dimensions[1]);
            dimensionsSet = true;
        }
        return dimensionsSet;

    }

    /**
     * Fills the array with random chars.
     */
    private void fillArray() {

        arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (char) (Math.random() * 26 + 97);
            }
        }

    }

}
