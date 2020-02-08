package homeworks.java.trafficLights;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InputProcessor {

    public Lights readInput(BufferedReader reader) {
        Lights result;

        try {
            String inp = reader.readLine();
            double number;

            if (inp.equals("exit")) {
                return Lights.EXIT;

            } else {
                try {
                    number = Double.parseDouble(inp);
                    number = new BigDecimal(number).setScale(3, RoundingMode.DOWN).doubleValue();
                    result = inputCheck(number);

                } catch (NumberFormatException e) {
                    return Lights.WRONG_INPUT;
                }
            }

        } catch (IOException ex) {
            System.err.println("BufferedReader exception.");
            return Lights.EXCEPTION;
        }
        return result;
    }

    private Lights inputCheck(double num) {

        num %= 10;

        if (num - (int) num >= 0.599) {
            return Lights.WRONG_INPUT;
        } else if (num >= 0 && num < 3) {
            return Lights.GREEN;
        } else if (num >= 3 && num < 5) {
            return Lights.YELLOW;
        } else if (num >= 5 && num < 10) {
            return Lights.RED;
        } else {
            return Lights.WRONG_INPUT;
        }
    }
}

