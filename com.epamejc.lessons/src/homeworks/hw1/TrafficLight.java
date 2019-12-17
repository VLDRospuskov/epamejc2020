package homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private final static String exitCommand = "exit";
    private final static String enterMessage = "Enter time in minutes. You can enter not only integer numbers. To exit print \"exit\"";
    private final static String enterNumberCommand = "You have to enter a number";
    private final static String greenLightMessage = "Green light is ON";
    private final static String yellowLightMessage = "Yellow light is ON";
    private final static String redLightMessage = "Red light is ON";

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        boolean cond = true;

        while (cond) {

            System.out.println(enterMessage);

            String line = buffer.readLine();

            if (line.equalsIgnoreCase(exitCommand)) {
                cond = false;
                continue;
            }

            Double minutes = getNumberFromInput(line);
            if (minutes != null) getColor(minutes);

        }
    }

    private static Double getNumberFromInput(String line) {

        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            System.out.println(enterNumberCommand);
        }
        return null;
    }

    private static void getColor(double minutes) {

        double div = minutes % 10;

        if (div >= 0 && div < 3) {
            System.out.println(greenLightMessage);
        } else if (div >= 3 && div < 5) {
            System.out.println(yellowLightMessage);
        } else {
            System.out.println(redLightMessage);
        }
    }
}
