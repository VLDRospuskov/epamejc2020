package homeworks.newYearHolidays.arrays.pyramidX;

import homeworks.utility.helper.Helper;

public class PyramidX {

    public void run() {
        Helper.showGreetingMessage();
        int input = Helper.parseInt(Helper.getUserInput("Введите число: "));

        for (int i = input; i > 0; i--) {
            printX(i);
            System.out.println("");
        }
    }

    private void printX(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("x");
        }
    }
}
