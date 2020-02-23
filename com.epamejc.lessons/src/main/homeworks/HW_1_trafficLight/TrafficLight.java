package homeworks.HW_1_trafficLight;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class TrafficLight {

    void run() {
        System.out.println(Helper.GREETING);
        try {
            while (true) {
                int input = Helper.getInt("Seconds from the start of the TrafficLight: ");
                System.out.println(getTrafficLightColor(input));
                System.out.println("---------------------------------------");
            }
        } catch (CancellationException ignored) {}
    }

    public Colors getTrafficLightColor(int n) {
        n = zeroIfNegative(n);
        n = n % 10;

        if (0 <= n && n <= 3) {
            return Colors.GREEN;
        } else if (4 <= n && n <= 5) {
            return Colors.YELLOW;
        } else {
            return Colors.RED;
        }
    }

    private int zeroIfNegative(int input) {
        if (input < 0) {
            input = 0;
            System.out.println("You need to write a positive int!");
        }

        return input;
    }

}
