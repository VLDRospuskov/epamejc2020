package homeworks.HW3_arrays.arrayGeneration;

import java.util.Scanner;

public class TwoDimensionalArray {
    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                System.out.println(SystemMessages.appStartMessage.getMessage());
                int linesQuantity = defineLinesQuantity(scan);
                if (!isExitNeeded) {
                    int rowsQuantity = defineRowsQuantity(scan);
                    if (!isExitNeeded) {
                        char[][] twoDimArray = generateArray(linesQuantity, rowsQuantity);
                        printCharArray(twoDimArray);
                    }
                }
            }
        } catch (Exception excp) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(SystemMessages.appFinishMessage.getMessage());
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
     * Method for validating input and initializing the number of array lines
     *
     * @param scan scanner object
     * @return number of lines
     */
    public int defineLinesQuantity(Scanner scan) {
        boolean linesInputExitTrigger = false;
        int linesQuantity = 0;
        while (!linesInputExitTrigger) {
            System.out.print(SystemMessages.inputLinesMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                linesQuantity = Integer.parseInt(inputString);
                if (linesQuantity == -1) {
                    isExitNeeded = true;
                    break;
                } else if (linesQuantity > 0 && linesQuantity <= 85) {
                    linesInputExitTrigger = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception arExc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return linesQuantity;
    }

    /**
     * Method for validating input and initializing the number of array lines
     *
     * @param scan scanner object
     * @return number of rows
     */
    public int defineRowsQuantity(Scanner scan) {
        boolean rowsInputExitTrigger = false;
        int rowsQuantity = 0;
        while (!rowsInputExitTrigger) {
            System.out.print(SystemMessages.inputRowsMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                rowsQuantity = Integer.parseInt(inputString);
                if (rowsQuantity == -1) {
                    isExitNeeded = true;
                    break;
                } else if (rowsQuantity > 0 && rowsQuantity <= 85) {
                    rowsInputExitTrigger = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return rowsQuantity;
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
     * Method for printing the generated array to the console
     *
     * @param twoDimArray generated array
     */
    private void printCharArray(char[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


