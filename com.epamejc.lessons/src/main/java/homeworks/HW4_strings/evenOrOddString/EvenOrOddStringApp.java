package homeworks.HW4_strings.evenOrOddString;

import java.util.Scanner;

public class EvenOrOddStringApp {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        EvenOrOddString evenOrOddString = new EvenOrOddString();
        try {
            while (!isExitNeeded) {
                String inputString = enterString(scan);
                if (!isExitNeeded) {
                    String filterType = enterFilterType(scan);
                    System.out.println("Entered string: " + inputString);
                    System.out.println("Transformed string: " +
                            evenOrOddString.processString(inputString, filterType) + "\n");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            FilterTypes.exitAppMessage.getValue();
        }
    }

    /**
     * Method for checking the correctness and initializing filters (even / odd characters)
     *
     * @param scan scanner object
     * @return filter type
     */
    public String enterFilterType(Scanner scan) {
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
}
