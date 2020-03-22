package homeworks.java.strings;

import homeworks.java.utils.UserInputReader;

/**
 * The {@code UserMenu class} represents the main menu.
 * Contains methods to choose an option, and to print
 * menu to the system console.
 *
 * @author Vladimir Ivanov
 */
public class UserMenu {

    /**
     * Any positive integer number
     */
    private String REGEX = "^\\d+$";
    private String menu = "\n" +
            "_______________________________________________________\n" +
            "|1. New String input                                  |\n" +
            "|2. Display stored String                             |\n" +
            "|3. Display new String using even chars of stored one |\n" +
            "|4. Display new String using odd chars of stored one  |\n" +
            "|5. Display new String based on index input           |\n" +
            "|6. Swap two chars by indexes                         |\n" +
            "|7. Reverse words / word                              |\n" +
            "|8. Exit                                              |\n" +
            "|_____________________________________________________|\n" +
            "Choose an option: " +
            "\n\n";

    @Override
    public String toString() {

        return menu;

    }

    /**
     * @param stringChanger {@link homeworks.java.strings.StringChanger} that provides necessary methods to be run.
     * @return boolean indicator {@code true} if program needs to be closed or {@code false} otherwise
     */
    public boolean switchMenu(StringChanger stringChanger) {

        boolean closeProgram = false;
        int option = parseInput(UserInputReader.readInput());
        switch (option) {
            case 1:
                System.out.println("Enter string: ");
                stringChanger.setStoredString(UserInputReader.readInput());
                break;
            case 2:
                System.out.println("Stored String is: " + stringChanger.getStoredString());
                break;
            case 3:
                System.out.println(stringChanger.evenOdd(Parity.EVEN));
                break;
            case 4:
                System.out.println(stringChanger.evenOdd(Parity.ODD));
                break;
            case 5:
                runByIndexSubProgram(stringChanger);
                break;
            case 6:
                System.out.println("Enter start index:");
                int start = parseInput(UserInputReader.readInput());
                System.out.println("Enter end index:");
                int end = parseInput(UserInputReader.readInput());
                System.out.println(stringChanger.swapChars(start, end));
                break;
            case 7:
                System.out.println(stringChanger.flipWords());
                break;
            case 8:
                closeProgram = true;
                UserInputReader.close();
                break;
            default:
                System.out.print("Wrong input, try again!\n");
                break;
        }
        return closeProgram;

    }

    /**
     * Starts a loop for ByIndex sub program. It takes an int index input and outputs the {@code String}
     * made of chars on index positions from stored {@code String} in loop.
     * To return back to menu type in <t>"return"</t>
     *
     * @param stringChanger {@link homeworks.java.strings.StringChanger} that provides necessary methods to be run.
     */
    private void runByIndexSubProgram(StringChanger stringChanger) {
        System.out.println("Enter a number from 0 to " +
                (stringChanger.getStoredString().length() - 1) +
                " or 'return' to return");
        String input;
        do {
            input = UserInputReader.readInput();
            int number = parseInput(input);
            boolean done = stringChanger.byIndex(number);
            System.out.println(input.equalsIgnoreCase("return") ?
                    "" : done ? stringChanger.getStringCache() : "Wrong input!");
        } while (!input.equalsIgnoreCase("return"));
        stringChanger.setStringCache("");
    }

    /**
     * Parses a {@code String} input to an {@code int} value.
     *
     * @return parsed {@code String} as an {@code int},
     * <t>-1<\t> if there was a mistake in the input or
     * <t>-2</t> if source {@code String} equals <t>"return"</t>
     */
    private int parseInput(String userInput) {

        int result = -1;
        if (userInput.matches(REGEX)) {
            result = Integer.valueOf(userInput);
        }
        return result;

    }

}