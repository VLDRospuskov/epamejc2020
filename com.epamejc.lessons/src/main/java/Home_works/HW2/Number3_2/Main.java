package Home_works.HW2.Number3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String sentence = reader("Write your sentence: ");

        int index = Integer.parseInt(reader("Write index: "));

        char[] strToChar = sentence.toCharArray();

        System.out.println("Result: ");
        System.out.println(strToChar[index]);

    }

    public static String reader(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String srt = null;
        try {
            System.out.println(s);
            srt = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return srt;
    }
}
