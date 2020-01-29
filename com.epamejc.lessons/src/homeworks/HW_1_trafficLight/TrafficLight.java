package homeworks.HW_1_trafficLight;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class TrafficLight {

    void run() {
        System.out.println(Helper.GREETING);
        try {
            while (true) {
                int input = Helper.getInt("Seconds from the start of the TrafficLight: ");
                int n = checkIfPositive(input);
                printTrafficLightColor(n);
            }
        } catch (CancellationException ignored) {}
    }

    private int checkIfPositive(int input) {
        if (input < 0) {
            input = 0;
            System.out.println("You need to write a positive int!");
        }

        return input;
    }

    private void printTrafficLightColor(int n) {
        n = n % 10;

        if (0 <= n && n <= 3) {
            System.out.println(Colors.GREEN);
        } else if (4 <= n && n <= 5) {
            System.out.println(Colors.YELLOW);
        } else if (6 <= n) {
            System.out.println(Colors.RED);
        }

        System.out.println("---------------------------------------");
    }
}
