package homeworks.hw4;

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

    public static Integer[] getIndices() {
        Scanner in = new Scanner(System.in);
        System.out.println("First index: ");
        Integer firstIndex = in.nextInt();
        System.out.println("Second index: ");
        Integer secondIndex = in.nextInt();

        Integer[] answer = new Integer[2];

        answer[0] = firstIndex;
        answer[1] = secondIndex;

        return answer;
    }

    public static void printResults(String inString, Integer[] indices) {

        Integer firstIndex = indices[0];
        Integer secondIndex = indices[1];


        while (firstIndex > inString.length() || secondIndex > inString.length()) {
            System.out.println("One of the indices is bigger than string's length, please, enter indices again: ");
            indices = getIndices();
            firstIndex = indices[0];
            System.out.println("Second index: ");
            secondIndex = indices[1];
        }

        if (firstIndex > secondIndex) {
            Integer temp = firstIndex;
            firstIndex = secondIndex;
            secondIndex = temp;
        }

        symbolsSwitch(inString, firstIndex, secondIndex);

    }
}
