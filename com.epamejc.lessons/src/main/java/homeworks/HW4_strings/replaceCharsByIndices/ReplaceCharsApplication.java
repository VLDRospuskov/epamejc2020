package homeworks.HW4_strings.replaceCharsByIndices;

import java.util.Scanner;

public class ReplaceCharsApplication {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        ReplaceCharsByIndices replaceChars = new ReplaceCharsByIndices();
        try {
            String inputString = enterString(scan);
            while (!isExitNeeded) {
                int[] indexArray = enterIndexes(scan, inputString, replaceChars);
                if (!isExitNeeded) {
                    System.out.println("Entered string is: " + inputString);
                    System.out.println("Result string is: " +
                            replaceChars.exchangeStringChars(inputString, indexArray[0], indexArray[1]) + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(ReplaceCharsByIndicesMessages.exitAppMessage.getValue());
        }
    }

    /**
     * Method for initializing an input string
     *
     * @param scan scanner object
     * @return entered string
     */
    public String enterString(Scanner scan) {
        String inputString = "";
        boolean isInputCorrect = false;

        while (!isInputCorrect) {
            System.out.print(ReplaceCharsByIndicesMessages.enterStringMessage.getValue());
            inputString = scan.nextLine();
            try {
                if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(ReplaceCharsByIndicesMessages.wrongStringArgument.getValue());
            }
        }
        return inputString;
    }

    /**
     * Method for entering indexes
     *
     * @param scan         scanner object
     * @param inputString  entered string
     * @param replaceChars class with logic object
     * @return array with array with indices
     */
    public int[] enterIndexes(Scanner scan, String inputString, ReplaceCharsByIndices replaceChars) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.println("Entered string is: " + inputString);
            System.out.print(ReplaceCharsByIndicesMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String enteredString = scan.nextLine();

            try {
                if (enteredString.equals("-1")) {
                    isExitNeeded = true;
                    break;
                } else {
                    isInputCorrect = replaceChars.parseIndexes(enteredString, inputString);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ReplaceCharsByIndicesMessages.wrongNumberArgument.getValue());
            }
        }
        return replaceChars.getIndexes();
    }
}
