package homeworks.holidaysHW.strings;

import java.util.Scanner;

public class SwitchSymbols {

    public static void symbolsSwitch(String inputString, Integer firstIndex, Integer secondIndex) {
        char symbolAtFirstIndex = inputString.charAt(firstIndex);
        char symbolAtSecondIndex = inputString.charAt(secondIndex);
        String resultString = inputString.substring(0, firstIndex) + symbolAtSecondIndex +
                inputString.substring(firstIndex + 1, secondIndex) + symbolAtFirstIndex +
                inputString.substring(secondIndex + 1, inputString.length());

        System.out.print(resultString);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string: ");
        String inString = in.nextLine();
        System.out.println("First index: ");
        Integer firstIndex = in.nextInt();
        System.out.println("Second index: ");
        Integer secondIndex = in.nextInt();

        while (firstIndex > inString.length() || secondIndex > inString.length()) {
            System.out.println("One of the indices is bigger than string's length, please indices again: ");
            System.out.println("First index: ");
            firstIndex = in.nextInt();
            System.out.println("Second index: ");
            secondIndex = in.nextInt();
        }

        if (firstIndex > secondIndex) {
            Integer temp = firstIndex;
            firstIndex = secondIndex;
            secondIndex = temp;
        }

        symbolsSwitch(inString, firstIndex, secondIndex);

    }
}
