package homeworks.lesson1.trafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {
    private final String EXIT_WORD = "exit";
    private final String GREET_MESSAGE = "Для выхода введите \"" + EXIT_WORD + "\"\n";
    private final String FINAL_MESSAGE = "Спасибо за пользование программой!";

    void run() {
        System.out.println(GREET_MESSAGE);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isRunning = true;

            while (isRunning) {
                int n = getIntFromUser(reader);

                if (n == -1) {
                    isRunning = false;
                    continue;
                } else if (n == -2) {
                    continue;
                }

                checkTrafficLight(n);
            }
        } catch (IOException e){
            System.out.println("Что-то пошло не так c вводом/выводом!");
        }
    }

    private int getIntFromUser(BufferedReader reader) {
        try {
            System.out.print("Введите количество минут с начала работы светофора: ");
            String s = reader.readLine();

            if (s.equalsIgnoreCase(EXIT_WORD)) {
                System.out.println(FINAL_MESSAGE);
                return -1;
            }

            int n = Integer.parseInt(s);

            if (n < 0) {
                System.out.println("Введите число больше нуля!");
                return -2;
            } else {
                return n;
            }

        } catch (NumberFormatException e) {
            System.out.println("Попробуйте еще раз. Возможно, вместо цифр вы написали буквы, или число " +
                    "слишком длинное");
            return -2;

        } catch (Exception e) {
            System.out.println("Что-то пошло не так с вводимым значением!");
            e.printStackTrace();
            return -1;
        }
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
