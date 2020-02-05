package main.homeworks.hw3.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class FirstArray {

    void getCharsArray(String inLines, String inColumns) {
        try {
            int lines = Integer.parseInt(inLines);
            int columns = Integer.parseInt(inColumns);

            char[][] charArray = new char[lines][columns];

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    Random r = new Random();
                    charArray[i][j] = (char) (r.nextInt(26) + 'a');
                    System.out.print(charArray[i][j]);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Exception while parsing string from buffer to integer. You have to input only " +
                    "a positive numbers");
        }
    }

}

class SecondArray {

    private char[][] getCharsArray(int n) {
        char[][] charArray = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                charArray[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return charArray;
    }

    void strategyAOutput(String in) {
        try {
            int n = Integer.parseInt(in);

            char[][] charArray = getCharsArray(n);

            System.out.println("Strategy A output");
            for (int i = 0; i < charArray.length; ) {
                for (int j = 0; j < charArray[0].length; ) {
                    System.out.print(charArray[i][j]);
                    j = j + 2;
                }
                i = i + 2;
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Exception while parsing string from buffer to integer. You have to input only " +
                    "a positive numbers");
        }
    }

    void strategyBOutput(String in) {
        try {
            int n = Integer.parseInt(in);

            char[][] arrayB = getCharsArray(n);

            System.out.println("Strategy B output");

            for (int i = 1; i < arrayB.length; ) {
                for (int j = 1; j < arrayB.length; ) {
                    System.out.print(arrayB[i][j]);
                    j = j + 2;
                }
                i = i + 2;
            }
            System.out.println("\n");

        } catch (Exception e) {
            System.out.println("Exception while parsing string from buffer to integer. You have to input only " +
                    "a positive numbers");
        }
    }
}

class ThirdArray {

    private String[][] makePyramid(int n) {
        String[][] pyramid = new String[n][];

        for (int i = 0; i < n; i++) {
            pyramid[i] = new String[n - i];
        }
        return pyramid;
    }

    void fullPyramid(String lines, String var) {
        try {
            int numOfLines = Integer.parseInt(lines);
            String[][] array = makePyramid(numOfLines);

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = var;
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Exception while parsing string from buffer to integer. You have to input only" +
                    "a positive number for number of lines in pyramid");
        }
    }

}

class Mains {

    void main1(BufferedReader buffer) {
        System.out.println("Input number of lines, press enter, input number of columns and press enter again");

        try {
            String line1 = buffer.readLine();
            String line2 = buffer.readLine();

            FirstArray firstArray = new FirstArray();
            firstArray.getCharsArray(line1, line2);

        } catch (Exception e) {
            System.out.println("Exception while executing 1st task");
        }

    }

    void main2(BufferedReader buffer) {
        System.out.println("Input a size of the array, press enter, then choose an input strategy " +
                "and press enter again");
        System.out.println("Input an outputting strategy: \n" +
                "A - is a *_*_* principle\nB - is a _*_*_ principle\n");

        try {
            String size = buffer.readLine();
            String strategy = buffer.readLine();

            SecondArray secondArray = new SecondArray();

            if (strategy.equalsIgnoreCase("A")) {
                secondArray.strategyAOutput(size);
            } else if (strategy.equalsIgnoreCase("B")) {
                secondArray.strategyBOutput(size);
            } else {
                System.out.println("You have to put A or B when choosing strategy");
            }

        } catch (Exception e) {
            System.out.println("Exception while executing 2nd task");
        }


    }

    void main3(BufferedReader buffer) {
        System.out.println("Input number of pyramids lines. Press enter.\n" +
                "Then input char to full pyramid by it. Press enter");

        try {
            String lines = buffer.readLine();
            String ch = buffer.readLine();

            ThirdArray thirdArray = new ThirdArray();
            thirdArray.fullPyramid(lines, ch);

        } catch (Exception e) {
            System.out.println("Exception while executing 3rd task");
        }
    }

    void run() {
        System.out.println("Input 1, 2 or 3 to choose the program and press enter.\n" +
                "1 - array maker with random chars inside\n" +
                "2 - square array maker with random chars inside and two types of outputting: " +
                "like *_*_* or like _*_*_ \n" +
                "3 - pyramid maker.");

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String task = buffer.readLine();
            int taskNumber = Integer.parseInt(task);

            if (taskNumber == 1) {
                main1(buffer);
            } else if (taskNumber == 2) {
                main2(buffer);
            } else if (taskNumber == 3) {
                main3(buffer);
            } else {
                System.out.println("You have to put 1, 2 or 3 for choosing the task number");
            }

        } catch (IOException e) {
            System.out.println("Exception while parsing task number to integer." +
                    "You have to input only 1, 2 or 3 to choose a program");
        }
    }

}
