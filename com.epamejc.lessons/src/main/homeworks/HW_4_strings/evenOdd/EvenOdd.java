package homeworks.HW_4_strings.evenOdd;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class EvenOdd {

    void run() {
        try {
            System.out.println(Helper.GREETING);

            while (true) {
                String input = Helper.getString().trim();
                String evenOrOdd = Helper.getString("Write even or odd: ").trim().toLowerCase();
                printEvenOrOddString(input, evenOrOdd);
            }
        } catch (CancellationException ignored) {}
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
        System.out.println("---------------------------------");
    }

    private String getEvenOrOdd(String even, String odd, String evenOrOdd) {
        String result;

        if (evenOrOdd.equals("even")) {
            result = even;
        } else if (evenOrOdd.equals("odd")) {
            result = odd;
        } else {
            result = "The keyword doesn't match. Try again";
        }

        return result;
    }
}
