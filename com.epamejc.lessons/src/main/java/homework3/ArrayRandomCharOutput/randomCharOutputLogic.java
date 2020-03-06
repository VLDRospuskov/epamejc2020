package homework3.ArrayRandomCharOutput;

import java.util.Random;

public class randomCharOutputLogic {


    private boolean IsEven(int num) {
        return num % 2 == 0;
    }

    public String[][] enterRandArr(int height, int width) {
        String[][] arr = new String[height][width];
        Random r = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = String.valueOf((char) (r.nextInt(94) + 33));
            }
        }
        return arr;
    }

    public String applyStrategy(String[][] arr, String typeOfStrategy) {
        int strategyNum = 0;
        int height = arr.length;
        int width = arr[0].length;
        StringBuilder out = new StringBuilder();
        if ((typeOfStrategy.equals("B")) || (typeOfStrategy.equals("b"))) {
            strategyNum = 1;
        }
        for (int i = 0; i < height; i++) {
            if (IsEven(i + strategyNum)) {
                for (int j = 0; j < width; j++) {
                    if (IsEven(j + strategyNum)) {
                        out.append((arr[i][j]));
                    }
                }
            }
        }
        return out.toString();
    }
}
