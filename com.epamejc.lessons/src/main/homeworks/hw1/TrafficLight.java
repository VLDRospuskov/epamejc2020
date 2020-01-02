package homeworks.hw1;

import static homeworks.hw1.enums.Messages.*;

public class TrafficLight {

    static void getColor(String line) {

        Double minutes = Number.getNumberFromInput(line);

        if (minutes != null) {
            double div = minutes % 10;

            if (div >= 0 && div < 3) {
                System.out.println(GREEN_LIGHT_MESSAGE.toString());
            } else if (div >= 3 && div < 5) {
                System.out.println(YELLOW_LIGHT_MESSAGE.toString());
            } else {
                System.out.println(RED_LIGHT_MESSAGE.toString());
            }
        }
    }

}
