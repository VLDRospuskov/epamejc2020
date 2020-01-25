package homeworks.newYearHolidays.strings.evenOdd;

import homeworks.utility.helper.Helper;

class EvenOdd {
    private Helper helper = new Helper();

    void run() {
        String input = helper.getUserInput("Введите строку: ");
        input = input.trim();
        String evenOdd = helper.getUserInput("Введите even или odd: ");
        evenOdd = evenOdd.trim().toLowerCase();

        String result = getEvenOddString(input, evenOdd);

        System.out.println(result);
        helper.closeReader();
    }

    private String getEvenOddString(String input, String evenOdd) {
        String even = "";
        String odd = "";

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                odd += input.charAt(i);
            } else {
                even += input.charAt(i);
            }
        }

        if (evenOdd.equals("even")) {
            return even;
        } else if (evenOdd.equals("odd")) {
            return odd;
        }

        return "Неизвестная ошибка. Попробуйте еще раз.";
    }
}
