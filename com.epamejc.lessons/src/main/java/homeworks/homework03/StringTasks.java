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


package homeworks.homework03;

import lombok.Setter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Setter
public class StringTasks {

    private String value;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    private void readString() {

        System.out.print("Enter string: ");
        try {
            value = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 3.1
     * readString() called
     * need to enter mode (even or odd)
     */
    @SneakyThrows
    public String printOddEvenLetters() {

        readString();

        System.out.print("Enter mode (even or odd): ");
        String mode = reader.readLine();

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

        return result;
    }

    /**
     * 3.2
     * readString() called
     * need to enter indexes (int) in loop
     * then print "exit" to get the result
     */
    @SneakyThrows
    public String printStrFromIndexes() {

        readString();

        String result = "";
        System.out.println("Enter index from 1 to " + value.length());
        String input = reader.readLine();
        int index = 0;
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
            input = reader.readLine();
        }
        while (!input.equals("exit"));

        System.out.println("Result is: " + result);
        return result;
        // TODO в названии - принт. Но метод и принтит и возвращает. Это норма?
    }

    /**
     * 3.3
     * readString() called
     * need to enter 2 indexes (int)
     * Indexes start with 0
     */
    @SneakyThrows
    public String swapLetters() {

        readString();

        System.out.println("Enter first index");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Enter second index");
        int b = Integer.parseInt(reader.readLine());

        String result = value.substring(0,a) + value.charAt(b) +
                value.substring(a+1,b) +
                value.charAt(a) + value.substring(b+1);

        System.out.println(result);

        return result;

    }

    /**
     * 3.4
     * readString() called
     */
    public String reverseWords() {

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
        return result;

    }

    private String reverseWord(String str) {

        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
            // TODO: почему выделяется конкатенация в цикле?
        }
        return result;

    }

}

