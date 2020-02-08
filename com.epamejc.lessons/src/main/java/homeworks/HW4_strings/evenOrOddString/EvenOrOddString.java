package homeworks.HW4_strings.evenOrOddString;

import java.util.Scanner;

public class EvenOrOddString {
    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                String inputString = enterString(scan);
                if (!isExitNeeded) {
                    String filterType = enterFilterType(scan);
                    System.out.println("Entered string: " + inputString);
                    System.out.println("Transformed string: " + transformString(inputString, filterType) + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println("Program ends. Goodbye.");
        }
    }

    /**
     * Method for validating and initializing an input string
     *
     * @param scan scanner object
     * @return input string
     */
    private String enterString(Scanner scan) {
        boolean isInputCorrect = false;
        String inputString = "";
        while (!isInputCorrect) {
            System.out.print(FilterTypes.enterStringMessage.getValue());
            inputString = scan.nextLine();
            try {
                if (inputString.equals("exit")) {
                    isExitNeeded = true;
                    break;
                } else if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception ex) {
                System.out.println(FilterTypes.wrongArgument.getValue());
            }
        }
        return inputString;
    }

    /**
     * Method for checking the correctness and initializing filters (even / odd characters)
     *
     * @param scan scanner object
     * @return filter type
     */
    private String enterFilterType(Scanner scan) {
        boolean isInputCorrect = false;
        String filterType = "";
        while (!isInputCorrect) {
            System.out.print(FilterTypes.enterFilterTypeMessage.getValue());
            filterType = scan.nextLine();
            try {
                if (filterType.equals(FilterTypes.EVEN.getValue())
                        || filterType.equals(FilterTypes.ODD.getValue())) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(FilterTypes.wrongArgument.getValue());
            }
        }
        return filterType;
    }

    /**
     * Method for transforming the string based on the filter
     *
     * @param inputString input string
     * @param filterType  filter type (odd or even)
     * @return
     */
    public String transformString(String inputString, String filterType) {
        StringBuilder charBox = new StringBuilder();
        if (filterType.equals(FilterTypes.EVEN.getValue())) {
            int counter = 1;
            while (counter < inputString.length()) {
                charBox.append(inputString.charAt(counter));
                counter += 2;
            }
        } else {
            int counter = 0;
            while (counter < inputString.length()) {
                charBox.append(inputString.charAt(counter));
                counter += 2;
            }
        }
        return charBox.toString();
    }
}



