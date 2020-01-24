package main.homeworks.strings.task3_2;

import java.util.Scanner;

public class StringGenerator {

    public void generate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String sourceString = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        String inputString;
        int nextInt = -1;
        do {
            System.out.println("Input char number");
            inputString = scanner.nextLine();
            try {
                nextInt = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Use only positive numbers");
                nextInt = -1;
            } finally {
                scanner.close();
            }
            if ((nextInt < sourceString.length()) && (nextInt >= 0)) {
                stringBuffer.append(sourceString.charAt(nextInt));
            } else {
                System.out.println("Number is too big or too low");
            }
            System.out.println(stringBuffer.toString());
        } while (!inputString.isEmpty());
    }
}
