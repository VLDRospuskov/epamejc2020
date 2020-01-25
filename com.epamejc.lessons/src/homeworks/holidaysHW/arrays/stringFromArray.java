package homeworks.holidaysHW.arrays;

import java.util.Scanner;

public class stringFromArray {

    public static void getStringFromArray(int x, int y) {

        char[][] charArray = new char[x][y];
        // using method from previous task
        charArray = randomCharArray.randomizeCharArray(x, y);
        String strategyChar;
        System.out.println("Input strategy: ");
        Scanner in = new Scanner(System.in);
        String resultString = "";
        strategyChar = "";

        while (!strategyChar.equals("A") && !strategyChar.equals("B")) {
            strategyChar = in.nextLine();
            switch (strategyChar) {
                case ("A"):
                    for (int i = 0; i < x; i += 2) {
                        for (int j = 0; j < y; j += 2) {
                            resultString = resultString + charArray[i][j];
                        }
                    }
                    break;
                case ("B"):
                    for (int i = 1; i < x; i += 2) {
                        for (int j = 1; j < y; j += 2) {
                            resultString = resultString + charArray[i][j];
                        }
                    }
                    break;
                default:
                    System.out.println("Type A or B");
                    break;
            }
        }

        System.out.println(resultString);

    }

    public static void main(String[] args) {
        getStringFromArray(5, 6);
    }
}
