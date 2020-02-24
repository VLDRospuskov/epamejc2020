package homeworks.java.hw1;

import java.io.BufferedReader;
import java.io.IOException;

import static homeworks.java.hw1.enums.Messages.*;

public class TrafficLight {

    private Double getNumberFromInput(String line) {
        Double d = null;

        try {
            if (Double.parseDouble(line) > 0) {
                return Double.parseDouble(line);
            } else {
                System.out.println(ENTER_NUMBER_COMMAND.toString());
            }
        } catch (NumberFormatException ex){
            System.out.println(ENTER_NUMBER_COMMAND.toString());
        }
        return d;
    }

    public String getColor(String line) {
        Double minutes = getNumberFromInput(line);

        if (minutes != null) {
            double div = minutes % 10;

            if (div >= 0 && div < 3) {
                System.out.println(GREEN_LIGHT_MESSAGE.toString());
                return GREEN_LIGHT_MESSAGE.toString();
            } else if (div >= 3 && div < 5) {
                System.out.println(YELLOW_LIGHT_MESSAGE.toString());
                return YELLOW_LIGHT_MESSAGE.toString();
            } else {
                System.out.println(RED_LIGHT_MESSAGE.toString());
                return RED_LIGHT_MESSAGE.toString();
            }
        }
        return null;
    }

    public void getLight(BufferedReader buffer) {
        boolean cond = true;

        while (cond) {

            System.out.println(ENTER_MESSAGE.toString());

            String line = null;
            try {
                line = buffer.readLine();
            } catch (IOException e) {
                System.out.println(ENTER_MESSAGE);
            }

            if (line.equalsIgnoreCase(EXIT_COMMAND.toString())) {
                cond = false;
                continue;
            }

            getColor(line);
        }

        try {
            buffer.close();
        } catch (IOException e) {
            System.out.println(ERROR);
        }
    }

}
