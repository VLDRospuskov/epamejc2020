package homeworks;


import homeworks.arrays_hw2_2.task2_1.CharArrayOperation;
import homeworks.arrays_hw2_2.task2_2.ABStrategy;
import homeworks.arrays_hw2_2.task2_3.PyramidArray;
import homeworks.immutableClass_hw2_1.ImmutableClass;
import homeworks.strings_hw2_3.task3_1.OddEvenSubstring;
import homeworks.strings_hw2_3.task3_2.StringGenerator;
import homeworks.trafficLight_hw1.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class RunHomeWorksTasks {


    public String readUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String[] values = argsInput(reader);
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    public static void main(String[] args) {
        RunHomeWorksTasks runHomeWorksTasks = new RunHomeWorksTasks();
        switch (runHomeWorksTasks.readUserInput()) {
            case "1":
                runHomeWorksTasks.calculateColor_Task1();
                break;
            case "2":
                switch (runHomeWorksTasks.readUserInput()) {
                    case "1":
                        char[][] chars = runHomeWorksTasks.getRandomFilledArrayOfArrays();
                        CharArrayOperation charArrayOperation = new CharArrayOperation();
                        charArrayOperation.printTwoDimensionalCharArray(chars);
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                }

                break;
            case "3":

                break;

            default:
                System.out.println("Wrong input");
        }
    }

    /**
     * Homework 1 - TrafficLight
     */
    public void calculateColor_Task1() {
        System.out.println("Введите минуты для рассчета цвета сигнала светофора или пустую строку для выхода из программы");
        String inputStream;
        int minutes = 0;
        TrafficLight trafficLight = new TrafficLight();
        do {
            inputStream = readUserInput();
            if (!inputStream.isEmpty()) {
                try {
                    minutes = Integer.parseInt(inputStream);
                } catch (NumberFormatException e) {
                    System.out.println("Only numbers...");
                    System.out.println("Bye bye");
                    System.out.println("caught " + e.toString());
                    break;
                }
                System.out.println(trafficLight.getColor(minutes));
            }
        } while (!inputStream.isEmpty());
    }

    /**
     * Homework 2. Task 1 - ImmutableClass
     */
    public void runImmutableTask(){
        int[] ints = {1, 2, 3, 4, 5, 6};
        String string = "Igor";
        double aDouble = 3.14;

        ImmutableClass immutableClass = new ImmutableClass(ints, string, aDouble);

        int[] newInts = immutableClass.getAr();
        String newString = immutableClass.getName();
        double newDouble = immutableClass.getDoubleValue();

        for (int i = 0; i < newInts.length - 1; i++) {
            System.out.println(newInts[i]);
        }

        System.out.println("String= " + newString);
        System.out.println("Double= " + newDouble);
    }

    /**
     * Homework 2. Task 2 - Arrays. Subtask 1 - Get random filled char array
     * @return
     */
    public char[][] getRandomFilledArrayOfArrays() {
        int rows = 0;
        int columns = 0;
        char[][] charArray;
        RunHomeWorksTasks runHomeWorksTasks = new RunHomeWorksTasks();
        CharArrayOperation charArrayOperation = new CharArrayOperation();
        String[] values = charArrayOperation.argsInput(runHomeWorksTasks.readUserInput());
        rows = charArrayOperation.getRows(values);
        columns = charArrayOperation.getColumns(values);
        char[][] chars = charArrayOperation.getDeclaredArrayOfArrays(rows, columns);
        CharArrayOperation operation = new CharArrayOperation();
        operation.fillCharsArray(chars);
        return chars;
    }

    /***
     * Homework 2. Task 2 - Arrays. Subtask 2 - Get string from char array, using strategy
     * @param inputArray
     */
    public void selectStrategy22(char[][] inputArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input \"A\" or \"B\" to select specific strategy");
        String inputString = scanner.nextLine();
        scanner.close();
        ABStrategy abStrategy = new ABStrategy();
        switch (inputString.toUpperCase()) {
            case "A":
                abStrategy.useAStrategy(inputArray);
                break;
            case "B":
                abStrategy.useBStrategy(inputArray);
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    /**
     * Homework 2. Task 2 - Arrays. Subtask 3 - Get Pyramid array filled with '*'
     */
    public void createPyramidArray() {
        int levels = 0;
        char[][] chars = {};
        PyramidArray pyramidArray = new PyramidArray();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("Input height");
            levels = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Something wrong with input stream");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format. Only one number is allowed");
            e.printStackTrace();
        }
        if (levels > 0) {
            chars = pyramidArray.initializePyramidArray(levels);
        } else {
            System.out.println("Number must be positive");
        }
        CharArrayOperation operation = new CharArrayOperation();
        operation.printTwoDimensionalCharArray(chars);
    }

    /**
     * Homework 2. Task 3 - Strings. Subtask 1 - generate string using even or odd numbers
     * @return Generated string
     */
    public String useStrategy() {
        System.out.println("Input string to transform");
        //Scanner scanner = new Scanner(System.in);
        RunHomeWorksTasks runHomeWorksTasks = new RunHomeWorksTasks();
        String inputString = runHomeWorksTasks.readUserInput();
        System.out.println("Input \"odd\" or \"even\"");
        String mod = runHomeWorksTasks.readUserInput().toLowerCase();
        OddEvenSubstring oddEvenSubstring = new OddEvenSubstring();
        switch (mod) {
            case "even":
                return oddEvenSubstring.createStringFromEven(inputString);
            case "odd":
                return oddEvenSubstring.createStringFromOdd(inputString);
            default:
                System.out.println("wrong mod input");
                return "";
        }
    }

    public void generate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String sourceString = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        StringGenerator stringGenerator = new StringGenerator();
        int nextInt;
        do {
            nextInt = stringGenerator.inputInt();
            stringGenerator.generateString(sourceString, stringBuffer, nextInt);
        } while (nextInt >= 0);
        scanner.close();
    }
}
