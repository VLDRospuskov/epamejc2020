package homeworks.newYearHolidays.arrays.pyramidX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PyramidX {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Character> arrayList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arrayList.add('x');
            }

            for (int i = 0; i < n; i++) {
                for (Character ch : arrayList) {
                    System.out.print(ch);
                }

                if (arrayList.size() > 0) {
                    arrayList.remove(arrayList.size()-1);
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
