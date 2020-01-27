package homeworks.newYearHolidays.arrays.randomChars;

import homeworks.utility.helper.Helper;

import java.util.Arrays;

public class RandomChars {

    public void run() {
        Helper.showGreetingMessage();
        int amount = Helper.parseInt(Helper.getUserInput("Введите количество массивов: "));
        int length = Helper.parseInt(Helper.getUserInput("Введите длину массивов: "));

        char [][] charArrays = fillWithRandomChars(new char[amount][length]);

        printCharArrays(charArrays);
    }

    private char [][] fillWithRandomChars(char[][] charArrays) {
        for (char [] chars: charArrays) {
            for (int i = 0; i < chars.length; i++){
                chars[i] = getRandomChar();
            }
        }
        return charArrays;
    }

    private char getRandomChar() {
        int randomNumberFrom26 = (int) (Math.random() * 26);
        return (char) ('a' + randomNumberFrom26);
    }

    private void printCharArrays(char [][] charArrays) {
        for (char [] chars: charArrays) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
