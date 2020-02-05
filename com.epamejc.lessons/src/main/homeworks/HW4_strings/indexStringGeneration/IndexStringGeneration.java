package main.homeworks.HW4_strings.indexStringGeneration;

import java.util.Scanner;

public class IndexStringGeneration {
    private boolean isExitNeeded = false;
    private String resultString = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            String inputString = enterString(scan);
            while (!isExitNeeded) {
                int indexOfChar = enterIndex(scan, inputString);
                if (!isExitNeeded) {
                    System.out.println("Entered string is: " + inputString);
                    generateString(inputString, indexOfChar);
                    System.out.println("Result string is: " + resultString + "\n");
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
     * @param scan scanner object
     * @return entered string
     */
    private String enterString(Scanner scan) {
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
     * @param scan scanner object
     * @param inputString entered string
     * @return entered char index
     */
    private int enterIndex(Scanner scan, String inputString) {
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

    /**
     * Method for generating a new string based on the original string,
     * the index of char, and the previous generation result
     * @param inputString original string
     * @param indexOfChar char index
     */
    private void generateString(String inputString, int indexOfChar) {
        StringBuilder charBox = new StringBuilder();
        charBox.append(inputString.charAt(indexOfChar));
        resultString = resultString + charBox.toString();
    }
}


