package homeworks.HW_1_trafficLight;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class TrafficLight {

    public void run() {
        System.out.println(Helper.GREETING);
        try {
            while (true) {
                int input = Helper.getInt("Seconds from the start of the TrafficLight: ");
                String message = getTrafficLightColor(input);
                System.out.println(message + "\n" + "---------------------------------------");
            }
        } catch (CancellationException ignored) {}
    }

    public String getTrafficLightColor(int n) {
        int result = formatNumber(n);

        if (0 <= result && result <= 3) {
            return Messages.GREEN.toString();
        } else if (4 <= result && result <= 5) {
            return Messages.YELLOW.toString();
        } else {
            return Messages.RED.toString();
        }
    }

    private int formatNumber(int n) {
        return n < 0 ? 0 : n % 10;
    }

}
