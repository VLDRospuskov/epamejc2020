package homeworks.java.hw3.arrays_2;

import static homeworks.java.hw3.utils.Utilities.*;

public class StringGeneratorFromArrayByStrategy {

    public void run() {
        Strategy s = new Strategy();
        int[] numbers = scanNumbers();
        String strategy = s.scanStrategy();
        char[][] arr = buildArray(numbers);
        printArray(arr);
        String output = s.getStrategy(arr, strategy);
        System.out.println("Result: " + output);
    }



}
