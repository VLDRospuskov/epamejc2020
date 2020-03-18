package homeworks.utility.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Helper helps with IO:
 * 1) Handles IO errors and exceptions
 * 2) Handles exceptions when parsing
 * 3) Removes all empty spaces around numbers when parsing
 * 4) When inputting an empty space, throws custom CancellingException, for breaking a loop
 * It automatically frees resources when throwing Exception.
 * If some other way of closing is meant, use closeReaderSilently();
 */

public class Helper {
    public static final String GREETING = "To exit just prompt an empty string";
    private static final String FINAL_MESSAGE = "Thank you!";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() throws CancellationException {
        String input = "";

        try {
            System.out.print("Write down a string: ");
            input = reader.readLine();
            checkExit(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public static String getString(String message) throws CancellationException {
        String input = "";

        try {
            System.out.print(message);
            input = reader.readLine();
            checkExit(input);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }

    public static String getStringSilently(String message) {
        String input = "";

        try {
            System.out.print(message);
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }


    public static int getInt() throws CancellationException {
        int input = 0;

        try {
            System.out.print("Write down a number: ");
            String s = reader.readLine();
            checkExit(s);
            input = parseInt(s);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }

    public static int getInt(String message) throws CancellationException {
        int input = 0;

        try {
            System.out.print(message);
            String s = reader.readLine();
            checkExit(s);
            input = parseInt(s);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }

    public static int getIntSilently(String message) {
        int input = 0;

        try {
            System.out.print(message);
            String s = reader.readLine();
            input = parseIntSilently(s);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }

    private static int parseIntSilently(String s) {
        int input;
        s = s.replaceAll(" ", "");

        try {
            input = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            input = getIntSilently("It's not an int! Try again: ");
        }

        return input;
    }

    public static void closeReader() {
        try {
            System.out.println("The stream is successfully closed.");
            reader.close();
            System.out.println(FINAL_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeReaderSilently() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int parseInt(String s) throws CancellationException {
        int input;
        s = s.replaceAll(" ", "");

        try {
            input = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            input = getInt("It's not an int! Try again: ");
        }

        return input;
    }

    private static void checkExit(String input) throws CancellationException {
        if (input.length() == 0) {
            closeReader();
            throw new CancellationException();
        }
    }
}
