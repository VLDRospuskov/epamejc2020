package homeworks.HW5_recursion.countNumbers;


import java.util.Scanner;

public class CountNumbers {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (!isExitNeeded) {
            String inputString = enterString(scan);
            if (!isExitNeeded) {
                System.out.println("Input string is: " + inputString);
                System.out.println("The number of digits per line: " + countNumbers(inputString));
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Method for recursively calculating the quantity of numbers in a string
     *
     * @param str input string
     * @return numbers quantity
     */
    public static int countNumbers(String str) {
        if (str.length() == 0)
            return 0;
        if (Character.isDigit(str.charAt(0)))
            return 1 + countNumbers(str.substring(1));
        return countNumbers(str.substring(1));
    }

    /**
     * Method for entering a new line
     *
     * @param scan scanner object
     * @return entered string
     */
    private String enterString(Scanner scan) {
        boolean isInputCorrect = false;
        String inputString = "";
        while (!isInputCorrect) {
            System.out.print("Type \"exit\" to exit or enter a string that contains at " +
                    "least one numeric character: ");
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
                System.out.println("Wrong input. Enter correct string");
            }
        }
        return inputString;
    }
}


