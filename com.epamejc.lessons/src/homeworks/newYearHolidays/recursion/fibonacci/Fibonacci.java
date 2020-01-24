package homeworks.newYearHolidays.recursion.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Fibonacci {
    void run() {

        System.out.println("Для выхода из программы введите \"exit\"");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;

            do {
                System.out.print("Введите порядковый номер числа Фибоначчи: ");

                s = reader.readLine().trim();
                int input = parseIntWithExceptions(s);
                long start = System.currentTimeMillis();
                int number = fibonacci(input);
                long finish = System.currentTimeMillis();

                System.out.println("Значение " + input + " числа Фибоначчи: " + number +
                        ". Найдено за " + (finish-start) + " миллисекунд");
            } while (!s.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int parseIntWithExceptions (String s) {
        try {
            int n = Integer.parseInt(s);

            if (n < 0) {
                System.out.println("\033[1;91m" + "Введите положительное число!" + "\u001B[0m");
            }

            return Math.max(n, 0);
        } catch (Exception e) {
            System.out.println("\033[1;91m" + "Введено некорректное значение!" + "\u001B[0m");
            return 0;
        }
    }

    private int fibonacci (int n) {
        if (n > 50) {
            n = 50;
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
