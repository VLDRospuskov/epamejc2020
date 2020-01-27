package homeworks.newYearHolidays.strings.evenOdd;

import homeworks.utility.helper.Helper;

class EvenOdd {

    void run() {
        Helper.showGreetingMessage();

        boolean isRunning = true;
        while (isRunning) {
            String input = Helper.getUserInput("Введите строку: ").trim();
            if (input.equals("exit")) {
                isRunning = false;
                continue;
            }

            String evenOrOdd = Helper.getUserInput("Введите even или odd: ").trim().toLowerCase();
            if (evenOrOdd.equals("exit")) {
                isRunning = false;
                continue;
            }

            printEvenOrOddString(input, evenOrOdd);
            System.out.println("---------------------------------");
        }
    }

    private void printEvenOrOddString(String input, String evenOrOdd) {
        String even = "";
        String odd = "";

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                odd += input.charAt(i);
            } else {
                even += input.charAt(i);
            }
        }

        System.out.println(getEvenOrOdd(even, odd, evenOrOdd));
    }

    private String getEvenOrOdd(String even, String odd, String evenOrOdd) {
        String result;

        if (evenOrOdd.equals("even")) {
            result = even;
        } else if (evenOrOdd.equals("odd")) {
            result = odd;
        } else {
            result = "Неизвестная ошибка. Попробуйте еще раз.";
        }

        return result;
    }
}
