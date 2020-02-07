package homeworks.HW3_arrays.arrayGeneration;

import java.util.Scanner;

public class TwoDimArrayApplication {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                System.out.println(SystemMessages.appStartMessage.getMessage());
                int linesQuantity = defineLinesQuantity(scan);
                if (!isExitNeeded) {
                    int rowsQuantity = defineRowsQuantity(scan);
                    TwoDimensionalArray array = new TwoDimensionalArray();
                    char[][] twoDimArray = array.generateArray(linesQuantity, rowsQuantity);
                    array.printCharArray(twoDimArray);
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(SystemMessages.appFinishMessage.getMessage());
        }
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
                if (rowsQuantity > 0 && rowsQuantity <= 85) {
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
}
