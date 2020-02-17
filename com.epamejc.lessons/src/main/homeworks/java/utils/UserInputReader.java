package homeworks.java.utils;

import java.io.*;

/**
 * Util {@code class UserInputReader} reads console user input
 * and returns it as {@code String}
 *
 * @author Vladimir Ivanov
 */
public class UserInputReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readInput() {

        String inputString;

        try {
            inputString = reader.readLine();
        } catch (IOException ex) {
            System.err.println("BufferedReader exception.");
            throw new RuntimeException("Stream Closed");
        }

        return inputString;

    }

    public static void close() {

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}


