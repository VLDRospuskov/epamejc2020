package homework3.ArrayRandomCharOutput;

import java.util.Scanner;

class randomCharOutput {

    private int width = 0;
    private int height = 0;
    private String[][] arr;
    private int typeOfStrategy;

    public void run() {
        getWidthHeightStrategy();
        randomCharOutputLogic randomCharOutputLogic = new randomCharOutputLogic();
        arr = randomCharOutputLogic.enterRandArr(height, width);
        System.out.println("---");
        System.out.println(randomCharOutputLogic.applyStrategy(arr, typeOfStrategy-1));
    }

    private void getWidthHeightStrategy() {
        width = readCom("Enter width ");
        height = readCom("Enter height ");
        arr = new String[width][height];
        typeOfStrategy = readCom("Enter strategy(1 or 2) ");
    }

    private int readCom(String text) {
        boolean t;
        int command = 0;
        do {
            try {
                System.out.print(text);
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t = false;
            } catch (Exception e) {
                t = true;
                System.out.println("Input Error.");
            }
        } while (t);
        return command;
    }
}