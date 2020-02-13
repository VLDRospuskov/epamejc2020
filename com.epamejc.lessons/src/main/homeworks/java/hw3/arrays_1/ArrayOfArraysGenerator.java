package homeworks.java.hw3.arrays_1;

import static homeworks.java.hw3.utils.Utilities.*;

public class ArrayOfArraysGenerator {

    public void run() {
        int[] numbers = scanNumbers();
        char[][] arr = buildArray(numbers);
        printArray(arr);
    }

}
