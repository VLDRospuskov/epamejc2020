package homeworks.newYearHolidays.recursion.amountOfNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AmountOfDigits {

    void run(){

        System.out.println("Для выхода из программы введите \"exit\"");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Введите число: ");
            String s = reader.readLine().trim();

            while (!s.equals("exit")) {
                int n = parseIntWithExceptions(s);
                int digits = getDigits(n);
                System.out.println("Количество знаков в числе: " + digits);

                System.out.print("Введите число: ");
                s = reader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int parseIntWithExceptions (String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("\033[1;91m" + "Введено некорректное значение!" + "\u001B[0m");
            return 0;
        }
    }


    private int getDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        } else {
            return 1 + getDigits(n / 10);
        }
    }
}
