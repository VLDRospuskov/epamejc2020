package homeworks.java.trafficLights;

import homeworks.java.utils.UserInputReader;

import static homeworks.java.utils.UserInputReader.*;

/**
 * The {@code Engine class} represents the main loop of the program.
 *
 * @author Vladimir Ivanov
 */
public class Engine {

    /**
     * The value, storing a general greeting message which explains how to use the program
     */
    private final String greetingsMessage = "\"Type time in following format: \\\"m.s or m\\\", \\nthere m - minutes from 0 to n, \" +\n" +
            "                    \"and s - seconds from 0 to 59 \\nor word \\\"exit\\\" to quit the program\"";

    /**
     * Runs the program.
     */
    public void run() {

        System.out.println(greetingsMessage);
        int exit;
        do {
            String input = UserInputReader.readInput();
            Lights lightsState = new LightsLogic().parseInputString(input);
            exit = switchOutput(lightsState);
        } while (exit != -1);

        UserInputReader.close();

    }

    /**
     * Prints the state of traffic lights on the screen and returns integer indicator {@code 1}
     * if state equals {@link homeworks.java.trafficLights.Lights#EXIT}, or {@code 0} otherwise
     *
     * @param state The actual state of the traffic light {@code Lights} to be printed on the screen
     *              including the "wrong input" message.
     * @return integer value {@code 0} or {@code 1}.
     */
    private int switchOutput(Lights state) {

        int indicator = 0;

        switch (state) {
            case GREEN:
                System.out.println("The traffic lights is Green");
                break;
            case YELLOW:
                System.out.println("The traffic lights is Yellow");
                break;
            case RED:
                System.out.println("The traffic lights is Red");
                break;
            case WRONG_INPUT:
                System.out.println("Wrong input! Try again.");
                break;
            case EXIT:
                System.out.println("Bye");
                indicator = -1;
                break;
        }

        return indicator;

    }

}




