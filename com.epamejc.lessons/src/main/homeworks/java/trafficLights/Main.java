package homeworks.java.trafficLights;

/**
 * A traffic lights simulation. Generates green, yellow or red lights
 * based on user input. User input is decimal number where integer part represents minutes,
 * fractional part - seconds.
 * Follow the link {@link homeworks.java.trafficLights.LightsLogic} to see input rules.
 * <br>
 * For input {@code [0, 3)} output is "Green",
 * {@code [3, 5)} - "Yellow", {@code [5-10)} - "Red".
 *
 * @author Vladimir Ivanov
 */
public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.run();
    }

}