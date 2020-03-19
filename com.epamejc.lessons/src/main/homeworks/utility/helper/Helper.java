package homeworks.utility.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Helper helps with IO:
 * 1) Handles IO errors and exceptions
 * 2) Handles exceptions when parsing
 * 3) Removes all empty spaces around numbers when parsing
 * 4) When inputting an empty space, throws custom CancellationException, for breaking a loop
 * It automatically frees resources when throwing CancellationException.
 * If some other way of closing is meant, use closeReaderSilently();
 */

public class Helper {

    public static final String GREETING = "To exit just prompt an empty string";
    private static final String NOT_INT = "It's not an int! Try again: ";
    private static final String STREAM_CLOSED = "The stream is successfully closed.";
    private static final String STREAM_NOT_CLOSED = "Problems closing the stream!";

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() {
        return getString("");
    }

    public static String getString(String message) {
        try {
            System.out.print(message);
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return "";
        }
    }

    public static int getInt(String message) {
        return parseInt(getString(message));
    }

    public static int parseInt(String str) {
        try {
            String input = str.replaceAll(" ", "");
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return getInt(NOT_INT);
        }
    }

    //LOOP EXIT HANDLING METHODS
    public static String getStringInLoop() throws CancellationException {
        return getStringInLoop("");
    }

    public static String getStringInLoop(String message) throws CancellationException {
        try {
            System.out.print(message);
            String input = reader.readLine();
            ifEmptyThrowExceptionAndCloseStream(input);
            return input;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return "";
        }
    }

    public static int getIntInLoop() throws CancellationException {
        return getIntInLoop("");
    }

    public static int getIntInLoop(String message) throws CancellationException {
        return parseIntInLoop(getStringInLoop(message));
    }

    public static int parseIntInLoop(String str) throws CancellationException {
        try {
            String input = str.replaceAll(" ", "");
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return getIntInLoop(NOT_INT);
        }
    }


    //Util methods
    public static void closeReader() {
        try {
            reader.close();
            System.out.println(STREAM_CLOSED);
        } catch (IOException e) {
            System.out.println(STREAM_NOT_CLOSED);
            e.printStackTrace();
        }
    }

    private static void ifEmptyThrowExceptionAndCloseStream(String input) throws CancellationException {
        if (input.length() == 0) {
            closeReader();
            throw new CancellationException();
        }
    }

}
