package homeworks.java.trafficLights;

import java.io.*;

public class UserInputReader {

    public String readInput(BufferedReader reader) {
        String inputString = "";

        try {
            inputString = reader.readLine();
        } catch (IOException ex) {
            System.err.println("BufferedReader exception.");
            ex.printStackTrace();
            throw new RuntimeException("Stream Closed");
        }
        return inputString;
    }
}

