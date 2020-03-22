package homework3.ArrayRandomCharOutput;

import java.util.Random;

class randomCharOutputLogic {

    String[][] enterRandArr(int height, int width) {
        String[][] arr = new String[height][width];
        Random r = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = String.valueOf((char) (r.nextInt(94) + 33));
            }
        }
        return arr;
    }

    String applyStrategy(String[][] arr, int typeOfStrategy) {

        int height = arr.length;
        int width = arr[0].length;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < height; i++) {
            if (IsEven(i + typeOfStrategy)) {
                for (int j = 0; j < width; j++) {
                    if (IsEven(j + typeOfStrategy)) {
                        out.append((arr[i][j]));
                    }
                }
            }
        }
        return out.toString();
    }

    private boolean IsEven(int num) {
        return num % 2 == 0;
    }
}
