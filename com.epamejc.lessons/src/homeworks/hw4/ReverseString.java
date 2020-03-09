package homeworks.hw4;

import java.util.Scanner;

public class ReverseString {

    public static String stringRevert(String inputString) {
        String resultString = "";
        String[] wordsInString = inputString.split(" ");

        int index = 0;
        for(String word : wordsInString) {
            index++;
            for (int i = word.length(); i > 0; i--) {
                resultString += word.charAt(i - 1);
            }
            if (wordsInString.length > 1 && index != wordsInString.length - 1) {
                resultString += " ";
            }
        }

        System.out.print(resultString);
        return resultString;
    }
}
