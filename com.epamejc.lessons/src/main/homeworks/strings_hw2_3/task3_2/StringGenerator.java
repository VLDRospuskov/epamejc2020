package main.homeworks.strings_hw2_3.task3_2;

import java.util.Scanner;

public class StringGenerator {

    public void generate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String sourceString = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        int nextInt;
        do {
            nextInt = inputInt(scanner);
            generateString(sourceString, stringBuffer, nextInt);
        } while (nextInt >= 0);
        scanner.close();
    }

    private void generateString(String sourceString, StringBuffer stringBuffer, int nextInt) {
        if ((nextInt < sourceString.length()) && (nextInt >= 0)) {
            stringBuffer.append(sourceString.charAt(nextInt));
        } else {
            System.out.println("Number is too big or too low");
        }
        System.out.println(stringBuffer.toString());
    }

    private int inputInt(Scanner sc) {
        int nextInt;
        System.out.println("Input char number");
        String stringToInt = sc.nextLine();
        try {
            nextInt = Integer.parseInt(stringToInt);
        } catch (NumberFormatException e1) {
            System.out.println("Use only positive numbers");
            nextInt = -1;
        }
        return nextInt;
    }

}
