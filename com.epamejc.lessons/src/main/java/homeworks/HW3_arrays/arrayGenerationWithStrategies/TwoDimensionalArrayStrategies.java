package homeworks.HW3_arrays.arrayGenerationWithStrategies;

public class TwoDimensionalArrayStrategies {

    public TwoDimensionalArrayStrategies() {
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
     * Method for calling the desired strategy to process array
     *
     * @param twoDimArray    generated array
     * @param strategyNumber number of strategy
     * @return created string
     */
    public String processArrayWithStrategy(char[][] twoDimArray, int strategyNumber) {
        if (strategyNumber == 1) {
            return createStringStrategyA(twoDimArray);
        } else {
            return createStringStrategyB(twoDimArray);
        }
    }

    /**
     * Method for printing an array to the console
     *
     * @param twoDimArray generated array
     */
    public void printCharArray(char[][] twoDimArray) {
        System.out.println("Generated array:");
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method for filling an array with random characters
     *
     * @param twoDimArray array
     */
    private void fillCharArray(char[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = charGenerator();
            }
        }
    }

    /**
     * Method for generating a random character within A-z
     *
     * @return generated char
     */
    private char charGenerator() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }

    /**
     * Method for generating a string with the strategy A and the generated array
     *
     * @param twoDimArray array
     * @return created string
     */
    private String createStringStrategyA(char[][] twoDimArray) {
        String resultString = "";
        for (int i = 0; i < twoDimArray.length; i += 2) {
            for (int j = 0; j < twoDimArray[0].length; j += 2) {
                resultString += String.valueOf(twoDimArray[i][j]);
            }
        }
        return resultString;
    }

    /**
     * Method for generating a string with the strategy B and the generated array
     *
     * @param twoDimArray array
     * @return created string
     */
    private String createStringStrategyB(char[][] twoDimArray) {
        String resultString = "";
        for (int i = 1; i < twoDimArray.length; i += 2) {
            for (int j = 1; j < twoDimArray[0].length; j += 2) {
                resultString += String.valueOf(twoDimArray[i][j]);
            }
        }
        return resultString;
    }
}


