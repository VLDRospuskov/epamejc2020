package homeworks.java.hw3.arrays_2;

import static homeworks.java.hw3.utils.Utilities.*;

public class StringGeneratorFromArrayByStrategy {

    public void run() {
        Strategy strategyLogic = new Strategy();
        int[] numbers = scanNumbers();
        String strategy = strategyLogic.scanStrategy();
        char[][] arr = buildArray(numbers);
        printArray(arr);
        String output = strategyLogic.getStrategy(arr, strategy);
        System.out.println("\nResult: " + output);
    }



}
