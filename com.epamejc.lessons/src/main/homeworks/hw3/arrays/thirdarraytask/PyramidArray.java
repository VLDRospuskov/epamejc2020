package main.homeworks.hw3.arrays.thirdarraytask;

class PyramidArray {

    static char[][] makePyramid(int n) {
        char[][] pyramid = new char[n][];

        for (int i = 0; i < n; i++) {
            pyramid[i] = new char[n - i];
        }
        return pyramid;
    }

    static void fullPyramid(char[][] array, char var) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = var;
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
