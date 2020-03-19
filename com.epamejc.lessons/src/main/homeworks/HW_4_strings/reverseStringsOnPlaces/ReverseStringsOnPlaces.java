package homeworks.HW_4_strings.reverseStringsOnPlaces;

import homeworks.utility.helper.Helper;

class ReverseStringsOnPlaces {

    public void run() {
        String input = getUserInput();
        String[] strings = input.split(" ");
        String[] reversedStrings = getReversedStrings(strings);
        printStrings(reversedStrings);
    }

    private String getUserInput() {
        String input = Helper.getString("").trim();
        Helper.closeReader();
        return input;
    }

    private String[] getReversedStrings(String[] strings) {
        String[] reversedStrings = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(strings[i]);
            String str = stringBuilder.reverse().toString();

            reversedStrings[i] = str;
        }

        return reversedStrings;
    }

    private void printStrings(String[] reversedStrings) {
        for (String str : reversedStrings) {
            System.out.print(str + " ");
        }
    }

}
