package homeworks.java.trafficLights;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents the logic of traffic light. It is used to parse an input {@code String},
 * and chose a proper {@link homeworks.java.trafficLights.Lights} state.
 * <br>
 * {@code String} should comply with the following rules:
 * <p>
 * - the integer part may be present or absent <br>
 * - the integer part can be any length <br>
 * - the fractional part may be present or absent <br>
 * - if the fractional part represented, it must be 1 or 2 digits long
 * </p>
 *
 * @author Vladimir Ivanov
 */
public class LightsLogic {

    /**
     * {@code String} parsing regex. Input must match following pattern:
     * i.f, where i is any positive number(may present or absent),
     * .f is point and 2-digit positive number (may preset or absent)<br>
     * For example:
     * <blockquote><pre>
     *
     * 12.02    - <b>correct<\b>
     * .22      - <b>correct<\b>
     * 2        - <b>correct<\b>
     * 12.222   - <b>incorrect<\b>
     *
     *      </pre></blockquote>
     */
    private final String REGEX = "^\\d*\\.*\\d{0,2}$";

    /**
     * Parses an input {@code String}.
     *
     * @param input The {@code String} to be parsed
     * @return {@link homeworks.java.trafficLights.Lights} object, based on {@code input} <br>
     * if {@code input} doesn't match regex - returns {@link homeworks.java.trafficLights.Lights#WRONG_INPUT}
     * indicator <br>
     * and {@link homeworks.java.trafficLights.Lights#EXIT} indicator if {@code input} matches "exit"
     */
    public Lights parseInputString(String input) {

        String exit = "exit";
        if (input.equalsIgnoreCase(exit)) {
            return Lights.EXIT;
        } else if (input.length() == 0 || !input.matches(REGEX)) {
            return Lights.WRONG_INPUT;
        }

        double time = Double.parseDouble(input);
        time = new BigDecimal(time).setScale(3, RoundingMode.DOWN).doubleValue();

        return switchLightsState(time);

    }

    /**
     * Calculating the hit of a given {@code time} in specified ranges
     *
     * @param time The double value, representing time (minutes.seconds)
     * @return {@link homeworks.java.trafficLights.Lights} object.
     * For number in range {@code [0, 3)} - {@link homeworks.java.trafficLights.Lights#GREEN},
     * {@code [3, 5)} - {@link homeworks.java.trafficLights.Lights#YELLOW},
     * {@code [5-10)} - {@link homeworks.java.trafficLights.Lights#RED}, or
     * {@link homeworks.java.trafficLights.Lights#WRONG_INPUT} otherwise.
     */
    private Lights switchLightsState(double time) {

        time %= 10;
        Lights state;
        if (time - (int) time >= 0.599) {
            state = Lights.WRONG_INPUT;
        } else if (time >= 0 && time < 3) {
            state = Lights.GREEN;
        } else if (time >= 3 && time < 5) {
            state = Lights.YELLOW;
        } else if (time >= 5 && time < 10) {
            state = Lights.RED;
        } else {
            state = Lights.WRONG_INPUT;
        }
        return state;

    }

}