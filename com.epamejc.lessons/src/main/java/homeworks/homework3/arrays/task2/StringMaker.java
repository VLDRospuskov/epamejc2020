package homeworks.homework3.arrays.task2;

import java.util.Scanner;

public class StringMaker {

    private Scanner sc;
    private char[][] array;

    public StringMaker(Scanner sc, char[][] array) {
        this.sc = sc;
        this.array = array;
    }

    public void pickStrategy() {
        String strategy = sc.nextLine();
        switch (strategy) {
            case "A":
                makeStringA(array);
                break;
            case "B":
                makeStringB(array);
                break;
            default:
                System.out.println("Unknown strategy");
                break;
        }
    }

    private void makeStringA(char[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i += 2) {
            for (int j = 0; j < array[i].length; j += 2) {
                result.append(array[i][j]);
            }
        }
        System.out.println(result);
    }

    private void makeStringB(char[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < array.length; i += 2) {
            for (int j = 1; j < array[i].length; j += 2) {
                result.append(array[i][j]);
            }
        }
        System.out.println(result);
    }
}
