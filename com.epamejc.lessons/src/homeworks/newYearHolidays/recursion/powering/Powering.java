package homeworks.newYearHolidays.recursion.powering;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Powering {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите число: ");
            int n = Integer.parseInt(reader.readLine());
            System.out.print("Введите степень: ");
            int p = Integer.parseInt(reader.readLine());
            System.out.println(powerOf(n, p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int powerOf(int n, int p) {
        if (p == 0) {
            return 0;
        } else if (p == 1) {
            return n;
        } else {
            return n * powerOf(n, p - 1);
        }
    }
}
