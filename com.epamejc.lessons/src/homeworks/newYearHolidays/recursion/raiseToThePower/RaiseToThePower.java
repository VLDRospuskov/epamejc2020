package homeworks.newYearHolidays.recursion.raiseToThePower;

import homeworks.utility.helper.Helper;

class RaiseToThePower {

    void run() {
        Helper.showGreetingMessage();

        boolean isRunning = true;
        while (isRunning) {
            String s1 = Helper.getUserInput("Введите число: ");
            if (s1.equals("exit")) {
                isRunning = false;
                continue;
            }

            String s2 = Helper.getUserInput("Введите степень: ");
            if (s2.equals("exit")) {
                isRunning = false;
                continue;
            }

            int number = Math.max(Helper.parseInt(s1), 0);
            int row = Math.max(Helper.parseInt(s2), 0);

            getAndPrintPowerOfNumber(number, row);
        }
    }

    private void getAndPrintPowerOfNumber(int number, int row) {
        if (number == 0 && row == 0) {
            System.out.println("Недопустимая операция (0 в степени 0). Попробуйте снова.");
        } else {
            int result = getPowerOfNumber(number, row);

            System.out.println("Число " + number + " в степени " + row +
                    " равно " + result);
        }

        System.out.println("------------------------------------------");
    }

    private static int getPowerOfNumber(int n, int p) {
        if (p == 0) {
            return 1;
        } else if (p == 1) {
            return n;
        } else {
            return n * getPowerOfNumber(n, p - 1);
        }
    }
}
