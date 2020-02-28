package homeworks.homework2.arrays;

import homeworks.InputReader;
import homeworks.homework2.arrays.task2_1.CharArrayOperation;
import homeworks.homework2.arrays.task2_2.ABStrategy;
import homeworks.homework2.arrays.task2_3.PyramidArray;

public class RunArrayTasks {

    public static void main(String[] args) {
        System.out.println("Input task number from 1 to 3");
        String task = InputReader.nextString();
        CharArrayOperation operation = new CharArrayOperation();
        char[][] chars;
        switch (task) {
            case "1":
                chars = operation.getRandomFilledArrayOfArrays();
                operation.printTwoDimensionalCharArray(chars);
                break;
            case "2":
                chars = operation.getRandomFilledArrayOfArrays();
                operation.printTwoDimensionalCharArray(chars);
                ABStrategy strategy = new ABStrategy();
                System.out.println(strategy.selectStrategy(chars));
                break;
            case "3":
                PyramidArray pyramidArray = new PyramidArray();
                System.out.println("Input height of pyramid");
                int levels = InputReader.nextInt();
                chars = pyramidArray.initializePyramidArray(levels);
                operation.printTwoDimensionalCharArray(chars);
                break;
        }
    }

}
