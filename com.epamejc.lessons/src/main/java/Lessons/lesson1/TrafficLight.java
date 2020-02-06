package Lessons.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    private int minutes;
    private boolean outputIsReady = false;
    private final String welcomeMessage = "Welcome to TrafficLight! \nPlease input time in minutes to check. \nType q to exit program.";
    private final String goodbyeMessage = "Thank you for using TrafficLight, goodbye!";
    private final String stringMismatchMessage = "Please provide time in minutes.";

    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private boolean streamIsActive = false;

    private String inputString;

    public void start() {
        System.out.println(welcomeMessage);
        startStream();
        readInput();
        System.out.println(goodbyeMessage);
    }

    private void readInput() {
        try {
            while ((inputString = bufferedReader.readLine()) != null) {
                outputIsReady = false;
                System.out.println(inputString);
                /* exit */
                if (inputString.equals("q")) {
                    stopStream();
                    break;
                }

                /* input is digit(s) */
                if (isInteger(inputString)) {
                    minutes = Integer.parseInt(inputString);
                    while (minutes >= 10) {
                        minutes = minutes - 10;
                    }
                    outputIsReady = true;
                } else {
                    System.out.println(stringMismatchMessage);
                }

                if (outputIsReady) {
                    checkLight();
                    printOutput();
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

    private void printOutput() {
        System.out.println("output: " + minutes);
    }

    private void checkLight() {
        if (minutes < 4) {
            System.out.println("Light is GREEN");
        } else if (minutes < 6) {
            System.out.println("Light is YELLOW");
        } else {
            System.out.println("Light is RED");
        }
    }
}
