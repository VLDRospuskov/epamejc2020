package main.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    private int minutes;
    private int seconds;
    private final String welcomeMessage = "Welcome to TrafficLight! \nPlease input time to check. \nUse MM or MM:SS format. \nType q to exit program.";

    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private boolean streamIsActive = false;

    private String inputString;

    public void start() {
        System.out.println(welcomeMessage);
        startStream();
        readInput();
    }

    private void readInput() {
        try {
            while ((inputString = bufferedReader.readLine()) != null) {
                System.out.println(inputString);
                /* exit */
                if (inputString.equals("q")) {
                    stopStream();
                    break;
                }
                if (isInteger(inputString)) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startStream() {
        inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
        streamIsActive = true;
    }

    private void stopStream() {
        try {
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        streamIsActive = false;
    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
