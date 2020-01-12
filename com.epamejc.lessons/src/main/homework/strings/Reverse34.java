package homework.strings;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Reverse34 {
    public static void main(String[] args) {
        MainTemplate.main(Reverse34::reverse);
    }

    public static String reverseStr(String s){
        char[] chstr = s.toCharArray();

        for(int i=0; i<chstr.length/2; i++){
            char temp = chstr[i];
            chstr[i] = chstr[chstr.length -i -1];
            chstr[chstr.length -i -1] = temp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(chstr);
        return sb.toString();
    }
    public static String reverse(BufferedReader reader) {
        try {
            System.out.println("Введите строку: ");
            String str = reader.readLine();
            String[] arrStr = str.split(" ");



            for (int i = 0; i <arrStr.length; i++){
                arrStr[i] = reverseStr(arrStr[i]);
            }

            return String.join(" ", arrStr);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return reverse(reader);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println(e);
            return reverse(reader);
        }
    }

}
