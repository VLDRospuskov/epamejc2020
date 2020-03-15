/**
 * 3. Strings
 * 3.1. Написать программу которая генерирует новую строку на основании входных данных, строка + четные/нечетные, пример:
 * Input: String        Input: even        output: tig
 * 3.2. Написать программу которая будет генерировать строку по индексам. Пример:
 * Input: Hello World,
 * input: 0  output: H,
 * input: 4  output: Ho,
 * input: 6 output: HoW
 * 3.3. Поменять местами символы в строке, на вход приходит строка и 2 индекса между, которыми нужно сделать обмен. Пример:
 * Input: Hello World
 * Input: 0, 4
 * output oelloH World
 * 3.4. Написать программу которая переворачивает слова, но при этом оставляет их на прежних местах. Пример
 * Input: Hello World
 * output: olleH dlroW
 */


package homeworks.homework03;

import lombok.Setter;
import lombok.SneakyThrows;

@Setter
public class StringMethods {

    @SneakyThrows
    public String getStringOfOddOrEvenLetters(String value, PrintMode printMode) {
        String result = "";
        int modeInt = printMode.equals(PrintMode.ODD) ? 0 : 1;

        for (int i = modeInt; i < value.length(); i += 2) {
            result += value.charAt(i);
        }

        System.out.println(result);

        return result;
    }

    public Character getCharFromStringAtIndex(String value, int index) {
        if (index < 0 || index >= value.length()) {
            System.out.println("Index out of borders");
            return null;
        } else {
            return value.charAt(index);
        }
    }

    @SneakyThrows
    public String swapLetters(String value, int i, int j) {
        String result = value.substring(0, i) + value.charAt(j) +
                value.substring(i + 1, j) +
                value.charAt(i) + value.substring(j + 1);

        return result;
    }

    public String reverseWords(String value) {
        String result = "";

        int i = 0;
        /**
         * mode - check, what we are looking for right now: letters or signs
         */
        boolean mode = true;

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

        /**
         * add last word
         */
        if (mode) {
            result = result + reverseWord(value.substring(i));
        } else {
            result = result + value.substring(i);
        }

        return result;
    }

    private String reverseWord(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }

}

