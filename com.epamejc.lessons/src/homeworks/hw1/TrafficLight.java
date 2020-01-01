package homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homeworks.hw1.enums.Messages.*;

public class TrafficLight {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        boolean cond = true;

        while (cond) {

            System.out.println(ENTER_MESSAGE.toString());

            String line = buffer.readLine();

            if (line.equalsIgnoreCase(EXIT_COMMAND.toString())) {
                cond = false;
                continue;
            }

            Double minutes = getNumberFromInput(line);
            if (minutes != null) {
                getColor(minutes);
            }

        }

        buffer.close();
    }

    private static Double getNumberFromInput(String line) {

        Double d = null;

        try {
            if (Double.parseDouble(line) > 0) {
                return Double.parseDouble(line);
            } else {
                System.out.println(ENTER_NUMBER_COMMAND.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER_COMMAND.toString());
        }
        return d;
    }

    private static void getColor(double minutes) {

        double div = minutes % 10;

        if (div >= 0 && div < 3) {
            System.out.println(GREEN_LIGHT_MESSAGE.toString());
        } else if (div >= 3 && div < 5) {
            System.out.println(YELLOW_LIGHT_MESSAGE.toString());
        } else {
            System.out.println(RED_LIGHT_MESSAGE.toString());
        }
    }
}
