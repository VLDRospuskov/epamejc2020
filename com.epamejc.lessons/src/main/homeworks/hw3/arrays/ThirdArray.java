package main.homeworks.hw3.arrays;

import static main.homeworks.hw3.enums.Messages.WARNING_FOR_PARSING_TO_INT;

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
            System.out.println(WARNING_FOR_PARSING_TO_INT);
        }
    }

}
