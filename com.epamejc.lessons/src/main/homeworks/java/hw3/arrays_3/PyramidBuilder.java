package homeworks.java.hw3.arrays_3;

public class PyramidBuilder {

    private final char EX = 'X';

    public char[][] buildPyramid(int n) {
        int nCopy = n;
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nCopy; j++) {
                arr[i][j] = EX;
            }
            nCopy--;
        }

        return arr;
    }

}
