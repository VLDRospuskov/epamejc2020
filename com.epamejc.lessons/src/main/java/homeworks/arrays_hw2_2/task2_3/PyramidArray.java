package homeworks.arrays_hw2_2.task2_3;

import homeworks.arrays_hw2_2.task2_1.CharArrayOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PyramidArray {

//    public void createPyramidArray() {
//        int levels = 0;
//        char[][] chars = {};
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
//            System.out.println("Input height");
//            levels = Integer.parseInt(reader.readLine());
//        } catch (IOException e) {
//            System.out.println("Something wrong with input stream");
//            e.printStackTrace();
//        } catch (NumberFormatException e) {
//            System.out.println("Wrong number format. Only one number is allowed");
//            e.printStackTrace();
//        }
//        if (levels > 0) {
//            chars = initializePyramidArray(levels);
//        } else {
//            System.out.println("Number must be positive");
//        }
//        CharArrayOperation operation = new CharArrayOperation();
//        operation.printTwoDimensionalCharArray(chars);
//    }

    public char[][] declarePyramidArray(int n) {
        char[][] pyramid = new char[n][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramid[i] = new char[pyramid.length - i];
        }
        return pyramid;
    }

    public char[][] initializePyramidArray(int n) {
        char[][] pyramid;
        pyramid = declarePyramidArray(n);
        for (char[] chars : pyramid) {
            Arrays.fill(chars, '*');
        }
        return pyramid;
    }

}
