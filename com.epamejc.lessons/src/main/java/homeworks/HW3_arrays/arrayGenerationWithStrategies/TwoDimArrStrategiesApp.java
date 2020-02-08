package homeworks.HW3_arrays.arrayGenerationWithStrategies;

import homeworks.HW3_arrays.arrayGeneration.SystemMessages;

import java.util.Scanner;

public class TwoDimArrStrategiesApp {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                System.out.println(SystemMessages.appStartMessage.getMessage());
                int linesNumber = defineLinesQuantity(scan);
                if (!isExitNeeded) {
                    int rowsNumber = defineRowsQuantity(scan);
                    int strategyNumber = defineStrategy(scan);
                    TwoDimensionalArrayStrategies arrayStrategies = new TwoDimensionalArrayStrategies();
                    char[][] twoDimArray = arrayStrategies.generateArray(linesNumber, rowsNumber);
                    arrayStrategies.printCharArray(twoDimArray);
                    System.out.println("Generated string is: " +
                            arrayStrategies.processArrayWithStrategy(twoDimArray, strategyNumber) + "\n");
                }
            }
        } catch (Exception Ex) {
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
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return linesQuantity;
    }

    /**
     * Method for validating input and initializing the number of array rows
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
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return rowsQuantity;
    }

    /**
     * Method for validating input and initializing the strategy number
     *
     * @param scan scanner object
     * @return number of strategy
     */
    public int defineStrategy(Scanner scan) {
        boolean isCorrectStrategyInput = false;
        int strategyNumber = 0;
        while (!isCorrectStrategyInput) {
            System.out.print(SystemMessages.inputStrategyMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                strategyNumber = Integer.parseInt(inputString);
                if (strategyNumber == 1 || strategyNumber == 2) {
                    isCorrectStrategyInput = true;
                } else {
                    System.out.println(SystemMessages.strategyErrorMessage.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(SystemMessages.strategyErrorMessage.getMessage());
            }
        }
        return strategyNumber;
    }
}
