package homeworks.HW3_arrays.arrayGeneration;

public class TwoDimensionalArray {

    public TwoDimensionalArray() {
    }

    /**
     * Method for printing the generated array to the console
     *
     * @param twoDimArray generated array
     */
    public void printCharArray(char[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method for generating a two-dimensional array with random characters
     *
     * @param linesQuantity number of lines
     * @param rowsQuantity  number of rows
     * @return generated array
     */
    public char[][] generateArray(int linesQuantity, int rowsQuantity) {
        char[][] twoDimArray = new char[linesQuantity][rowsQuantity];
        fillCharArray(twoDimArray);
        return twoDimArray;
    }

    /**
     * Method to fill an array with random characters
     *
     * @param twoDimArray filled array
     */
    private void fillCharArray(char[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = charGenerator();
            }
        }
    }

    /**
     * Method for generating random character within A-z
     *
     * @return generated random char
     */
    private char charGenerator() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }
}



