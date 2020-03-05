package homework2.ArrayRandomCharOutput;

import java.util.Random;
import java.util.Scanner;

class ArrayRandomCharOutput {

    private int width = 0;
    private int height = 0;
    private String[][] arr;
    private String typeOfStrategy;

    public void run() {
        getWHS();
        enterRandArr();
        System.out.println("---");
        applyStrategy();

    }

    private void getWHS() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");

        height = Integer.parseInt(in.nextLine());
        arr = new String[width][height];
        System.out.print("Enter strategy(A or B) ");
        typeOfStrategy = (in.nextLine());
    }

    private boolean IsEven(int num) {
        return num % 2 == 0;
    }

    private void enterRandArr() {
        Random r = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = String.valueOf((char) (r.nextInt(94) + 33));
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void applyStrategy() {
        int strategyNum = 0;
        if ((typeOfStrategy.equals("B")) || (typeOfStrategy.equals("b"))) {
            strategyNum = 1;
        }
        for (int i = 0; i < height; i++) {
            if (IsEven(i + strategyNum)) {
                for (int j = 0; j < width; j++) {
                    if (IsEven(j + strategyNum)) {
                        System.out.print((arr[i][j]));
                    }
                }
            }
        }
    }
}