package homework.strings;

import com.sun.org.apache.bcel.internal.generic.RET;
import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Reverse34 {

    public static void main(String[] args) {
        MainTemplate.main(Reverse34::reverse);
    }

    static String reverseStr(String str) {
        char[] aStr = str.toCharArray();

        for (int i = 0; i < aStr.length / 2; i++) {
            char temp = aStr[i];
            aStr[i] = aStr[aStr.length - i - 1];
            aStr[aStr.length - i - 1] = temp;
        }

        return new String(aStr);
    }

    static String reverseCore(String str){
        String[] aStr = str.split(" ");
        for (int i = 0; i < aStr.length; i++) {
            aStr[i] = reverseStr(aStr[i]);
        }

        return String.join(" ", aStr);
    }

    private static String reverse(BufferedReader reader) {
        try {
            System.out.println("Введите строку: ");
            String str = reader.readLine();

            return reverseCore(str);
        } catch (StringIndexOutOfBoundsException | NumberFormatException | IOException e) {
            System.err.println(e.getMessage());
            return reverse(reader);
        }
    }
}
