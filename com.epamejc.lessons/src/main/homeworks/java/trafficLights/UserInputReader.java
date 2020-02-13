package homeworks.java.trafficLights;

import java.io.*;

/**
 * Reads console user input and returns it as {@code String}
 */
public class UserInputReader {

    /**
     * @param reader BufferedReader for user input
     * @return user input as {@code String}
     */
    public String readInput(BufferedReader reader) {

        String inputString;

        try {
            inputString = reader.readLine();
        } catch (IOException ex) {
            System.err.println("BufferedReader exception.");
            throw new RuntimeException("Stream Closed");
        }

        return inputString;

    }

}

