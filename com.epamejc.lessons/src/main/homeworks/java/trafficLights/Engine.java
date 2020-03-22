package homeworks.java.trafficLights;

import homeworks.java.utils.UserInputReader;

public class Engine {

    private final String greetingsMessage = "Type time in following format: \"m.s or m\", \nthere m - minutes from 0 to n,\n" +
            " and s - seconds from 0 to 59 \nor word \"exit\" to quit the program";

    public void run() {

        System.out.println(greetingsMessage);
        boolean isDone;
        do {
            String input = UserInputReader.readInput();
            Lights lightsState = new LightsLogic().parseInputString(input);
            isDone = switchOutput(lightsState);
        } while (!isDone);

        UserInputReader.close();

    }

    /**
     * Prints the state of traffic lights on the screen and returns boolean indicator {@code true}
     * if state equals {@link homeworks.java.trafficLights.Lights#EXIT}, or {@code false} otherwise
     *
     * @param state The actual state of the traffic light {@code Lights} to be printed on the screen
     *              including the "wrong input" message.
     * @return boolean indicator {@code true} if program needs to be closed or {@code false} otherwise
     */
    private boolean switchOutput(Lights state) {

        boolean isDone = false;

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
                isDone = true;
                break;
        }
        return isDone;

    }

}