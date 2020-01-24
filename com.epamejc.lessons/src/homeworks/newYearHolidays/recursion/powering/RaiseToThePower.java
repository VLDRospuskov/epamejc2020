package homeworks.newYearHolidays.recursion.powering;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class RaiseToThePower {
    void run() {

        System.out.println("Для выхода из программы введите \"exit\"");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String numberS;
            String rowS;
            boolean isRunning = true;

            while (isRunning) {
                System.out.print("Введите число: ");
                numberS = reader.readLine().trim();
                if (numberS.equals("exit")) {
                    isRunning = false;
                    continue;
                }

                System.out.print("Введите степень: ");
                rowS = reader.readLine().trim();
                if (rowS.equals("exit")) {
                    isRunning = false;
                    continue;
                }

                int number = parseIntWithExceptions(numberS);
                int row = parseIntWithExceptions(rowS);

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
