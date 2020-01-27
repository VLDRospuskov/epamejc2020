package homeworks.newYearHolidays.recursion.raiseToThePower;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class RaiseToThePower {
    void run() {

        System.out.println("Для выхода из программы введите \"exit\"");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input1;
            String input2;
            boolean isRunning = true;

            while (isRunning) {
                System.out.print("Введите число: ");
                input1 = reader.readLine().trim();
                if (input1.equals("exit")) {
                    isRunning = false;
                    continue;
                }

                System.out.print("Введите степень: ");
                input2 = reader.readLine().trim();
                if (input2.equals("exit")) {
                    isRunning = false;
                    continue;
                }

                int number = parseIntWithExceptions(input1);
                int row = parseIntWithExceptions(input2);

                if (number == 0 && row == 0) {
                    System.out.println("Недопустимая операция (0 в степени 0). Попробуйте снова.");
                    System.out.println("------------------------------------------");
                    continue;
                }

                int result = powerOf(number, row);

                System.out.println("Число " + number + " в степени " + row +
                        " равно " + result);
                System.out.println("------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int parseIntWithExceptions (String s) {
        try {
            int n = Integer.parseInt(s);

            if (n < 0) {
                System.out.println("\033[1;91m" + "Введено отрицательное число!" + "\u001B[0m");
            }

            return Math.max(n, 0);
        } catch (Exception e) {
            System.out.println("\033[1;91m" + "Введено некорректное значение!" + "\u001B[0m");
            return 0;
        }
    }

    private static int powerOf(int n, int p) {
        if (p == 0) {
            return 1;
        } else if (p == 1) {
            return n;
        } else {
            return n * powerOf(n, p - 1);
        }
    }
}
