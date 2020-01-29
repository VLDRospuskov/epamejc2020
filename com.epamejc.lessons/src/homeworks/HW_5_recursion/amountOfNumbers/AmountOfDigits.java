package homeworks.HW_5_recursion.amountOfNumbers;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class AmountOfDigits {

    void run() {
        try {
            System.out.println(Helper.GREETING);

            while (true) {
                int input = Helper.getInt();
                System.out.println("Amount of digits in the number is: " + getDigits(input));
                System.out.println("---------------------------------------");
            }
        } catch (CancellationException ignored) {}
    }

    private int getDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        } else {
            return 1 + getDigits(n / 10);
        }
    }
}
