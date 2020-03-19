package homeworks.HW_4_strings.stringByIndexes;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class StringByIndexes {
    String input;
    String result = "";

    void run() {
        try {
            input = Helper.getStringInLoop().trim();

            while (true) {
                String message = "Write down the index (from 0 to " +
                        (input.length() - 1) + " inclusively): ";
                int index = Helper.getIntInLoop(message);
                updateResult(index);
                System.out.println(result);
            }
        } catch (CancellationException ignored) {}
    }

    private void updateResult(int i) {
        if (0 <= i && i < input.length()) {
            result += input.charAt(i);
        }
    }
}
