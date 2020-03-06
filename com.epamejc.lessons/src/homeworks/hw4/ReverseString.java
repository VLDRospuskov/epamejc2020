package homeworks.hw4;

import java.util.Scanner;

public class ReverseString {

    public static void stringRevert(String inputString) {
        String resultString = "";
        String[] wordsInString = inputString.split(" ");

        for(String word : wordsInString) {
            for (int i = word.length(); i > 0; i--) {
                resultString += word.charAt(i - 1);
            }
            resultString += " ";
        }

        System.out.print(resultString);
    }
}
