package main.homeworks.arrays_hw2_2.task2_2;

import main.homeworks.arrays_hw2_2.task2_1.CharArrayOperation;

public class Task2_2 {

    public static void main(String[] args) {
        CharArrayOperation arrayOperation = new CharArrayOperation();
        char[][] chars = arrayOperation.getRandomArrayOfArrays();
        arrayOperation.printArray(chars);
        ABStrategy strategy = new ABStrategy();
        strategy.selectStrategy(chars);
    }
}
