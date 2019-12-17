package main.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.print("Введите количество секунд с начала работы светофора: ");

            int n = getIntFromUser();
            if (n == -1) break;

            System.out.println(checkTrafficLight(n) + "\n");
        }
    }

    private static String checkTrafficLight(int n) {
        final String RESET = "\u001B[0m";
        final String RED_BOLD_BRIGHT = "\033[1;91m";
        final String GREEN_BOLD_BRIGHT = "\033[1;92m";
        final String YELLOW_BOLD_BRIGHT = "\033[1;93m";

        String result;
        n = n % 10;

        if (0 <= n && n <= 3) result = GREEN_BOLD_BRIGHT + "Зеленый. Проходите!" + RESET;
        else if (3 < n && n <= 5) result = YELLOW_BOLD_BRIGHT + "Желтый. Завершайте движение." + RESET;
        else if (5 < n) result = RED_BOLD_BRIGHT + "Красный. Стойте!" + RESET;
        else result = "Светофор еще не начал работать. Введите позитивное число";

        return result;
    }

    private static int getIntFromUser() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(reader.readLine());
        } catch (Exception ignored) {
            return -1;
        }
    }
}
