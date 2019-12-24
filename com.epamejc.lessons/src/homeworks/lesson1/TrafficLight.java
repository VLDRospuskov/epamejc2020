package homeworks.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {

    void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRunning = true;

        while (isRunning) {
            int n = getIntFromUser(reader);
            if (n == -1) {
                isRunning = false;
            }
            checkTrafficLight(n);
        }

        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Не получилось закрыть поток!");
        }
    }

    private int getIntFromUser(BufferedReader reader) {
        int n;
        System.out.print("Введите количество секунд с начала работы светофора: ");

        try {
            n = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Что-то пошло не так с вводимым значением!");
            return -1;
        }

        if (n == -1) {
            System.out.println("Спасибо за пользование программой!");
            return -1;
        } else if (n < -1) {
            System.out.println("Введите число больше нуля!");
            return -1;
        } else return n;
    }

    private void checkTrafficLight(int n) {
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
