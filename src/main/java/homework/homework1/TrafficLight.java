package homework.homework1;

import java.util.Scanner;

public class TrafficLight {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("If you want to quit press 'q'.");

        while (true) {
            System.out.println("Enter time: ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            Double time;
            try {
                time = Double.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Error. Enter double value.");
                continue;
            }

            String colorForTime = getColorForTime(time);
            System.out.println(colorForTime);
        }

        scanner.close();
    }

    private static String getColorForTime(Double time) {
        if (time >= 0 && time <= 3)
            return "Green";
        if (time > 3 && time <= 5)
            return "Yellow";
        if (time > 5 && time <= 10)
            return "Red";

        return "Incorrect time";
    }

}
