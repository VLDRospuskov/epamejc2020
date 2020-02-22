/**
 *         3. Strings
 *         3.1. Написать программу которая генерирует новую строку на основании входных данных, строка + четные/нечетные, пример:
 *         Input: String        Input: even        output: tig
 *         3.2. Написать программу которая будет генерировать строку по индексам. Пример:
 *         Input: Hello World,
 *         input: 0  output: H,
 *         input: 4  output: Ho,
 *         input: 6 output: HoW
 *         3.3. Поменять местами символы в строке, на вход приходит строка и 2 индекса между, которыми нужно сделать обмен. Пример:
 *         Input: Hello World
 *         Input: 0, 4
 *         output oelloH World
 *         3.4. Написать программу которая переворачивает слова, но при этом оставляет их на прежних местах. Пример
 *         Input: Hello World
 *         output: olleH dlroW
 */


package homeworks.java.HM3_Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringTasks {
    public static void main(String[] args) {
        StringTasks stringTasks = new StringTasks();
        //stringTasks.printOddEvenLetters();
        //stringTasks.printStrFromIndexes();
        //stringTasks.swapLetters();
        stringTasks.reverseWords();
    }

    private static String value;

    private void readString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter string: ");
        try {
            value = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 3.1
     */
    public void printOddEvenLetters() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mode (even or odd): ");
        String mode = sc.nextLine();

        String result = "";
        int modeInt;
        if (mode.equals("odd")) {
            modeInt = 0;
        } else if (mode.equals("even")) {
            modeInt = 1;
        } else {
            modeInt=value.length();
            System.out.println("Wrong mode!");
        }

        for (int i = modeInt; i < value.length(); i+=2) {
            result += value.charAt(i);
        }

        System.out.println(result);
    }

    /**
     * 3.2
     */
    public void printStrFromIndexes() {
        readString();
        Scanner sc = new Scanner(System.in);

        String result = "";
        System.out.println("Enter index from 1 to " + value.length());
        String input = sc.nextLine();// = sc.nextLine();;
        int index = 0;
        //input = sc.nextLine();
        do {
            boolean error = false;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a number or exit!");
                error = true;
            }
            if (!error) {
                if (index < 1 || index > value.length()) {
                    System.out.println("Index out of borders");
                } else {
                    result += value.charAt(index - 1);
                }
            }
            System.out.print("Enter index or exit: ");
            input = sc.nextLine();
        }
        while (!input.equals("exit"));

        System.out.println("Result is: " + result);
    }

    /**
     * 3.3
     */
    public void swapLetters() {
        readString();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(value.substring(0,a) + value.charAt(b) + value.substring(a+1,b) + value.charAt(a) + value.substring(b+1));
    }

    /**
     * 3.4
     */
    public void reverseWords() {
        readString();

        String result = "";

        int i = 0;
        boolean mode = true; // check, what we are looking for right now: letters or signs

        for (int j = 0; j < value.length(); j++) {
            if (mode) {
                if (!Character.isLetterOrDigit(value.charAt(j))) {
                    result = result + reverseWord(value.substring(i, j));
                    i = j;
                    mode ^= true;
                }
            } else {
                if (Character.isLetterOrDigit(value.charAt(j))) {
                    result = result + value.substring(i, j);
                    i = j;
                    mode ^= true;
                }
            }
        }

        if (mode) { // add last word
            result = result + reverseWord(value.substring(i));
        } else {
            result = result + value.substring(i);
        }

        System.out.println(result);
    }

    public static String reverseWord(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
            // TODO: почему выделяется конкатенация в цикле?
        }
        return result;
    }

}

