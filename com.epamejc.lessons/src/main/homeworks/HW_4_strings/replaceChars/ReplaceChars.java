package homeworks.HW_4_strings.replaceChars;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class ReplaceChars {

    public void run() {
        try {
            System.out.println(Helper.GREETING);

            while (true) {
                String input = Helper.getString().trim();
                int chIndex1 = Helper.getInt("Write down the 1st index: ");
                int chIndex2 = Helper.getInt("Write down the 2nd index: ");
                printStringWithReplacedChars(input, chIndex1, chIndex2);
            }
        } catch (CancellationException ignored) {}
    }

    private void printStringWithReplacedChars(String input, int chIndex1, int chIndex2) {
        StringBuilder result = new StringBuilder();
        char ch1 = input.charAt(chIndex1);
        char ch2 = input.charAt(chIndex2);

        for (int i = 0; i < input.length(); i++) {
            if (i == chIndex1) {
                result.append(ch2);
            } else if (i == chIndex2) {
                result.append(ch1);
            } else {
                result.append(input.charAt(i));
            }
        }

        System.out.println(result);
        System.out.println("-------------------------------------");
    }

}
