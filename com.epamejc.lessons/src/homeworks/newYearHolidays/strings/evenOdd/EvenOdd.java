package homeworks.newYearHolidays.strings.evenOdd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class EvenOdd {
    void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите строку: ");
            String input = reader.readLine().trim();
            System.out.print("Введите even или odd: ");
            String evenOdd = reader.readLine().trim().toLowerCase();

            String result = getEvenOddString(input, evenOdd);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEvenOddString(String input, String evenOdd) {
        String even = "";
        String odd = "";
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                odd += input.charAt(i);
            } else {
                even += input.charAt(i);
            }
        }

        if (evenOdd.equals("even")) {
            return even;
        } else if (evenOdd.equals("odd")) {
            return odd;
        }

        return "Неизвестная ошибка. Попробуйте еще раз.";
    }
}
