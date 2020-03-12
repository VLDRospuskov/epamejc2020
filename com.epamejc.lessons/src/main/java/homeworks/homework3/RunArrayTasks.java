package homeworks.homework3;

import homeworks.InputReader;
import homeworks.homework3.task2_1.CharArrayOperation;
import homeworks.homework3.task2_2.ABStrategy;
import homeworks.homework3.task2_3.PyramidArray;

public class RunArrayTasks {
    
    public static void main(String[] args) {
        System.out.println("Input task number from 1 to 3");
        String task = InputReader.nextString();
        CharArrayOperation operation = new CharArrayOperation();
        char[][] chars;
        int rows;
        int columns;
        switch (task) {
            case "1":
                System.out.println("Insert rows and columns amount");
                System.out.println("For example:");
                System.out.println("5 3");
                String nextString = InputReader.nextString();
                chars = operation.getRandomFilledArrayOfArrays(nextString);
                operation.printTwoDimensionalCharArray(chars);
                break;
            case "2":
                System.out.println("Input rows");
                rows = InputReader.nextInt();
                System.out.println("Input columns");
                columns = InputReader.nextInt();
                chars = operation.getRandomFilledArrayOfArrays(rows, columns);
                operation.printTwoDimensionalCharArray(chars);
                ABStrategy strategy = new ABStrategy();
                System.out.println("Input \"A\" or \"B\" to select specific strategy");
                String str = InputReader.nextString();
                System.out.println(strategy.selectStrategy(chars, str));
                break;
            case "3":
                PyramidArray pyramidArray = new PyramidArray();
                System.out.println("Input height of pyramid");
                rows = InputReader.nextInt();
                chars = pyramidArray.initializePyramidArray(rows);
                operation.printTwoDimensionalCharArray(chars);
                break;
        }
    }
    
}
