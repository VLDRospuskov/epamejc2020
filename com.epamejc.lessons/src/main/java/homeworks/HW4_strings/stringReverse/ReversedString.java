package homeworks.HW4_strings.stringReverse;

import java.util.Scanner;

public class ReversedString {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                String inputString = enterString(scan);
                if (!isExitNeeded) {
                    System.out.println("Entered string is: " + inputString);
                    System.out.println("Reversed string is: " + reverseStrings(inputString) + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(ReversedStringMessages.exitAppMessage.getValue());
        }
    }

    /**
     * Method for entering a string
     *
     * @param scan scanner object
     * @return entered string
     */
    public String enterString(Scanner scan) {
        boolean isInputCorrect = false;
        String inputString = "";
        while (!isInputCorrect) {
            System.out.print(ReversedStringMessages.enterStringMessage.getValue());
            inputString = scan.nextLine();
            try {
                if (inputString.equals("exit")) {
                    isExitNeeded = true;
                    break;
                } else if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(ReversedStringMessages.enterStringError.getValue());
            }
        }
        return inputString;
    }

    /**
     * Method for reversing words inside input string
     *
     * @param inputString original input string
     * @return reversed words inside original string
     */
    public String reverseStrings(String inputString) {
        String resultString = "";
        String[] splittedStrings = inputString.split("\\s+");
        for (int i = 0; i < splittedStrings.length; i++) {
            StringBuilder strBuilder = new StringBuilder(splittedStrings[i]);
            if (i == splittedStrings.length - 1) {
                resultString = resultString + strBuilder.reverse().toString();
            } else {
                resultString = resultString + strBuilder.reverse().toString() + " ";
            }
        }
        return resultString;
    }
}
