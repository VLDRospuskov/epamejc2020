package homeworks.homework2.strings;

import homeworks.InputReader;
import homeworks.homework2.strings.task3_1.OddEvenSubstring;
import homeworks.homework2.strings.task3_2.StringGenerator;
import homeworks.homework2.strings.task3_3.SwapSymbols;
import homeworks.homework2.strings.task3_4.ReverseWords;

public class RunStringTasks {

    public static void main(String[] args) {
        String task = InputReader.nextString();
        System.out.println("Input source string");
        System.out.println("Input task number from 1 to 4");
        String inputString = InputReader.nextString();
        switch (task) {
            case "1":
                OddEvenSubstring oddEvenSubstring = new OddEvenSubstring();
                System.out.println(oddEvenSubstring.useStrategy(inputString));
                break;
            case "2":
                StringGenerator stringGenerator = new StringGenerator();
                System.out.println(stringGenerator.collectViaIndex(inputString));
                break;
            case "3":
                SwapSymbols swapSymbols = new SwapSymbols();
                int[] swapNums = swapSymbols.getSwapNumsFromInput();
                System.out.println(swapSymbols.swapCharsInString(swapNums, inputString));
                break;
            case "4":
                ReverseWords reverseWords = new ReverseWords();
                System.out.println(reverseWords.getReversedString(inputString));
                break;
        }
    }

}
