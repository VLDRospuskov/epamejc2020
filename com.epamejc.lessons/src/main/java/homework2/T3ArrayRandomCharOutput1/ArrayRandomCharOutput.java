package homework2.T3ArrayRandomCharOutput1;

import java.util.Random;
import java.util.Scanner;

class ArrayRandomCharOutput {

    private int width = 0;
    private int height = 0;
    private String[][] arr;
    private String typeOfStrategy;

    ArrayRandomCharOutput() {
        this.getWHS();
        this.enterRandArr();
        System.out.println("---");
        this.applyStrategy();

    }

    private void getWHS() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        this.width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");

        this.height = Integer.parseInt(in.nextLine());
        this.arr = new String[this.width][this.height];
        System.out.print("Enter strategy(A or B) ");
        this.typeOfStrategy = (in.nextLine());
    }

    private boolean IsEven(int num) {
        return num % 2 == 0;
    }

    private void enterRandArr() {
        Random r = new Random();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.arr[i][j] = String.valueOf((char) (r.nextInt(94) + 33));
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void applyStrategy() {
        int strategyNum = 0;
        if ((this.typeOfStrategy.equals("B")) || (this.typeOfStrategy.equals("b"))) {
            strategyNum = 1;
        }
        for (int i = 0; i < this.height; i++) {
            if (IsEven(i + strategyNum)) {
                for (int j = 0; j < width; j++) {
                    if (IsEven(j + strategyNum)) {
                        System.out.print((this.arr[i][j]));
                    }
                }
            }
        }
    }
}