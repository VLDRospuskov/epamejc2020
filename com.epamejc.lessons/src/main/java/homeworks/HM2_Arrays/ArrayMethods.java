/**
 * 2.1. Создать массив массивов, задается размерность, на основании которой генерируются случайные символы типа char
 * 2.2 Сгенерировать массив массивов указав размерность, заполнить его случайными символами.
 * Написать 2 стратегии, которые будут формировать строку на основе данного массива.
 * Стратегия А - работает по принципу *_*_*, а стратегия B - работает по принципу _*_*_
 */

package homeworks.HM2_Arrays;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayMethods {
    private int rows;
    private int columns;
    private char[][] values;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    /**
     * 2.1
     */
    @SneakyThrows
    public void createArray() {
        System.out.println("Enter rows:");
        rows = Integer.parseInt(reader.readLine());
        System.out.println("Enter columns:");
        columns = Integer.parseInt(reader.readLine());
        // TODO если использовать reader лучше, то как быстро спарсить строчку в инты?
        values = new char[rows][columns];

        // Коды символов строчной латиницы 97-122
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                values[i][j] = (char) (97 + (int)(Math.random() * 26));
            }
        }

    }

    public void printArray() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 2.2
     */
    @SneakyThrows
    public void printWithStrategy() {
        /**
         *     public void printSomeValues(char[][] values) {
         *     int rows = values.length;
         *     int columns = rows > 0 ? values[0].length : 0;
         *     TODO ^ лишние строки после рефактора?
         */
        System.out.println("Enter strategy: A or B");
        String modeStr = "";

        modeStr = reader.readLine();

        int modeInt;
        if (modeStr.equals("A")) modeInt = 0;
        else if (modeStr.equals("B")) modeInt = 1;
        else {
            System.out.println("Incorrect value");
            return;
        }

        String result = "";
        for (int i = modeInt; i < rows; i+=2) {
            for (int j = modeInt; j < columns; j+=2) {
                result += values[i][j];
            }
        }

        System.out.println(result);
    }

    /** TODO question
     * Как тестировать?
     * Если принимать int, то где его ввести с консоли?
     * Если перегружать метод, то будет 2 практически одинаковых.
     */
    @SneakyThrows
    public void printPyramid() {
        System.out.println("Enter int value:");
        int size = Integer.parseInt(reader.readLine());

        char[][] Xs = new char[size][];
        for (int i = 0; i < size; i++) {
            Xs[i] = new char[size-i];
            for (int j = 0; j < size-i; j++) {
                Xs[i][j] = 'X';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i; j++) {
                System.out.print(Xs[i][j]);
            }
            System.out.println();
        }
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

}
