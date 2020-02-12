package homeworks.java.trafficLights;

import java.io.*;

class Engine {

    private final String string = "\"Type time in following format: \\\"m.s or m\\\", \\nthere m - minutes from 0 to n, \" +\n" +
            "                    \"and s - seconds from 0 to 59 \\nor word \\\"exit\\\" to quit the program\"";

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(string);
            int exit;
            do {
                String input = new UserInputReader().readInput(reader);
                Lights lightsState = new LightsLogic().parseInputString(input);
                exit = switchOutput(lightsState);
            } while (exit != 1);
        } catch (IOException e) {
            System.err.println("Something gone wrong with InputStream");
            e.printStackTrace();
        }
    }

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
                indicator = 1;
                break;
        }
        return indicator;
    }
}




