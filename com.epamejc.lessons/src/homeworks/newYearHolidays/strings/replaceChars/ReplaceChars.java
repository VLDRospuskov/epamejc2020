package homeworks.newYearHolidays.strings.replaceChars;

import homeworks.utility.helper.Helper;

class ReplaceChars {

    void run() {
        Helper.showGreetingMessage();

        boolean isRunning = true;
        while (isRunning) {
            String s = Helper.getUserInput("Введите строку: ").trim();
            if (s.equals("exit")) {
                isRunning = false;
                continue;
            }

            int indexOfCh1 = Helper.parseInt(Helper.getUserInput("Введите первый индекс: "));
            int indexOfCh2 = Helper.parseInt(Helper.getUserInput("Введите второй индекс: "));

            String result = getStringWithReplacedChars(s, indexOfCh1, indexOfCh2);
            System.out.println(result);
            System.out.println("-------------------------------------");
        }
    }

    private String getStringWithReplacedChars(String s, int indexOfCh1, int indexOfCh2) {
        String result = "";
        char ch1 = s.charAt(indexOfCh1);
        char ch2 = s.charAt(indexOfCh2);

        for (int i = 0; i < s.length(); i++) {
            if (i == indexOfCh1) {
                result += ch2;
            } else if (i == indexOfCh2) {
                result += ch1;
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
