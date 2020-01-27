package homeworks.newYearHolidays.arrays.randomChars;

import homeworks.utility.helper.Helper;

import java.util.Arrays;

public class RandomChars {

    public void run() {
        int amount = Helper.parseInt(Helper.getUserInput("Введите количество массивов: "));
        int length = Helper.parseInt(Helper.getUserInput("Введите длину массивов: "));

        char[][] charArrays = fillWithRandomChars(new char[amount][length]);
        printTable(charArrays);

        String strategy = Helper.getUserInput("Введите стратегию: ");
        printFormattedString(charArrays, strategy);
        Helper.closeReader();
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

    private void printTable(char[][] charArrays) {
        for (char[] chars : charArrays) {
            System.out.println(Arrays.toString(chars));
        }
    }

    private void printFormattedString(char[][] charArrays, String strategy) {
        String evenChars = "";
        String oddChars = "";

        for (char[] chars : charArrays) {
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    oddChars += chars[i];
                } else {
                    evenChars += chars[i];
                }
            }
        }

        String result = getEvenOrOddChars(evenChars, oddChars, strategy);
        System.out.println(result);
    }

    private String getEvenOrOddChars(String evenChars, String oddChars, String strategy) {
        String result;

        if (strategy.equalsIgnoreCase("a")) {
            result = oddChars;
        } else if (strategy.equalsIgnoreCase("b")) {
            result = evenChars;
        } else {
            System.out.println("Стратегия выбрана неверно!");
            String strategy2 = Helper.getUserInput("Введите стратегию: ");
            result = getEvenOrOddChars(evenChars, oddChars, strategy2);
        }

        return result;
    }
}
