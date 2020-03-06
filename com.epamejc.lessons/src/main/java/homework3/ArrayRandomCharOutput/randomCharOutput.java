package homework3.ArrayRandomCharOutput;

import java.util.Scanner;

class randomCharOutput {

    private int width = 0;
    private int height = 0;
    private String[][] arr;
    private String typeOfStrategy;

    public void run() {
        getWHS();
        randomCharOutputLogic randomCharOutputLogic = new randomCharOutputLogic();
        arr = randomCharOutputLogic.enterRandArr(height, width);
        System.out.println("---");
        System.out.println(randomCharOutputLogic.applyStrategy(arr, typeOfStrategy));
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

}