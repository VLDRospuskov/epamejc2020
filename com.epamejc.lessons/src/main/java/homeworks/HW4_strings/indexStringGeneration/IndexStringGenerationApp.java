package homeworks.HW4_strings.indexStringGeneration;

import java.util.Scanner;

public class IndexStringGenerationApp {

    private boolean isExitNeeded = false;


    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            String inputString = enterString(scan);
            IndexStringGeneration indexedString = new IndexStringGeneration();
            while (!isExitNeeded) {
                int indexOfChar = enterIndex(scan, inputString);
                if (!isExitNeeded) {
                    System.out.println("Entered string is: " + inputString);
                    indexedString.setResultString(indexedString.getResultString() +
                            indexedString.generateSubstring(inputString, indexOfChar));
                    System.out.println("Result string is: " + indexedString.getResultString() + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(IndexStringGenerationMessages.exitAppMessage.getValue());
        }
    }

    /**
     * Method for validating and initializing an input string
     *
     * @param scan scanner object
     * @return entered string
     */
    public String enterString(Scanner scan) {
        boolean isInputCorrect = false;
        String inputString = "";
        while (!isInputCorrect) {
            System.out.print(IndexStringGenerationMessages.enterStringMessage.getValue());
            inputString = scan.nextLine();
            try {
                if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(IndexStringGenerationMessages.enterStringError.getValue());
            }
        }
        return inputString;
    }

    /**
     * Method for validating and initializing a char index
     *
     * @param scan        scanner object
     * @param inputString entered string
     * @return entered char index
     */
    public int enterIndex(Scanner scan, String inputString) {
        boolean isInputCorrect = false;
        int indexOfChar = 0;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.print(IndexStringGenerationMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String enteredString = scan.nextLine();
            try {
                indexOfChar = Integer.parseInt(enteredString);
                if (indexOfChar == -1) {
                    isExitNeeded = true;
                    break;
                } else if (indexOfChar >= 0 && indexOfChar <= maxIndex) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(IndexStringGenerationMessages.enterIndexError.getValue());
            }
        }
        return indexOfChar;
    }
}
