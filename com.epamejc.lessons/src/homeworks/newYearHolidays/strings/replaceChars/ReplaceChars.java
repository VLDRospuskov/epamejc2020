package homeworks.newYearHolidays.strings.replaceChars;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ReplaceChars {
    void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите строку: ");
            String s = reader.readLine().trim();
            System.out.println("Введите индексы символов: ");
            int ch1Index = Integer.parseInt(reader.readLine());
            int ch2Index = Integer.parseInt(reader.readLine());
            char ch1 = s.charAt(ch1Index);
            char ch2 = s.charAt(ch2Index);
            String result = "";

            for (int i = 0; i < s.length(); i++) {
                if (i == ch1Index) {
                    result += ch2;
                } else if (i == ch2Index) {
                    result += ch1;
                } else {
                    result += s.charAt(i);
                }
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
