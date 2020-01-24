package homeworks.newYearHolidays.strings.stringByIndexes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class StringByIndexes {
    void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите строку: ");
            String s = reader.readLine().trim();
            String result = "";

            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Введите индекс символа (число от 0 до " + (s.length() - 1) + " включительно): ");
                int i = Integer.parseInt(reader.readLine());
                if (i >= 0 && i < s.length()) {
                    result += s.charAt(i);
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
