package homeworks.java.arrays;

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
     * regex to parse user input
     */
    private String REGEX = "^\\d*$";
    /**
     * stores the main menu as a {@code String}
     */
    private String menu = "\n" +
            "_________________________________________________\n" +
            "|1. Generate an array                           |\n" +
            "|2. Display an array                            |\n" +
            "|3. Display every odd row and column as string  |\n" +
            "|4. Display every even row and column as string |\n" +
            "|5. Exit                                        |\n" +
            "|_______________________________________________|\n" +
            "Choose an option: " +
            "\n\n";

    /**
     * Calls specific methods based on user choice.
     *
     * @param array {@link homeworks.java.arrays.RandomCharArray} that provides necessary methods to be run.
     * @return boolean indicator {@code true} if program needs to be closed or {@code false} otherwise
     */
    public boolean switchMenu(RandomCharArray array) {

        boolean closeProgram = false;
        int option = parseInput();
        switch (option) {
            case 1:
                System.out.println("Enter dimensions of the array.\nExample: 14 2\n");
                boolean arrayCreated = array.generateArr(UserInputReader.readInput());
                if (!arrayCreated) {
                    System.out.println("Wrong input, try again.");
                }
                break;
            case 2:
                array.print();
                break;
            case 3:
                System.out.println(array.makeStringWithStrategy(Strategy.A));
                break;
            case 4:
                System.out.println(array.makeStringWithStrategy(Strategy.B));
                break;
            case 5:
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
     * Prints user menu to the console
     */
    public void printMenu() {

        System.out.println(menu);

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
