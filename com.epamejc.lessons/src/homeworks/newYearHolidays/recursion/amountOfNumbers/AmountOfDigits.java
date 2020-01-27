package homeworks.newYearHolidays.recursion.amountOfNumbers;

import homeworks.utility.helper.Helper;

class AmountOfDigits {

    void run() {
        Helper.showGreetingMessage();

        boolean isRunning = true;
        while (isRunning) {
            String s = Helper.getUserInput("Введите число: ");
            if (s.equals("exit")) {
                isRunning = false;
                continue;
            }

            int input = Helper.parseInt(s);
            int amountOfDigits = getDigits(input);
            System.out.println("Количество знаков в числе: " + amountOfDigits);
            System.out.println("---------------------------------------");
        }
    }

    private int getDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        } else {
            return 1 + getDigits(n / 10);
        }
    }
}
