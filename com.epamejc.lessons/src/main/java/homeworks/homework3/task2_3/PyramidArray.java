package homeworks.homework3.task2_3;

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
        if (n < 0) {
            n = 0;
            System.out.println("Only positive number");
        }
        char[][] pyramid = new char[n][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramid[i] = new char[pyramid.length - i];
        }
        return pyramid;
    }
    
}
