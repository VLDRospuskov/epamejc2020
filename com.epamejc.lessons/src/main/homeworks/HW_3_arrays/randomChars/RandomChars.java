package homeworks.HW_3_arrays.randomChars;

import homeworks.utility.helper.Helper;

import java.util.Arrays;

public class RandomChars {

    private int amount;
    private int length;
    private String strategy;

    public void run() {
        System.out.println(Helper.GREETING);
        getUserInputs();
        char[][] charArrays = fillWithRandomChars(new char[amount][length]);
        printCharTable(charArrays);
        printFormattedString(charArrays, strategy);
    }

    private void getUserInputs() {
        amount = Helper.getIntSilently("Write down amount of arrays: ");
        length = Helper.getIntSilently("Write down the length of arrays: ");
        strategy = Helper.getStringSilently("Write down the strategy: ");
        Helper.closeReaderSilently();
    }


    private char[][] fillWithRandomChars(char[][] charArrays) {
        for (char[] chars : charArrays) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = getRandomChar();
            }
        }
        return charArrays;
    }

    private char getRandomChar() {
        int randomNumberFrom26 = (int) (Math.random() * 26);
        return (char) ('a' + randomNumberFrom26);
    }

    private void printCharTable(char[][] charArrays) {
        for (char[] chars : charArrays) {
            System.out.println(Arrays.toString(chars));
        }
    }

    private void printFormattedString(char[][] charArrays, String strategy) {
        StringBuilder evenChars = new StringBuilder();
        StringBuilder oddChars = new StringBuilder();

        for (char[] chars : charArrays) {
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    oddChars.append(chars[i]);
                } else {
                    evenChars.append(chars[i]);
                }
            }
        }

        String result = getEvenOrOddChars(evenChars.toString(), oddChars.toString(), strategy);
        System.out.println(result);
    }

    private String getEvenOrOddChars(String evenChars, String oddChars, String strategy) {
        String result;

        if (strategy.equalsIgnoreCase("a")) {
            result = oddChars;
        } else if (strategy.equalsIgnoreCase("b")) {
            result = evenChars;
        } else {
            String strategy2 = Helper.getStringSilently("Wrong character! Try again: ");
            result = getEvenOrOddChars(evenChars, oddChars, strategy2);
        }

        return result;
    }

}
