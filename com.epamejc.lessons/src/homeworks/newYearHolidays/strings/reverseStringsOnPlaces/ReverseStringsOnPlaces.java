package homeworks.newYearHolidays.strings.reverseStringsOnPlaces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ReverseStringsOnPlaces {
    void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите строку: ");
            String input = reader.readLine().trim();
            String[] strings = input.split(" ");
            ArrayList<String> arrayList = new ArrayList<>();

            for (String s : strings) {
                String reversed = "";
                for (int i = s.length()-1; i >= 0; i--) {
                    reversed += s.charAt(i);
                }
                arrayList.add(reversed);
            }

            for (String s : arrayList) {
                System.out.print(s);
                System.out.print(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
