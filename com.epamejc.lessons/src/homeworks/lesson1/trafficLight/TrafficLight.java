package homeworks.lesson1.trafficLight;

import homeworks.utility.helper.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {

    private final String GREET_MESSAGE = "Для выхода введите \"exit\"";
    private final String FINAL_MESSAGE = "Спасибо за пользование программой!";

    void run() {
        System.out.println(GREET_MESSAGE);

        boolean isRunning = true;
        while (isRunning) {
            String s = Helper.getUserInput("Введите количество секунд с начала работы светофора: ");
            if (s.equals("exit")) {
                isRunning = false;
                System.out.println(FINAL_MESSAGE);
                continue;
            }

            int n = Helper.parseInt(s);
            if (n > 0) {
                printColorTrafficLight(n);
            } else {
                System.out.println("Введите положительное значение!");
            }

            System.out.println("---------------------------------------");
        }
    }

    private void printColorTrafficLight(int n) {
        n = n % 10;

        if (0 <= n && n <= 3) {
            System.out.println(Colors.GREEN);
        } else if (4 <= n && n <= 5) {
            System.out.println(Colors.YELLOW);
        } else if (6 <= n) {
            System.out.println(Colors.RED);
        }
    }
}
