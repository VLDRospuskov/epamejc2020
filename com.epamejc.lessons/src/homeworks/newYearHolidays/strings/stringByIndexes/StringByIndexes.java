package homeworks.newYearHolidays.strings.stringByIndexes;

import homeworks.utility.helper.Helper;

class StringByIndexes {

    void run() {
        String input = Helper.getUserInput("Введите строку: ").trim();
        String output = "";

        boolean isRunning = true;
        while (isRunning) {
            String message = "Введите индекс символа (число от 0 до " + (input.length() - 1) + " включительно): ";

            String iString = Helper.getUserInput(message);
            if (iString.equals("exit")) {
                isRunning = false;
                continue;
            }

            int i = Helper.parseInt(iString);
            output = getUpdatedString(input, i, output);
            System.out.println(output);
        }
    }

    private String getUpdatedString(String input, int i, String output) {
        if (0 <= i && i < input.length()) {
            output += input.charAt(i);
        }

        return output;
    }
}
