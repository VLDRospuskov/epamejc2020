package homeworks.homework2.arrays.task2_1;


public class CharArrayOperation {

    public void printTwoDimensionalCharArray(char[][] charArray) {
        for (char[] arr : charArray) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public char[][] getRandomFilledArrayOfArrays(String arg) {
        String[] params = argsInput(arg);
        int rows = getRows(params);
        int columns = getColumns(params);
        char[][] chars = getDeclaredArrayOfArrays(rows, columns);
        fillCharsArray(chars);
        return chars;
    }

    public char[][] getRandomFilledArrayOfArrays(int rows, int columns) {
        char[][] chars = getDeclaredArrayOfArrays(rows, columns);
        fillCharsArray(chars);
        return chars;
    }

    private char[][] getDeclaredArrayOfArrays(int rows, int columns) {
        if ((rows > 0) && (columns > 0)) {
            return new char[rows][columns];
        } else {
            System.out.println("Need TWO positives numbers");
            return new char[0][0];
        }
    }

    private void fillCharsArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                charArray[i][j] = (char) (Math.random() * 26 + 'a');
            }
        }
    }

    private int getRows(String[] stringToParse) {
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

    private int getColumns(String[] stringToParse) {
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

    private String[] argsInput(String s) {
        return s.split(" ");
    }

}
