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
        /*
          mode - check, what we are looking for right now: letters or signs
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

        /*
          add last word
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

