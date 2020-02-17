package homeworks.java.strings;

import homeworks.java.arrays.RandomCharArray;
import homeworks.java.arrays.Strategy;
import homeworks.java.utils.UserInputReader;

/**
 * The {@code UserMenu class} represents the main menu.
 * Contains methods to choose an option, and to print
 * menu to the system console.
 *
 * @author Vladimir Ivanov
 */
public class UserMenu {

    private String REGEX = "^\\d*$";

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
        int option = parseInput();
        switch (option) {
            case 1:
                System.out.println("Enter string: ");
                stringChanger.setStoredString(UserInputReader.readInput());
                break;
            case 2:
                System.out.println("Stored String is: " + stringChanger.getStoredString());
                break;
            case 3: //Missing break statement isn't a mistake. The actions are the same for both cases.
            case 4:
                System.out.println(stringChanger.evenOdd(choice));
                break;
            case 5:
                closeProgram = true;
                UserInputReader.close();
                break;
            default:
                System.out.print("Wrong input, try again!\n");
                break;
        }

        switch (choice) {


            case 3:
            case 4:
                System.out.println(changer.evenOdd(storedString, choice));
                break;
            case 5:
                System.out.println("Enter a number from 0 to " + (storedString.length() - 1) +
                        " or 'exit' to return");
                do {
                    try {
                        String input = stringInput(reader);
                        if (input.equals("exit")) {
                            break;
                        }

                        int[] i = parseInt(input, 1);

                        String output = changer.byIndex(storedString, i[0]);
                        System.out.println(output);

                    } catch (WrongInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                changer.clearStorage();
                break;
            case 6:
                System.out.println("Enter two numbers between 0 and " + (storedString.length() - 1));
                int[] i;
                try {
                    i = parseInt(stringInput(reader), 0);
                    storedString = changer.swapChars(storedString, i);
                    System.out.println(storedString);
                } catch (WrongInputException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 7:
                storedString = changer.flipWords(storedString);
                System.out.println(storedString);
                break;
            case 8:
                break;

            default:
                System.out.println("Wrong input, try again!");
                break;
        }

        return closeProgram;

    }

    /**
     * Parses a {@code String} input to an {@code int} value.
     *
     * @return parsed {@code String} as an {@code int},
     * or {@code 0} if there was a mistake in the input
     */
    private int parseInput() {

        String userInput = UserInputReader.readInput();
        int menuItem = 0;

        if (userInput.length() != 0 && userInput.matches(REGEX)) {
            menuItem = Integer.valueOf(userInput);
        }
        return menuItem;

    }
}