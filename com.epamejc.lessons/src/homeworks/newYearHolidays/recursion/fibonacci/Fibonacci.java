package homeworks.newYearHolidays.recursion.fibonacci;

import homeworks.utility.helper.Helper;

class Fibonacci {
    void run() {

        Helper.showGreetingMessage();

        boolean isRunning = true;
        while (isRunning) {
            String s = Helper.getUserInput("Введите порядковый номер числа Фибоначчи: ");
            if (s.equals("exit")) {
                isRunning = false;
                continue;
            }

            int input = Math.max(Helper.parseInt(s), 0);
            getAndPrintFibonacci(input);
        }
    }

    private void getAndPrintFibonacci(int input) {
        long startCount = System.currentTimeMillis();
        int number = getFibonacci(input);
        long finishCount = System.currentTimeMillis();

        System.out.println("Значение " + input + " числа Фибоначчи: " + number +
                ". Найдено за " + (finishCount - startCount) + " миллисекунд");
        System.out.println("------------------------------------------------");
    }


    private int getFibonacci(int n) {
        if (n > 50) {
            n = 50;
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
