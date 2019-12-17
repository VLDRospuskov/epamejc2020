package main.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Чтобы выйти из программы, введите -1");

        while (true) {
            System.out.print("Введите количество секунд с начала работы светофора: ");

            int n = getIntFromUser();
            if (n == -1) break;

            System.out.println(checkTrafficLight(n) + "\n");
        }
    }

    private static String checkTrafficLight(int n) {
        String result;
        n = n % 480;

        if (0 <= n && n < 180) result = "Зеленый. Проходите!";
        else if (180 <= n && n < 360) result = "Желтый. Завершайте движение.";
        else if (360 <= n) result = "Красный. Стойте!";
        else result = "Светофор еще не начал работать. Введите позитивное число.";

        return result;
    }

    private static int getIntFromUser() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(reader.readLine());
        } catch (Exception ignored) {
            System.out.println("Возникла ошибка ввода! Перезапустите программу.");
            return -1;
        }
    }
}
