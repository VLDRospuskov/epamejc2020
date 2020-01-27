package homeworks.newYearHolidays.arrays.pyramidX;

import homeworks.utility.helper.Helper;

public class PyramidX {

    public void run() {
        int input = Helper.parseInt(Helper.getUserInput("Введите число: "));
        printPyramidX(input);
        Helper.closeReader();
    }

    private void printPyramidX(int n) {
        for (int i = n; i > 0; i--) {
            printLineX(i);
            System.out.println(" ");
        }
    }

    private void printLineX(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("x");
        }
    }
}
