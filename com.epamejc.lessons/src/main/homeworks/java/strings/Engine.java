package homeworks.java.strings;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Engine {

    private String storedString = "";

    public void run() {

        UserMenu userMenu = new UserMenu();
        RandomCharArray array = new RandomCharArray();
        System.out.println("Welcome to an Array test program!\n");

        boolean isDone;
        do {
            System.out.println(userMenu);
            isDone = userMenu.switchMenu(array);
        } while (!isDone);
        System.out.println("Bye-bye!");

    }



    public void rusn() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int choice;
            StringChanger changer = new StringChanger();
            System.out.println("Welcome to a String test program!");

            do {
                if (storedString.equals("")) {
                    System.out.println("You have to enter a string to start.");
                    choice = 1;
                } else {
                    choice = menu(reader);
                }

                switch (choice) {
                    case 1:
                        System.out.println("Enter string: ");
                        storedString = stringInput(reader);
                        break;
                    case 2:
                        System.out.println("Stored String is: " + storedString);
                        break;
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
            } while (choice != 8);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String stringInput(BufferedReader reader) {
        String input = "";

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    private int[] parseInt(String inp, int num) throws WrongInputException {
        int[] input;

        if (inp.matches("\\D+") || inp.equals("")) {
            throw new WrongInputException("Wrong input, try again");
        }
        String[] str = inp.split(" ");
        input = new int[str.length];

        if (((str.length > 2 || str.length < 1) && num == 0) || (str.length < 1 || str.length > 1 && num == 1)) {
            throw new WrongInputException("Wrong input, try again");
        }

        for (int i = 0; i < str.length; i++) {
            input[i] = Integer.valueOf(str[i]);
        }
        return input;
    }

    private int menu(BufferedReader reader) {

        System.out.println("\n" +
                "_______________________________________________________\n" +
                "|1. New String input                                  |\n" +
                "|2. Display stored String                             |\n" +
                "|3. Display new String using even chars of stored one |\n" +
                "|4. Display new String using odd chars of stored one  |\n" +
                "|5. Display new String based on index input           |\n" +
                "|6. Swap two chars by indexes                         |\n" +
                "|7. Reverse words / word                              |\n" +
                "|8. Exit                                              |\n" +
                "|_____________________________________________________|");


        String str = stringInput(reader);
        int input = 0;

        try {
            input = Integer.valueOf(str);

        } catch (NumberFormatException e) {
            return 0;
        }

        return input;
    }
}