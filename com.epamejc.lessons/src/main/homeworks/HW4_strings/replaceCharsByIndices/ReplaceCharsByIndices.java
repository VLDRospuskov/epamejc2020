package main.homeworks.HW4_strings.replaceCharsByIndices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceCharsByIndices {

    private boolean isExitNeeded = false;
    private String inputString = "";
    private int firstIndex = 0;
    private int secondIndex = 0;
    private final String REGEX = "(\\d{1,})\\s{0,}?.?\\s{0,}?(\\d{1,})";

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            enterString(scan);
            while (!isExitNeeded) {
                enterIndexes(scan);
                if (!isExitNeeded) {
                    System.out.println("Entered string is: " + inputString);
                    System.out.println("Result string is: " + exchangeStringChars() + "\n");
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
     * Method for validating and initializing an input string
     *
     * @param scan scanner object
     */
    private void enterString(Scanner scan) {
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
    }

    /**
     * Method for entering indexes
     *
     * @param scan scanner object
     */
    private void enterIndexes(Scanner scan) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.println("Entered string is: " + inputString);
            System.out.print(ReplaceCharsByIndicesMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String inputString = scan.nextLine();

            if (inputString.equals("-1")) {
                isExitNeeded = true;
                break;
            } else {
                isInputCorrect = parseIndexes(inputString);
            }
        }
    }

    /**
     * Method for initializing indexes
     *
     * @param inputIndexes entered string with indices
     * @return check indexes flag
     */
    private boolean parseIndexes(String inputIndexes) {
        Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inputIndexes);
        try {
            if (matcher.find()) {
                return checkIndexes(matcher);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception ex) {
            System.out.println(ReplaceCharsByIndicesMessages.wrongNumberArgument.getValue());
            return false;
        }
    }

    /**
     * Method for checking entered index values
     *
     * @return check indexes flag
     */
    private boolean checkIndexes(Matcher _matcher) throws IllegalArgumentException {
        if (_matcher.groupCount() == 2) {
            firstIndex = Integer.parseInt(_matcher.group(1));
            secondIndex = Integer.parseInt(_matcher.group(2));
            if (firstIndex >= 0 && secondIndex >= 0 && firstIndex <= inputString.length() - 1
                    && secondIndex <= inputString.length() - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for replacing characters in the original string by indexes
     */
    private String exchangeStringChars() {
        char[] inputStringArray = inputString.toCharArray();
        char index1 = inputStringArray[firstIndex];
        char index2 = inputStringArray[secondIndex];
        inputStringArray[firstIndex] = index2;
        inputStringArray[secondIndex] = index1;
        return String.valueOf(inputStringArray);
    }
}
