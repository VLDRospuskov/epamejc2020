package homeworks.newYearHolidays.recursion.amountOfNumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AmountOfNumbers {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите число: ");
            int n = Integer.parseInt(reader.readLine());
            System.out.println(howManyDigits(n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int howManyDigits(int n) {
        if (n == 0) {
            return 0;
        } else if (n/10 == 0) {
            return 1;
        } else {
            return 1 + howManyDigits(n/10);
        }
    }
}
