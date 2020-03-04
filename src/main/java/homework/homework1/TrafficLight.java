package homework.homework1;

import java.util.Scanner;

public class TrafficLight {

    final static String INFO = "If you want to quit press 'q'.";
    final static String INVITATION = "Enter time in double format: ";
    final static String ERR_TIME_FORMAT = "Error. Incorrect format.";
    final static String ERR_TIME_VALUE = "Error. Incorrect time value.";
    final static String QUIT = "q";

    final static String RED = "Red";
    final static String GREEN = "Green";
    final static String YELLOW = "Yellow";

    public String getColorForTime(Double time) {
        if (time >= 0 && time <= 3) {
            return GREEN;
        }

        if (time > 3 && time <= 5) {
            return YELLOW;
        }

        if (time > 5 && time <= 10) {
            return RED;
        }

        return ERR_TIME_VALUE;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(INFO);

        while (true) {
            System.out.println(INVITATION);
            String input = scanner.nextLine();

            if (input.equals(QUIT)) {
                break;
            }

            Double time;
            try {
                time = Double.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println(ERR_TIME_FORMAT);
                continue;
            }

            String colorForTime = getColorForTime(time);
            System.out.println(colorForTime);
        }

        scanner.close();
    }
}
