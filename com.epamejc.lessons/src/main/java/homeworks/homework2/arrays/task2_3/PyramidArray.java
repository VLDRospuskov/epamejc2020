package homeworks.homework2.arrays.task2_3;

import java.util.Arrays;

public class PyramidArray {

    public char[][] initializePyramidArray(int n) {
        char[][] pyramid;
        pyramid = declarePyramidArray(n);
        for (char[] chars : pyramid) {
            Arrays.fill(chars, '*');
        }
        return pyramid;
    }

    private char[][] declarePyramidArray(int n) {
        char[][] pyramid = new char[n][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramid[i] = new char[pyramid.length - i];
        }
        return pyramid;
    }

}
