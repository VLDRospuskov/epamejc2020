package homeworks.java.trafficLights;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LightsLogic {

    private Lights state;

    public Lights parseInputString(String input) {

        if (input.equalsIgnoreCase("exit")) {
            return Lights.EXIT;
        } else if (input.length() == 0 || !input.matches("^\\d*\\.*\\d{0,2}$")) {
            return Lights.WRONG_INPUT;
        }

        double number = Double.parseDouble(input);
        number = new BigDecimal(number).setScale(3, RoundingMode.DOWN).doubleValue();
        inputCheck(number);

        return state;
    }

    private void inputCheck(double num) {
        num %= 10;

        if (num - (int) num >= 0.599) {
            state = Lights.WRONG_INPUT;
        } else if (num >= 0 && num < 3) {
            state = Lights.GREEN;
        } else if (num >= 3 && num < 5) {
            state = Lights.YELLOW;
        } else if (num >= 5 && num < 10) {
            state = Lights.RED;
        } else {
            state = Lights.WRONG_INPUT;
        }
    }
}
