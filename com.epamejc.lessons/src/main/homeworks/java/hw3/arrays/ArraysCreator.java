package homeworks.java.hw3.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homeworks.java.hw3.enums.Messages.*;

public class ArraysCreator {

    public char[][] makeRandomCharsArray(BufferedReader buffer) {
        System.out.println(FIRST_TASK_ENTER_MESSAGE);

        try {
            String line1 = buffer.readLine();
            String line2 = buffer.readLine();

            FirstArray firstArray = new FirstArray();
            return firstArray.getCharsArray(line1, line2);

        } catch (Exception e) {
            System.out.println(FIRST_TASK_EXECUTING_EXCEPTION);
        }
        return null;
    }

    public String outputInDifferentStrategies(BufferedReader buffer) {
        System.out.println(SECOND_TASK_ENTER_MESSAGE);

        try {
            String size = buffer.readLine();
            String strategy = buffer.readLine();

            SecondArray secondArray = new SecondArray();

            if (strategy.equalsIgnoreCase("A")) {
                return secondArray.strategyAOutput(size);
            } else if (strategy.equalsIgnoreCase("B")) {
                return secondArray.strategyBOutput(size);
            } else {
                System.out.println(OUTPUT_STRATEGY_CHOOSE_WARNING);
            }

        } catch (Exception e) {
            System.out.println(SECOND_TASK_EXECUTING_EXCEPTION);
        }
        return null;
    }

    public String[][] makePyramid(BufferedReader buffer) {
        System.out.println(THIRD_TASK_ENTER_MESSAGE);

        try {
            String lines = buffer.readLine();
            String ch = buffer.readLine();

            ThirdArray thirdArray = new ThirdArray();
            return thirdArray.fullPyramid(lines, ch);

        } catch (Exception e) {
            System.out.println(THIRD_TASK_EXECUTING_EXCEPTION);
        }
        return null;
    }

    public void run() {
        System.out.println(ARRAYS_ENTER_MESSAGE);

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String task = buffer.readLine();
            int taskNumber = Integer.parseInt(task);

            if (taskNumber == 1) {
                makeRandomCharsArray(buffer);
            } else if (taskNumber == 2) {
                outputInDifferentStrategies(buffer);
            } else if (taskNumber == 3) {
                makePyramid(buffer);
            } else {
                System.out.println(WARNING_FOR_TASK_NUMBER_INPUT);
            }

        } catch (IOException e) {
            System.out.println(WARNING_FOR_PARSING_TO_INT + "\n" +
                    WARNING_FOR_TASK_NUMBER_INPUT);
        }
    }

}
