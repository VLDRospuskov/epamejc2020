package homework.strings;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class EvenOddString31 {
    public static void main(String... args) {
        MainTemplate.main(EvenOddString31::stringX);
    }

    public static String stringX(BufferedReader reader) {
        try {
            System.out.println("Введите строку:");
            String inputStr = reader.readLine();
            System.out.println("Введите even или odd:");
            String inputPar = reader.readLine().toLowerCase();
            StringBuilder inputString = new StringBuilder(inputStr);

            switch (inputPar) {
                case "even":
                    for (int i = 0; i < inputString.length(); i++) {
                        inputString.deleteCharAt(i);
                    }
                    return inputString.toString();
                case "odd":
                    for (int i = 1; i < inputString.length(); i++) {
                        inputString.deleteCharAt(i);
                    }
                    return inputString.toString();
                default:
                    System.err.println("Please input \"even\" or \"odd\"");
                    return stringX(reader);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return stringX(reader);
        }
    }
}