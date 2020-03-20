package homeworks.homework02;

import lombok.SneakyThrows;

public class ArrayMethods {

    @SneakyThrows
    public char[][] createRandomLetterCharArray(int rows, int columns) {
        char[][] values = new char[rows][columns];
        // Коды символов строчной латиницы 97-122
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                values[i][j] = (char) (97 + (int) (Math.random() * 26));
            }
        }
        return values;
    }

    public void printCharArray(char[][] values) {
        for (char[] value : values) {
            for (int j = 0; j < value.length; j++) {
                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
    }

    @SneakyThrows
    public String getStringFromCharArrayByStrategy(char[][] values, String strategy) {
        int strategyInt = strategy.equals("A") ? 0 : strategy.equals("B") ? 1 : values.length;

        String result = "";
        for (int i = strategyInt; i < values.length; i += 2) {
            for (int j = strategyInt; j < values[i].length; j += 2) {
                result += values[i][j];
            }
        }

        return result;
    }

    @SneakyThrows
    public char[][] generatePyramid(int size) {
        char[][] Xs = new char[size][];

        for (int i = 0; i < size; i++) {
            Xs[i] = new char[size - i];
            for (int j = 0; j < size - i; j++) {
                Xs[i][j] = 'X';
            }
        }

        return Xs;
    }

}
