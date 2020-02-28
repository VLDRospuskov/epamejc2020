package homeworks.homework2.arrays.task2_1;


import homeworks.InputReader;

public class CharArrayOperation {

    public void printTwoDimensionalCharArray(char[][] charArray) {
        for (char[] arr : charArray) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public char[][] getRandomFilledArrayOfArrays() {
        System.out.println("Insert rows and columns amount");
        System.out.println("For example:");
        System.out.println("5 3");
        String[] values = argsInput(InputReader.nextString());
        int rows = getRows(values);
        int columns = getColumns(values);
        char[][] chars = getDeclaredArrayOfArrays(rows, columns);
        fillCharsArray(chars);
        return chars;
    }

    public int getRows(String[] stringToParse) {
        int rows = 0;
        if (stringToParse.length == 2) {
            try {
                rows = Integer.parseInt(stringToParse[0]);
            } catch (NumberFormatException e) {
                System.err.println("Rows number is wrong");
            }
        } else {
            System.err.println("getRows function:    Wrong input. Two numbers are needed");
        }
        return rows;
    }

    public int getColumns(String[] stringToParse) {
        int columns = 0;
        if (stringToParse.length == 2) {
            try {
                columns = Integer.parseInt(stringToParse[1]);
            } catch (NumberFormatException e) {
                System.err.println("Columns number is wrong");
            }
        } else {
            System.err.println("getColumns function: Wrong input. Two numbers are needed");
        }
        return columns;
    }

    public char[][] getDeclaredArrayOfArrays(int rows, int columns) {
        char[][] charArray;
        if ((rows > 0) && (columns > 0)) {
            charArray = new char[rows][columns];
            return charArray;
        } else {
            charArray = new char[0][0];
            System.err.println("Need TWO positives numbers");
            return charArray;
        }
    }

    public char[][] fillCharsArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                charArray[i][j] = (char) (Math.random() * 26 + 'a');
            }
        }
        return charArray;
    }

    private String[] argsInput(String s) {
        String[] splitString = {};
        splitString = s.split(" ");
        return splitString;
    }

}
